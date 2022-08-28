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
    match('+');
    System.out.println("mov %eax, %ebx");
    System.out.println("mov $" + getNum() + ", %eax");
    System.out.println("add %ebx, %eax");
  }

  private static void match(char c) throws IOException, ParseExpection {
    if (lookahead == c) {
      lookahead = (char) System.in.read();
    } else {
      throw new ParseExpection("'" + c + "' expected.");
    }
  }

  private static char getNum() throws IOException, ParseExpection {
    if (!Character.isDigit(lookahead)) {
      throw new ParseExpection("Integer expected.");
    }
    char result = lookahead;
    lookahead = (char) System.in.read();
    return result;
  }
}
