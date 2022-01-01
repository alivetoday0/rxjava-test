package com.alivetoday0;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class BackPressureDropLatestStrategy {

  public static void main(String[] args) throws InterruptedException {
    Flowable.interval(300L, TimeUnit.MILLISECONDS)
        .doOnNext(data -> System.out.println("#interval doOnNext()" + data))
        .onBackpressureBuffer(2,  // 버퍼 사이즈
            () -> System.out.println("overflow"),
            BackpressureOverflowStrategy.DROP_LATEST)
        .doOnNext(data -> System.out.println("#onBackpressureBuffer doOnNext()" + data))
        .observeOn(Schedulers.computation(), false, 1)  // bufferSize는 처리하는 개수이다.
        .subscribe(
            data -> {
              Thread.sleep(1000L);
              System.out.println("subscribe " + data);
            },
            error -> System.out.println("subscribe error " + error));

    Thread.sleep(2000L);
  }
}
