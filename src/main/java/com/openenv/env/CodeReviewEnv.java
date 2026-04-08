package com.openenv.env;

import com.openenv.model.*;
import com.openenv.engine.StaticAnalyzer;
import com.openenv.service.RewardService;

import java.util.*;

public class CodeReviewEnv {

    private List<CodeSnippet> snippets;
    private String task;
    private int step = 0;
    private boolean done = false;

    public Observation reset(String t) {
        snippets = new ArrayList<>();
        snippets = com.openenv.service.TaskService.load(t);

        task = t;
        step = 0;
        done = false;

        return new Observation(snippets, task, step);
    }

    public Object[] step(Action action) {

        step++;

        for (CodeSnippet s : snippets) {

            if (s.id == action.snippetId) {

                // 🔥 FIX 1: ANALYZE (MAIN ISSUE)
                if ("analyze".equalsIgnoreCase(action.actionType)) {
                    List<String> detected = StaticAnalyzer.analyze(s.code);
                    s.detectedIssues.clear();
                    s.detectedIssues.addAll(detected);

                    System.out.println("Detected Issues: " + detected);
                }

                // REPORT
                if ("report".equalsIgnoreCase(action.actionType)) {
                    if (action.issue != null) {
                        s.agentIssues.add(action.issue);
                    }
                }

                // FIX
                if ("fix".equalsIgnoreCase(action.actionType)) {
                    s.agentIssues.add("fix_proposed");
                }

                // APPROVE
                if ("approve".equalsIgnoreCase(action.actionType)) {
                    s.approved = true;
                }
            }
        }

        Reward reward = RewardService.calculate(snippets, action, step);

        if (step >= 6) done = true;

        return new Object[]{
                new Observation(snippets, task, step),
                reward,
                done
        };
    }

    public List<CodeSnippet> state() {
        return snippets;
    }
}