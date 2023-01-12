package com.mring.marketdata.domain;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class CandlestickData {
    private static final Gson GSON = new Gson();

    public final String type = "candlestick";
    public final String name = "price OHLC";
    public final List<String> x = new LinkedList<>();
    public final List<Double> open = new LinkedList<>();
    public final List<Double> high = new LinkedList<>();
    public final List<Double> low = new LinkedList<>();
    public final List<Double> close = new LinkedList<>();

    public void add(EODPoint point) {
        // TODO: check symbol?
        x.add(point.date().toString());
        open.add(point.open());
        high.add(point.high());
        low.add(point.low());
        close.add(point.close());
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
