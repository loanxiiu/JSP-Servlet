package view;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        String s1 = rand.nextInt(10) + "";
        String s2 = rand.nextInt(10) + "";
        String s3 = rand.nextInt(10) + "";
        String s4 = rand.nextInt(10) + "";
        String s5 = rand.nextInt(10) + "";
        String s6 = rand.nextInt(10) + "";

        String s = s1 + s2 + s3 + s4 + s5 + s6;
    }
}
