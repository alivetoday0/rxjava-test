package com.alivetoday0;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MissingBackPressureException {

  public static void main(String[] args) throws InterruptedException {
    Flowable.interval(1L, TimeUnit.MILLISECONDS)
        .doOnNext(data -> System.out.println(data))
        .observeOn(Schedulers.computation())
        .subscribe(data -> {
          System.out.println("소비자 처리 대기 중");
          Thread.sleep(1000);
          System.out.println(data);
        },
            error -> System.out.println(error),
            () -> System.out.println("완료"));

    Thread.sleep(2000L);
  }
}
