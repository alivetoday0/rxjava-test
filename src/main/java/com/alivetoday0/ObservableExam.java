package com.alivetoday0;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservableExam {

  public static void main(String[] args) throws InterruptedException {
    Observable<String> observable = Observable.create(emitter -> {
        String[] data = {"java", "hello"};
        for (String string : data) {
          if (emitter.isDisposed()) {
            return;
          }

          // 데이터 전달 subscribe.onNext() 호출
          emitter.onNext(string);
        }

        // 데이터 전달 완료 subscribe.onComplete() 호출
        emitter.onComplete();
      });

    observable.observeOn(Schedulers.computation())
        .subscribe(
            data -> System.out.println("#Subscriber onNext " + data),
            error -> System.out.println("#Subscriber onError " + error),
            () -> System.out.println("#Subscriber onComplete "),
            disposable -> System.out.println("#Subscriber do noting"));

    Thread.sleep(5000L);
  }
}
