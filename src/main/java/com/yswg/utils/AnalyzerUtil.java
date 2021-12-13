package com.yswg.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AnalyzerUtil {

    private static final String[] REPLACE_CHARS = {
            "/", "’", "|", "-",
    };
    private static final String[] WeedOutChar = {
            "for", "pieces", "with", "and",
            "inch", "inches", "x", "set",
            "party", "decor", "decoration",
            "women", "christmas", "home",
            "decorations", "birthday", "set",
            "halloween", "girls", "qty", "your",
            "and", "from", "into", "to", "diy",
            "size", "pack", "of", "by", "pairs",
            "compatible", "under", "in", "cm", "pcs",
            "pc","st","day","xs","xl","xxl",
            //颜色单词
            "white", "beige", "brown", "black", "red", "blue", "green", "purple", "yellow", "pink", "pink"
    };

    private static List<String> doToken(TokenStream ts) throws IOException {
        List<String> str_arr = new ArrayList<>();
        ts.reset();
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        while (ts.incrementToken()) {
            if (term.toString().length()==1){
                continue;
            }
            Pattern p = Pattern.compile(".*\\d+.*");
            Matcher m = p.matcher(term.toString());
            if (m.matches()) {
                continue;
            }

            String content = Inflector.getInstance().singularize(term.toString());
            if (!str_arr.contains(content)) {
                str_arr.add(content);
            }
        }
        str_arr.removeIf(s -> Arrays.asList(WeedOutChar).contains(s));
        List<String> arr=str_arr.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        ts.end();
        ts.close();
        return arr;
    }

    public static List<String> getAnalyzer(String s) throws IOException {

        // Lucene core模块中的 StandardAnalyzer 英文分词器
        Analyzer ana = new StandardAnalyzer();
        TokenStream ts = ana.tokenStream("", s);
        return doToken(ts);
    }
}
