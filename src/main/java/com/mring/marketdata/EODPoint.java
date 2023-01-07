package com.mring.marketdata;

import java.time.LocalDate;

public record EODPoint(String symbol, LocalDate date, double open, double high, double low, double close, long volume) {
}
