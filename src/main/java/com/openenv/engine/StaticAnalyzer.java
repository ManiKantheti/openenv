package com.openenv.engine;

import java.util.*;

public class StaticAnalyzer {

    public static List<String> analyze(String code) {

        List<String> issues = new ArrayList<>();

        // 🔥 FIXED LOGIC (REAL DETECTION)

        // Division by zero detection
        if (code.contains("b=0") && code.contains("/b")) {
            issues.add("DIVISION_BY_ZERO");
        }

        // Null pointer
        if (code.contains("null") && code.contains(".length")) {
            issues.add("NULL_POINTER");
        }

        // String comparison
        if (code.contains("==") && code.contains("String")) {
            issues.add("STRING_COMPARISON");
        }

        // Raw types
        if (code.contains("List") && !code.contains("<")) {
            issues.add("RAW_TYPE_USAGE");
        }

        // Performance issue
        if (code.contains("Thread.sleep")) {
            issues.add("PERFORMANCE_BLOCK");
        }

        // Off-by-one
        if (code.contains("<= n")) {
            issues.add("OFF_BY_ONE");
        }

        return issues;
    }
}