package org.example;

import javax.swing.text.html.parser.Parser;


import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class packRLE  {






    public String packer(String s) {
        if (s.equals("")) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int count = 0;
        char prev = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                if (count > 1) res.append(count);
                res.append(prev);
                count = 0;
                prev = s.charAt(i);
            }
            count++;
        }
        if (count > 1) res.append(count);
        res.append(prev);
        return res.toString();
    }


    public String unpacker(String str) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                num = str.charAt(i);
            } else {

                for (int k = 0; k < num - 1; k++) {
                    res.append(str.charAt(i));
                }
            }
        }
        return res.toString();
    }


    public static void pRLE(boolean pack, String inputFile, String outputFile) {



    }
}
