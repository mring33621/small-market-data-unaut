package com.mring.marketdata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EODDataTest {

    @Test
    void getEodDataTable() {
        EODData eodData = new EODData("src/main/resources/eoddata/");
        System.out.println(eodData.getEodDataTable().rowCount());
        System.out.println(eodData.getEodDataTable().printAll());
    }
}