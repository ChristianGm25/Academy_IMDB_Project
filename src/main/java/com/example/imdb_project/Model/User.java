package com.example.imdb_project.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    int id;
    String name;
    String email;

    public int getId() {
        return id;
    }

    public User(@JsonProperty("id") int id,@JsonProperty("name") String name,@JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
