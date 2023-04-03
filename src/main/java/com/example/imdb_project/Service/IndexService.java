package com.example.imdb_project.Service;

import org.springframework.web.multipart.MultipartFile;

public interface IndexService {
    void read();

    void indexAsync(long numMovies);

    void indexCreation();

    void setReaders(MultipartFile akas, MultipartFile basics, MultipartFile crew, MultipartFile episode, MultipartFile principals, MultipartFile ratings);
}
