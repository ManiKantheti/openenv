package com.openenv.model;

import java.util.*;

public class CodeSnippet {

    public int id;
    public String code;

    // 🔥 MUST BE INITIALIZED
    public List<String> detectedIssues = new ArrayList<>();
    public List<String> agentIssues = new ArrayList<>();

    public boolean approved = false;
}