package com.mring.marketdata.web;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.net.URI;
import java.net.URISyntaxException;

@Controller("/")
public class IndexController {

    @Get()
    public HttpResponse index() throws URISyntaxException {
        return HttpResponse.redirect(new URI("/static/index.html"));
    }

}
