package com.mring.marketdata.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CandlestickDataTest {

    @Test
    void testToString() {
        CandlestickData candlestickData = new CandlestickData();
        candlestickData.add(new EODPoint("AAAA", LocalDate.now(), 1d, 1d, 1d, 1d, 1L));
        candlestickData.add(new EODPoint("AAAA", LocalDate.now(), 2d, 2d, 2d, 2d, 2L));
        candlestickData.add(new EODPoint("AAAA", LocalDate.now(), 3d, 3d, 3d, 3d, 3L));
        System.out.println(candlestickData.toString());
    }
}