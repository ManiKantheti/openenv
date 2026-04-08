package com.openenv.service;

import com.openenv.model.*;
import java.util.*;

public class RewardService {

    public static Reward calculate(List<CodeSnippet> snippets, Action action, int step) {

        double score = 0;
        String msg = "";

        for (CodeSnippet s : snippets) {

            // 🔥 Match detected vs agent issues
            for (String detected : s.detectedIssues) {
                for (String agent : s.agentIssues) {
                    if (detected.equalsIgnoreCase(agent)) {
                        score += 0.5;
                        msg = "Correct issue reported";
                    }
                }
            }

            // Fix reward
            if (s.agentIssues.contains("fix_proposed")) {
                score += 0.3;
            }

            // Approval reward
            if (s.approved && s.detectedIssues.isEmpty()) {
                score += 0.2;
            }
        }

        if (step > 6) score -= 0.2;

        return new Reward(Math.min(score, 1.0), msg);
    }
}