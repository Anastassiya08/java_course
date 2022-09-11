package rbd.thread;

// Пример создания потока с помощью реализации интерфейса Runnable
// В интерфейсе Runnable определен метод run(), который нужно реализовать
class MyRunnable implements Runnable {
  private int count; //переменная для хранения кол-ва авто

  MyRunnable(int carCount) { // Конструктор
    // создаем новый поток
    count = carCount;
    System.out.println("Бензоколонка открыта...");
  }

  @Override // Реализация метода run() из интерфейса Runnable
  public void run() {
    int n=0; //переменная для подсчета уже заправленных автомобилей
    try {
      for (int i=count; i>0; i--) {
        n++;
        System.out.println("Заправлено автомобилей на " + Thread.currentThread().getName() + ": " + n);
        Thread.sleep(500); //приостанавливаем выполнение вызывающего потока на 0.5 cек
      }
    }
    catch (InterruptedException e) {
      System.out.println("Поток на бензоколонке прерван.");
    }
    System.out.println(Thread.currentThread().getName() + " закрыта.");
  }
}

public class CarRunnable {
  public static void main(String[] args) {
    System.out.println("Заправка открыта...");
    // Демонстрация работы дочернего потока
    Thread t1 = new Thread(new MyRunnable(12), "Бензоколонка1");
    Thread t2 = new Thread(new MyRunnable(5), "Бензоколонка2");
    Thread t3 = new Thread(new MyRunnable(18), "Бензоколонка3");
    t1.setPriority(Thread.NORM_PRIORITY);
    t2.setPriority(Thread.MAX_PRIORITY);
    t3.setPriority(Thread.MIN_PRIORITY);
    t1.start();
    t2.start();
    t3.start();
    try {
      t1.join();
    }
    catch (InterruptedException e) {
      System.out.println("Поток на бензоколонке1 прерван.");
    }
    try {
      t2.join();
    }
    catch (InterruptedException e) {
      System.out.println("Поток на бензоколонке2 прерван.");
    }
    try {
      t3.join();
    }
    catch (InterruptedException e) {
      System.out.println("Поток на бензоколонке3 прерван.");
    }
    System.out.println("Заправка закрыта.");
  }
}
