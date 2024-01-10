package com.example.service;

import java.sql.SQLOutput;
import java.util.Map;

public interface HomeworkService {
    Map<String, String> createHomework(Map<String, String> data);
    Map<String, String> getHomework(Map<String, String> data);
}
