package com.example.imdb_project.Service;

import com.example.imdb_project.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ConcurrentHashMap;

public interface UserService {
    HttpStatus insert(User u);
    HttpStatus delete(int id);
    HttpStatus update(User u);
    String list();
    String user(int id);

    ConcurrentHashMap<Integer,String> upload(MultipartFile file);

    void uploadAsync(MultipartFile file);
}
