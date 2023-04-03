package com.example.imdb_project.Controller;

import com.example.imdb_project.Repositories.ElasticLowClientImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    @Autowired
    ElasticLowClientImpl elasticLowClient;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/search/{query}")
    public JSONObject getJSON(@PathVariable String query) {
        JSONObject json = new JSONObject();

        //Variable to store clusterName
        String clusterName = "";

        //Handle the exceptions that may arise
        try{
            clusterName = this.elasticLowClient.search();
        } catch (Exception e) {
            json.appendField("query", "Error");
            json.appendField("clusterName", "Error");
        }

        json.appendField("query", query);
        json.appendField("clusterName", clusterName);
        return json;
    }


}
