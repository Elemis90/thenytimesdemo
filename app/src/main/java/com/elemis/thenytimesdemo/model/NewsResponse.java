package com.elemis.thenytimesdemo.model;

import java.util.ArrayList;

/**
 * Created by elemis on 2018. 02. 24..
 */

public class NewsResponse {
    private ArrayList<News> results;

    public ArrayList<News> getResults() {
        return results;
    }

    public void setResults(ArrayList<News> results) {
        this.results = results;
    }
}
