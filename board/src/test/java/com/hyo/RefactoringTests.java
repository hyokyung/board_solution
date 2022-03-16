package com.hyo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class RefactoringTests {
  // TODO 공격력 테스트 만들기
  @Test
  public void attacTest() {
    Sword sword = new Sword(5);
    // 공격력은 Man.power + sword.power
    Man attacker = new Man(10, 20, sword);
    Man defender = new Man(10, 20, null);

    // TODO 한번 공격 체력 5남고 살기
    defender = attacker.atack(defender);
    assertEquals(5, defender.getHelth());

    // TODO 두번 공격 체력 0, 죽기
    defender = attacker.atack(defender);
    assertEquals(0, defender.getHelth());

    int loseExpr = 3;
    int winExpr = 10;

    // TODO 죽은 캐릭터의 경험치 업데이트

    // TODO 이긴 캐릭터의 경험치 업데이트
  }

  @RequiredArgsConstructor
  @Getter
  public class Sword {
    private final int power;
  }

  // TODO 방어력 부여 아아템 테스트

  // TODO 공격력이 방어력보다 3배 이상일때 테스트


  @RequiredArgsConstructor
  @Getter
  public class Man {
    private final int power;
    private final int helth;
    private final Sword sword;

    private Status status;

    public Man atack(Man defender) {
      int powerSum = this.power + this.sword.getPower();
   //   defender.changeStatus(new Status());
      int remainHealth = defender.getHelth() - powerSum;
      // FIXME 3항 연산 개선
     // remainHealth = calHealth(remainHealth);

      return new Man(defender.getPower(), 0, defender.getSword());
    }

    protected void changeStatus(Status changedStatus) {

    }

  }

  @RequiredArgsConstructor
  public class Status {
      public final int expr;
      public final String stat;
      public final int level;
  }



}
