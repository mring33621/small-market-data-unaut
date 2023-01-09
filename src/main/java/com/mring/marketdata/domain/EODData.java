package com.mring.marketdata.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tablesaw.api.Table;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class EODData {

    private static final Logger logger
            = LoggerFactory.getLogger(EODData.class);

    private Table eodDataTable = null;

    public Table getEodDataTable() {
        return eodDataTable;
    }

    private static Table csvToTable(Path csvFilePath) {
        return Table.read().csv(csvFilePath.toFile());
    }

    public EODData(String dataDir) {
        try (Stream<Path> paths = Files.walk(Paths.get(dataDir))) {
            final List<Table> csvTables = paths
                    .filter(Files::isRegularFile)
                    .filter(f -> f.getFileName().toString().endsWith(".csv"))
                    .peek(System.out::println)
                    .map(EODData::csvToTable)
                    .toList();
            Table combinedResults = null;
            // NOTE: Empty Tables cannot be appended to, which made it more difficult to use reduce/collect.
            for (Table csvTable : csvTables) {
                if (combinedResults == null) {
                    // we will append all others to the first table in the list
                    combinedResults = csvTable;
                } else {
                    combinedResults.append(csvTable);
                }
            }
            // remove date from the table/file name
            combinedResults.setName(combinedResults.name().split("_")[0]);
            this.eodDataTable = combinedResults;
        } catch (RuntimeException rex) {
            throw rex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


}
