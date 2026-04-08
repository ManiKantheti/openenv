package com.openenv.service;

import com.openenv.model.CodeSnippet;
import java.util.*;

public class TaskService {

    public static List<CodeSnippet> load(String level) {

        List<CodeSnippet> list = new ArrayList<>();

        if ("easy".equals(level)) {
            CodeSnippet s = new CodeSnippet();
            s.id = 1;
            s.code = "int a=5; int b=0; int c=a/b;";
            list.add(s);
        }

        if ("medium".equals(level)) {
            CodeSnippet s1 = new CodeSnippet();
            s1.id = 1;
            s1.code = "String s=null; s.length();";

            CodeSnippet s2 = new CodeSnippet();
            s2.id = 2;
            s2.code = "for(int i=0;i<=n;i++){}";

            list.add(s1);
            list.add(s2);
        }

        if ("hard".equals(level)) {
            CodeSnippet s1 = new CodeSnippet();
            s1.id = 1;
            s1.code = "if(password == inputPassword){}";

            CodeSnippet s2 = new CodeSnippet();
            s2.id = 2;
            s2.code = "List list = new ArrayList();";

            CodeSnippet s3 = new CodeSnippet();
            s3.id = 3;
            s3.code = "Thread.sleep(1000);";

            list.add(s1);
            list.add(s2);
            list.add(s3);
        }

        return list;
    }
}