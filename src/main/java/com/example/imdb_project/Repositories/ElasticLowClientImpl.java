package com.example.imdb_project.Repositories;

import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import com.example.imdb_project.Configuration.ElasticSearchConfiguration;
import com.example.imdb_project.Model.Movie;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class ElasticLowClientImpl implements ElasticLowClient {

    private static final String indexName = "movies";
    private final ElasticSearchConfiguration elasticSearchConfiguration;

    public ElasticLowClientImpl(ElasticSearchConfiguration elasticSearchConfiguration){
        this.elasticSearchConfiguration = elasticSearchConfiguration;
    }

    @Override
    public String search() throws IOException {
        return elasticSearchConfiguration.elasticsearchClient().cluster().health().clusterName();
    }

    public void indexCreation(){
        final String assetJsonSource = "src/main/java/co/empathy/academy/search/Configuration/my_index_settings.json";
        try (InputStream input = new FileInputStream(assetJsonSource)) {
            CreateIndexRequest request =
                    CreateIndexRequest.of(builder -> builder.index(indexName).withJson(input));
        } catch (IOException e) {
            System.out.println("Failed to create an index");
        }
    }

    public void indexMovies(List<Movie> movies){

    }


}