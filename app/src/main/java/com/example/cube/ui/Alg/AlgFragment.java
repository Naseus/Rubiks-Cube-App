package com.example.cube.ui.Alg;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.cube.R;
import com.example.cube.databinding.FragmentAlgBinding;
import com.example.cube.models.Algorithm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class AlgFragment extends Fragment {

    private static String TAG = "AlgFragment";
    private RecyclerView rvAlgs;
    private List<Algorithm> algs = new ArrayList<>();
    private String cat = "OLL";
    private String API_BASE_URL;
    private AlgorithmAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alg, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle SavedInstanceState) {
        super.onViewCreated(view, SavedInstanceState);

        cat = getArguments().getString("Category");


        makeRequest(cat);

        rvAlgs = view.findViewById(R.id.rv_algs);

        adapter = new AlgorithmAdapter(getContext(), algs);
        rvAlgs.setAdapter(adapter);
        rvAlgs.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void makeRequest(String extension){
        AsyncHttpClient client = new AsyncHttpClient();
        API_BASE_URL = getString(R.string.api_site);
        client.get(API_BASE_URL + "/cube/" + extension, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JsonHttpResponseHandler.JSON json) {
                //try {
                    JSONArray jsonArray = json.jsonArray;
                    algs.addAll(Algorithm.fromJSONArray(jsonArray));
                    adapter.notifyDataSetChanged();
                    Log.d(TAG, algs.toString());
                //} catch (JSONException e) {
                //    Log.e(TAG, "Json Exception", e);
                //}
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Algorithm alg = new Algorithm();
                alg.setAlgName("FAIL");
                alg.setMoves("FAIL");
                alg.setType("FAIL");
                algs.add(alg);
                adapter.notifyDataSetChanged();
                Log.e(TAG, "Fail on resource call " + API_BASE_URL +"/cube/" + extension);
            }
        });
    }
}