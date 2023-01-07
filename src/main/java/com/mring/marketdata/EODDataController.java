package com.mring.marketdata;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.views.View;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller("/eoddata")
public class EODDataController {

    // TODO: configure/inject
    // TODO: thread safety?
    private final EODData eodData = new EODData("src/main/resources/eoddata/");

    @Get("/head")
    public String head() {
        return eodData.getEodDataTable().print(10);
    }

    Optional<Table> queryBySymbol(String symbol) {
        if (StringUtils.hasText(symbol)) {
            final Table t = eodData.getEodDataTable();
            return Optional.of(t.where(t.stringColumn(0).matchesRegex(symbol)).sortOn(0, 1));
        }
        return Optional.empty();
    }

    @Get("/queryBySymbol.txt")
    public String queryBySymbolReturnsText(@Nullable @QueryValue("symbol") String symbol) {
        final Optional<Table> results = queryBySymbol(symbol);
        return results.isPresent() ? results.get().printAll() : "Please specify a symbol.";
    }

    @View("queryBySymbol")
    @Get("/queryBySymbol.html")
    public HttpResponse queryBySymbolReturnsHtml(@Nullable @QueryValue("symbol") String symbol) {
        final Optional<Table> results = queryBySymbol(symbol);
        final List<EODPoint> points = new LinkedList<>();
        if (results.isPresent()) {
            for (Row row : results.get()) {
                EODPoint point = new EODPoint(
                        row.getString(0),
                        row.getDate(1),
                        row.getDouble(2),
                        row.getDouble(3),
                        row.getDouble(4),
                        row.getDouble(5),
                        row.getInt(6));
                points.add(point);
            }
        }
        return HttpResponse.ok(CollectionUtils.mapOf("points", points));
    }
}
