package com.example.felixcity.retro1;

public class Users {

   private String name;
   private String email;
   private String password;
    private String c_password;


    public Users(String name, String email, String password, String c_password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.c_password = c_password;
    }

    public String getName() {
        return name;
    }
}
