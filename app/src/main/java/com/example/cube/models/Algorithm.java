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
        AlgName =jsonObject.getString("alg_name");
        Type = jsonObject.getString("classification");
        Moves = jsonObject.getString("moves");
    }

    public static List<Algorithm> fromJSONArray(JSONArray jsonArray) {
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

    public String getAlgName() {
        return AlgName;
    }

    public void setAlgName(String algName) {
        AlgName = algName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMoves() {
        return Moves;
    }

    public void setMoves(String moves) {
        Moves = moves;
    }
}
