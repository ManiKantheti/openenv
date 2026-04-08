package com.openenv.service;

import com.openenv.model.*;
import java.util.*;

public class GraderService {

    public static double grade(List<CodeSnippet> snippets) {

        double score = 0;

        for (CodeSnippet s : snippets) {

            int correct = 0;

            for (String real : s.detectedIssues) {
                if (s.agentIssues.contains(real)) {
                    correct++;
                }
            }

            if (!s.detectedIssues.isEmpty()) {
                score += (double) correct / s.detectedIssues.size();
            }

            if (s.approved) score += 0.2;
        }

        return Math.min(score, 1.0);
    }
}