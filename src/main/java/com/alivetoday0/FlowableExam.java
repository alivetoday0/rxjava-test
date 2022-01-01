package com.alivetoday0;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class FlowableExam {

  public static void main(String[] args) throws InterruptedException {
    Flowable<String> flowable = Flowable.create(emitter -> {
        String[] data = {"java", "hello"};
        for (String string : data) {
          if (emitter.isCancelled()) {
            return;
          }

          // 데이터 전달 subscribe.onNext() 호출
          emitter.onNext(string);
        }

        // 데이터 전달 완료 subscribe.onComplete() 호출
        emitter.onComplete();
      }, BackpressureStrategy.BUFFER);

    flowable.observeOn(Schedulers.computation())
        .subscribe(
            data -> System.out.println("#Subscriber onNext " + data),
            error -> System.out.println("#Subscriber onError " + error),
            () -> System.out.println("#Subscriber onComplete "),
            subscription -> subscription.request(Long.MAX_VALUE));

    Thread.sleep(5000L);
  }
}
