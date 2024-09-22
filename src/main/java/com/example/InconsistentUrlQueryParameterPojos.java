package com.example;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.Map;

@Controller
public class InconsistentUrlQueryParameterPojos {

    static final String PATH_WITH_PARAMS = "/test{?query*}";

    @Get(PATH_WITH_PARAMS)
    Map<String, String> get(Map<String, String>query) {
        return query;
    }

    @Post(PATH_WITH_PARAMS)
    Map<String, String> post(Map<String, String>query, @Body Map<String, Object>body) {
        return query;
    }
}