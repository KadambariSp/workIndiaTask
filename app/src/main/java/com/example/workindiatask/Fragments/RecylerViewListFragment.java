package com.example.workindiatask.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workindiatask.Adapter.itemAdapter;
import com.example.workindiatask.MainActivity;
import com.example.workindiatask.Model.itemModel;
import com.example.workindiatask.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RecylerViewListFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Object> viewItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final String TAG="MainActivity";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recyler_view_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new itemAdapter(getActivity(), viewItems);
        recyclerView.setAdapter(mAdapter);

        getData();
        return view;
    }

    private void getData() {
        try {
            String jsonData = readJSONFromFile();
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject itemObj = jsonArray.getJSONObject(i);
                String name = itemObj.getString("name");
                String price = itemObj.getString("price");
                String extra = itemObj.getString("extra");
                itemModel model;
                if(extra.equals("null")) {
                     model = new itemModel(name, price, "");
                }
                else
                {
                     model = new itemModel(name, price, extra);
                }

                viewItems.add(model);

            }
        } catch (JSONException | IOException e) {
            Log.d(TAG,"getData",e);
        }
    }
    private String readJSONFromFile() throws IOException {
        InputStream inputStream=null;
        StringBuilder builder=new StringBuilder();
        try{
            String jsonString=null;
            inputStream=getResources().openRawResource(R.raw.items);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            while((jsonString =bufferedReader.readLine())!=null)
            {
                builder.append(jsonString);
            }
        }
        finally{
            if(inputStream!=null)
            {
                inputStream.close();
            }
        }
        return new String(builder);

    }





}