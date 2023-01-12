package com.mring.marketdata.domain;

import com.google.gson.Gson;

public class EODPointWebTableRow {

    private static final Gson GSON = new Gson();

    private final EODPoint eodPoint;
    private int rowsInGroup;
    private boolean firstRow;
    private CandlestickData candlestickData;
    private VolumeChartData volumeChartData;

    public EODPointWebTableRow(EODPoint eodPoint) {
        this.eodPoint = eodPoint;
    }

    public EODPoint getEodPoint() {
        return eodPoint;
    }

    public int getRowsInGroup() {
        return rowsInGroup;
    }

    public void setRowsInGroup(int rowsInGroup) {
        this.rowsInGroup = rowsInGroup;
    }

    public boolean isFirstRow() {
        return firstRow;
    }

    public void setFirstRow(boolean firstRow) {
        this.firstRow = firstRow;
        if (firstRow) {
            this.candlestickData = new CandlestickData();
            this.volumeChartData = new VolumeChartData();
        }
    }

    public String getSymbol() {
        return eodPoint.symbol();
    }

    public CandlestickData getCandlestickData() {
        return candlestickData;
    }

    public VolumeChartData getVolumeChartData() {
        return volumeChartData;
    }

    public String toChartJson() {
        return GSON.toJson(new Object[] {candlestickData, volumeChartData});
    }
}
