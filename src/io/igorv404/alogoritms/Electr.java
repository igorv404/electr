package io.igorv404.alogoritms;

import java.util.List;

public class Electr {
  private final int distance;
  private final List<Integer> bolts;

  public Electr(int distance, List<Integer> bolts) {
    this.distance = distance;
    this.bolts = bolts;
  }

  public double findTheLongestCable() {
    double length = 0;
    if (bolts.size() <= 50) {
      boolean isElementsInLimits = true;
      for (int bolt : bolts) {
        if (bolt < 1 || bolt > 100) {
          isElementsInLimits = false;
          break;
        }
      }
      if (isElementsInLimits) {
        boolean isLastWasChangedToOne = false;
        int index = 0;
        for (int bolt : bolts) {
          index++;
          if (index != bolts.size()) {
            if (isLastWasChangedToOne) {
              if (bolts.get(index) > 1) {
                length += Math.sqrt(Math.pow((bolts.get(index) - 1), 2) + Math.pow(this.distance, 2));
              } else {
                length += distance;
              }
              isLastWasChangedToOne = false;
            } else {
              double withNoChanges = Math.sqrt(Math.pow((bolts.get(index) - bolt), 2) + Math.pow(this.distance, 2));
              double withChanges = Math.sqrt(Math.pow((1 - bolt), 2) + Math.pow(this.distance, 2));
              if (withChanges > withNoChanges) {
                isLastWasChangedToOne = true;
                length += withChanges;
              } else {
                length += withNoChanges;
              }
            }
          }
        }
      } else {
        System.out.println("Elements must be in limit between 1 to 100");
      }
    } else {
      System.out.println("List is longer than 50 elements");
    }
    return length;
  }
}
