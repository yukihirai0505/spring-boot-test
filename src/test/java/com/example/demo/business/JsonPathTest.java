package com.example.demo.business;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    @Test
    public void learning() {
        String responseFromService = "[\n" +
                "  {\n" +
                "    \"id\": 10000,\n" +
                "    \"name\": \"Pencil\",\n" +
                "    \"quantity\": 5\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 10001,\n" +
                "    \"name\": \"Pen\",\n" +
                "    \"quantity\": 15\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 10002,\n" +
                "    \"name\": \"Eraser\",\n" +
                "    \"quantity\": 10\n" +
                "  }\n" +
                "]";
        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).contains(10000,10001,10002);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());
    }
}
