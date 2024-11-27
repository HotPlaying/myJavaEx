package com.test.experiment.threadtest;

import java.util.concurrent.*;

public class ThreeThreadImplement {

  public static void main(String[] args) {
    new Thread(() -> {
      System.out.println("传入runnable实例");
    }).start();

    new Thread() {
      public void run() {
        System.out.println("实现run方法");
      }
    }.start();

    final Callable<String> callable = new Callable<>() {
      @Override
      public String call() {
        return "实现callable实例";
      }
    };
    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    final Future<String> future = executorService.submit(callable);
    try {
      final String result = future.get();
      System.out.println(result);
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }
  }

}
