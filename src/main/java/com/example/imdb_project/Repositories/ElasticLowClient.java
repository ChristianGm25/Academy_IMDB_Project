package com.example.imdb_project.Repositories;

import java.io.IOException;


public interface ElasticLowClient {
    String search() throws IOException;

}
