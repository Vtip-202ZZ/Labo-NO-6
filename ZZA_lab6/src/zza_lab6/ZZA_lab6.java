/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zza_lab6;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ZZA_lab6 {

    
    public static void main(String[] args) throws IOException {
        String country = "", language = "";
        System.out.println("1 – Английский");
        System.out.println("2 – Казахский");
        System.out.println("3 – Русский");
       
        char i = (char) System.in.read();
        switch (i) {
            case '1':
                language = "en";
                country = "UK";
                break;
            case '2':
                language = "kk";
                country = "KZ";
                break;
            case '3':
                language = "rus";
                country = "RU";
                break;
        }
        ResourceBundle rb = ResourceBundle.getBundle("text", new Locale(language, country));
        System.out.println(getStr(rb.getString("my.question"), rb.getString("utf16")));
        System.out.println(getStr(rb.getString("my.reply"), rb.getString("utf16")));
    //        System.out.println(rb.getString("my.question")); // Так делать нельзя для некоторых языков, например, белорусского
//        System.out.println(rb.getString("my.reply")); // Âîñü ó ÷ûì ïûòàííå. <- вот так иначе получится
    }
     
    
    
    public static String getStr(String text, String utf16) throws UnsupportedEncodingException {
        if (!utf16.equals("true")) {
            return new String(text.getBytes("ISO-8859-1"), "Windows-1251");
        } else {
            return text;
        }
    }
}
