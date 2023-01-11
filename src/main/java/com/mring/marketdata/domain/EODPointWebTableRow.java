package com.mring.marketdata.domain;

public class EODPointWebTableRow {
    private final EODPoint eodPoint;
    private int rowsInGroup;
    private boolean firstRow;
    private CandlestickData candlestickData;

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
        }
    }

    public String getSymbol() {
        return eodPoint.symbol();
    }

    public CandlestickData getCandlestickData() {
        return candlestickData;
    }
}
