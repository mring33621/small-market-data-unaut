package com.mring.marketdata;

import com.mring.marketdata.domain.EODData;
import org.junit.jupiter.api.Test;

class EODDataTest {

    @Test
    void getEodDataTable() {
        EODData eodData = new EODData("src/main/resources/eoddata/");
        System.out.println(eodData.getEodDataTable().rowCount());
        System.out.println(eodData.getEodDataTable().printAll());
    }
}