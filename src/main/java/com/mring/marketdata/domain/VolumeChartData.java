package com.mring.marketdata.domain;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class VolumeChartData {

    private static final Gson GSON = new Gson();

    public final String type = "bar";
    public final String name = "volume";
    public final List<String> x = new LinkedList<>();
    public final List<Long> y = new LinkedList<>();
    public final String xaxis = "x2";
    public final String yaxis = "y2";
    public final Marker marker = new Marker("#e0e0e0");

    public void add(EODPoint point) {
        // TODO: check symbol?
        x.add(point.date().toString());
        y.add(point.volume());
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
