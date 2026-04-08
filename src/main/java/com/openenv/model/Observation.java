package com.openenv.model;

import java.util.List;

public class Observation {

    public List<CodeSnippet> snippets;
    public String task;
    public int step;

    public Observation(List<CodeSnippet> snippets, String task, int step) {
        this.snippets = snippets;
        this.task = task;
        this.step = step;
    }
}