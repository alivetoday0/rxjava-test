package com.alivetoday0;

import io.reactivex.Flowable;

public class ColdPublisher {
  public static void main(String[] args) {
    Flowable<Integer> flowable = Flowable.just(1, 3, 5, 7);

    flowable.subscribe(it -> System.out.println("Subscriber 01: " + it));
    flowable.subscribe(it -> System.out.println("Subscriber 02: " + it));
  }
}
