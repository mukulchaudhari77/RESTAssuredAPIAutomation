package com.demo.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Formatter {

    public static JsonPath convertResponseToJsonPath(Response response) {
        return new JsonPath(response.asString());
    }
}
