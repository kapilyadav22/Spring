package com.kapil;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student(1,"Kapil",26);
        System.out.println(student);

        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(student);
        System.out.println(object);
        }
}