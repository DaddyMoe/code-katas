package com.euromoney.code.katas;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by moses.mansaray on 29/09/2015.
 */
public class JsonValueFinder {
    String jsonWithSingleObject = "{\n" +
            "    \"name\": \"William Shakespeare\"}";

    String jsonWithNestedObject = "{\"wife\": {\"birthYear\": \"1555\"}}";
    String jsonExample1 = "{\n" +
            "    \"name\": \"William Shakespeare\",\n" +
            "    \"wife\": {\n" +
            "        \"birthYear\": 1555,\n" +
            "        \"deathYear\": \"Fun fact, she's a vampire\",\n" +
            "        \"name\": \"Anne Hathaway\",\n" +
            "        \"dead\": false\n" +
            "    },\n" +
            "    \"favoriteWebsites\": [\n" +
            "        \"dailysonneter\",\n" +
            "        \"dailyprogrammer\",\n" +
            "        \"vine (he's way into 6-second cat videos)\"\n" +
            "    ],\n" +
            "    \"dead\": true,\n" +
            "    \"birthYear\": 1564,\n" +
            "    \"facebookProfile\": null,\n" +
            "    \"selectedWorks\": [\n" +
            "        {\n" +
            "            \"written\": 1606,\n" +
            "            \"name\": \"The Tragedy of Macbeth\",\n" +
            "            \"isItAwesome\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"written\": 1608,\n" +
            "            \"name\": \"Coriolanus\",\n" +
            "            \"isItAwesome\": \"It's alright, but kinda fascist-y\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"deathYear\": 1616\n" +
            "}";


    @Test
    public void shouldNotBeNull() throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject(jsonWithSingleObject);

        assertTrue(jsonObject != null);
    }

    @Test
    public void shouldReturnJsobnObjectOfValue() throws JSONException, IOException {
        String valueToFind = "William Shakespeare";
        String result = "";
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = mapper.readTree(jsonWithSingleObject);
        Map<String, String> jsonKeyValues = new HashMap<String, String>();

        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            jsonKeyValues.put(field.getKey(), field.getValue().textValue());
            if (field.getValue().textValue().equals(valueToFind)) {
                result = field.getKey();
            }
        }
        assertEquals(result, "name");
    }

    @Test
    public void shouldReturnJsobnObjectOfPath() throws JSONException, IOException {
        String valueToFind = "1555";
        String result = "";
        String expected = "wife -> birthYear";
        result = getPath(valueToFind, result);

//        Iterator<Map.Entry<String, JsonNode>> objectsIterator = rootNode.fields();

            //TODO : Fix
//        assertEquals(result, expected);

    }

    private String getPath(String valueToFind, String result) throws IOException {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = mapper.readTree(jsonWithNestedObject);
        Map<String, String> jsonKeyValues = new HashMap<String, String>();

        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            jsonKeyValues.put(field.getKey(), field.getValue().textValue());
            System.out.println(field.getValue().getNodeType().toString());
            if ((field.getValue().getNodeType().toString().equals("STRING") && field.getValue().textValue().equals(valueToFind))) {

                if (field.getValue().toString() == valueToFind)
                    result = field.getKey();
            }
        }

        Iterator<Map.Entry<String, JsonNode>> objectsIterator = rootNode.fields();

        return result;
    }
}
