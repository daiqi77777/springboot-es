package com.yswg;

import com.yswg.entity.mysql.MysqlCompetitorInfo;
import com.yswg.repository.MysqlCompetitorInfoRepository;
import com.yswg.utils.AnalyzerUtil;
import com.yswg.utils.Inflector;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.util.Date;
import java.util.List;


public class test {
    @Autowired
    MysqlCompetitorInfoRepository mysqlCompetitorInfoRepository;

    public static void main(String[] args) throws IOException {

       /* String s = "Jewelry Sets Beaded Necklace and Beads Bracelet for Kids Girls 10 Sets Unicorn Cat Bird Owl Necklace and Beads Little Favors Bags for Girls Princess Dress Up Pretend Play";;
        List<String> str_arr = AnalyzerUtil.getAnalyzer(s);
        System.out.println(str_arr);*/

        //复数转单数
        String s1 = Inflector.getInstance().singularize("women");
        String s2 = Inflector.getInstance().singularize("toys");
        String s3 = Inflector.getInstance().singularize("supplies");
        System.out.println(s1+"  "+s2+"  "+s3);
    }
}
