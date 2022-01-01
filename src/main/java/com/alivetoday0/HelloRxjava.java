package com.alivetoday0;

import io.reactivex.Observable;

public class HelloRxjava {
  public static void main(String[] args) {
    Observable<String> observable = Observable.just("hello", "RxJava");
    observable.subscribe(it -> System.out.println(it));
  }
}
