package com.alivetoday0;

import io.reactivex.processors.PublishProcessor;

public class HotPublisher {
  public static void main(String[] args) {
    PublishProcessor<Integer> processor = PublishProcessor.create();
    processor.subscribe(it -> System.out.println("Subscriber 01: " + it));
    processor.onNext(1);
    processor.onNext(3);

    processor.subscribe(it -> System.out.println("Subscriber 02: " + it));
    processor.onNext(5);
    processor.onNext(7);
  }
}
