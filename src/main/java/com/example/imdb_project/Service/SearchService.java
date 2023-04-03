package com.example.imdb_project.Service;

import net.minidev.json.parser.ParseException;

import java.io.IOException;

public interface SearchService {
    String search(String query) throws IOException, ParseException, InterruptedException;

}
