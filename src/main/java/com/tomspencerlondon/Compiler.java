package com.tomspencerlondon;

import java.io.IOException;

public class Compiler {
  private static char lookahead;

  public static void main(String[] args) throws IOException {
    lookahead = (char) System.in.read();
    try {
      expression();
    } catch (ParseExpection e) {
      System.out.println(e.getMessage());
    }
  }

  private static void expression() throws IOException, ParseExpection {
    System.out.println("mov $" + getNum() + ", %eax");
  }

  private static char getNum() throws IOException, ParseExpection {
    if (!Character.isDigit(lookahead)) {
      throw new ParseExpection("Integer expected.");
    }

    return lookahead;
  }
}
