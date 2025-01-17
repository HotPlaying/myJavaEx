package com.test.experiment.threadtest;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class MultiThreadTest {
  private final StampedLock stampedLock = new StampedLock();

  /**
   * 测试读写重入锁计数器
   */
  @Test
  public void test01() {
    RWLockMultiCounter RWLockMultiCounter = new RWLockMultiCounter();
    System.out.println(RWLockMultiCounter.equals(new RWLockMultiCounter()));
  }

  /**
   * 测试wait()和sleep
   */
  @Test
  public void test02() {
    DefaultCounter c1 = new DefaultCounter();

    class AddCounter extends Thread {
      @Override
      public void run() {
        int timer = 0;
        while (c1.get() < 30) {
          timer++;
          if (timer % 10 == 0) {
            synchronized (c1) {
              c1.add();
              System.out.printf("(%s, %d) = %d \n", this.getName(), timer, c1.get());
            }
          }
        }
      }
    }

    Thread t1 = new AddCounter() {
      @Override
      public void run() {
        super.run();
        if (c1.get() == 25) {
          synchronized (c1) {
            System.out.printf("%s is wait() \n", this.getName());
            c1.notify();
          }
        }
      }
    };
    Thread t2 = new AddCounter() {
      @Override
      public void run() {
        super.run();
        if (c1.get() == 15) {
          try {
            sleep(4);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };
    Thread t3 = new AddCounter() {
      @Override
      public void run() {
        super.run();
        if (c1.get() == 10) {
          try {
            synchronized (c1) {
              System.out.printf("%s is wait() \n", this.getName());
              c1.wait();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

      }
    };

    t1.start();
    t2.start();
    t3.start();


  }

  /**
   * 测试wait()和sleep
   * 相比test02换成成了可重入读写锁的计数器
   */
  @Test
  public void test03() {
    RWCounter c1 = new RWCounter();

    class AddCounter extends Thread {
      @Override
      public void run() {
        int timer = 0;
        while (c1.get() < 30) {
          timer++;
          if (timer % 1000 == 0) {
            c1.add();
            System.out.printf("(%s, %d) = %d \n", this.getName(), timer, c1.get());

          }
        }
      }
    }

    Thread t1 = new AddCounter() {
      @Override
      public void run() {
        if (c1.get() == 25) {
          System.out.printf("%s is wait() \n", this.getName());
          c1.notify();
        }
        super.run();
      }
    };
    Thread t2 = new AddCounter() {
      @Override
      public void run() {

        if (c1.get() == 15) {
          try {
            sleep(4);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };
    Thread t3 = new AddCounter() {
      @Override
      public void run() {
        super.run();
        if (c1.get() == 10) {
          try {
            synchronized (c1) {
              System.out.printf("%s is wait() \n", this.getName());
              c1.wait();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

      }
    };

    t1.start();
    t2.start();
    t3.start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * 继续测sleep() 和 wait()
   * 相比test03()
   * 不使用局部内部类，而改为全部用匿名内部类
   */
  @Test
  public void test04() {
    Counter c1 = new AtomicCounter();
    final int MAX_LIMIT = 20;
    final int[] THRESHOLD = {6, 14, 18};

    class CounterThread extends Thread {
      private int id;

      CounterThread(int id) {
        this.id = id;
      }

      @Override
      public void run() {
        int timer = 0;
        boolean operated = false;
        while (c1.get() < MAX_LIMIT) {
          timer++;
          if (timer % 1000 == 0) {
            switch (id) {
              case 0:
                if (!operated && c1.get() >= THRESHOLD[2]) {
                  synchronized (c1) {
                    System.out.printf("%s is calls c1.notify() \n", this.getName());
                    c1.notifyAll();
                    operated = true;
                  }
                }
                break;
              case 1:
                if (!operated && c1.get() >= THRESHOLD[1]) {
                  try {
                    System.out.printf("%s calls sleep(4) \n", this.getName());
                    sleep(4);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                    operated = true;
                  }
                }
                break;
              case 2:
                if (!operated && c1.get() >= THRESHOLD[0]) {
                  try {
                    synchronized (c1) {
                      System.out.printf("%s calls c1.wait(); \n", this.getName());
                      c1.wait();
                      operated = true;
                    }
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                }
                break;
            }
            synchronized (c1) {
              c1.add();
              System.out.printf("(%s, %d) = %d \n", this.getName(), timer, c1.get());
            }
          }
        }
      }
    }
    Thread[] threads = new Thread[3];

    for (int i = 0; i < 3; i++) {
      threads[i] = new CounterThread(i);
    }

    for (int i = 0; i < 3; i++) {
      threads[i].start();
    }

    try {
      Thread.sleep(1200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test05() {
    Counter c1 = new Counter();
    final int MAX_LIMIT = 20;
    final int[] THRESHOLD = {6, 14, 18};

    class CounterRunnable implements Runnable {
      private int id;

      CounterRunnable(int id) {
        this.id = id;
      }

      private String getName() {
        return "RUNNABLE#" + id;
      }

      @Override
      public void run() {
        int timer = 0;
        boolean operated = false;
        while (c1.get() < MAX_LIMIT) {
          timer++;
          if (timer % 1000 == 0) {
            switch (id) {
              case 0:
                if (!operated && c1.get() >= THRESHOLD[2]) {
                  synchronized (c1) {
                    System.out.printf("%s is calls c1.notify() \n", this.getName());
                    c1.notifyAll();
                    operated = true;
                  }
                }
                break;
              case 1:
                if (!operated && c1.get() >= THRESHOLD[1]) {
                  try {
                    System.out.printf("%s calls sleep(4) \n", this.getName());
                    Thread.sleep(4);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                    operated = true;
                  }
                }
                break;
              case 2:
                if (!operated && c1.get() >= THRESHOLD[0]) {
                  try {
                    synchronized (c1) {
                      System.out.printf("%s calls c1.wait(); \n", this.getName());
                      c1.wait();
                      operated = true;
                    }
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                }
                break;
            }
            synchronized (c1) {
              c1.add();
              System.out.printf("(%s, %d) = %d \n", this.getName(), timer, c1.get());
            }
          }
        }
      }
    }

    ExecutorService exec = Executors.newCachedThreadPool();

    for (int i = 0; i < 3; i++) {
      exec.execute(new CounterRunnable(i));
    }

    try {
      Thread.sleep(1200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//        exec.shutdown();
  }

}
