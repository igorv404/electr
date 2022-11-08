package io.igorv404;

import io.igorv404.alogoritms.Electr;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    int distance = 4;
    List<Integer> bolts = Arrays.asList(100, 2, 100, 2, 100);
    Electr electr = new Electr(distance, bolts);
    System.out.println(electr.findTheLongestCable());
  }
}
