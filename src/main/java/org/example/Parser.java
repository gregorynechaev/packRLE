package org.example;

import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Parser {

    @Option(name = "-z", usage = "packing file", forbids = {"-u"})
    private boolean pack = false;

    @Option(name = "-u", usage = "unpacking file", forbids = {"-z"})
    private boolean unpack = false;


    @Option(name = "-out", usage = "output to this file", metaVar = "OUTPUT")
    private String out;


    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) {
        new Parser().parseArgs(args);
    }

    public void parseArgs(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            throw new IllegalArgumentException("");
        }


        String input = arguments.get(1);


        packRLE p = new packRLE();
        p.RLE(pack, input, out);

    }
}

