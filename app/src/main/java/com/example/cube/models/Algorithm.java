package com.example.cube.models;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    String AlgName;
    String Type;
    String Moves;

    public Algorithm(){ }

    public Algorithm(JSONObject jsonObject) throws JSONException {
        AlgName =jsonObject.getString("Alg name");
        Type = jsonObject.getString("Classification");
        Moves = jsonObject.getString("Moves");
    }

    public List<Algorithm> fromJSONArray(JSONArray jsonArray) {
        List<Algorithm> algorithms = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++) {
            try {
                algorithms.add(new Algorithm(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return algorithms;
    }
}
