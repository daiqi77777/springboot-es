package com.yswg;

import com.yswg.utils.AnalyzerUtil;
import com.yswg.utils.Inflector;
import org.apache.tomcat.util.buf.StringUtils;


import java.io.IOException;
import java.util.List;


public class test {
    public static void main(String[] args) throws IOException {
       /* String s = "Jewelry Sets Beaded Necklace and Beads Bracelet for Kids Girls 10 Sets Unicorn Cat Bird Owl Necklace and Beads Little Favors Bags for Girls Princess Dress Up Pretend Play";;
        List<String> str_arr = AnalyzerUtil.getAnalyzer(s);
        System.out.println(str_arr);*/

        //复数转单数
        List<String> str_arr = AnalyzerUtil.getAnalyzer("4 Pieces Hippie Costume Set, Include Colorful Tie-Dye T-Shirt, Peace Sign Necklace, Headband and Sunglasses for Theme Parties (S, Rainbow)");
        System.out.println( StringUtils.join(str_arr, ','));
    }
}
