package com.mring.marketdata.domain;

import java.util.LinkedList;
import java.util.List;

public class VolumeChartData {

    public final String type = "bar";
    public final String name = "volume";
    public final List<String> x = new LinkedList<>();
    public final List<Long> y = new LinkedList<>();
    public final String xaxis = "x2";
    public final String yaxis = "y2";
    public final Marker marker = new Marker("#e0e0e0");

    void add(EODPoint point) {
        // TODO: check symbol?
        x.add(point.date().toString());
        y.add(point.volume());
    }
}
