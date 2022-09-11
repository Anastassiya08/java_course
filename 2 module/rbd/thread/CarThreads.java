package rbd.thread;

// Создание потоков с помощью расширения класса Thread
class PetrolStation extends Thread {
  private int count; //переменная для хранения кол-ва авто

  // Конструктор
  public PetrolStation(String name, int carCount){
        super(name);
        count = carCount;
  }

  // Реализация собственного метода run(), в этом методе
  // указываются действия (работа), которые выполняет наш поток
  @Override
  public void run() {
    int n=0; //переменная для подсчета уже заправленных автомобилей
    System.out.println(Thread.currentThread().getName() + " открыта...");
    try {
      for (int i=count; i>0; i--) {
        n++;
        System.out.println("Заправлено автомобилей на " + Thread.currentThread().getName() + ": " + n);
        Thread.sleep(1000); //приостанавливаем выполнение вызывающего потока на 1 сек
      }
    }
    catch (InterruptedException e) {
      System.out.println("Поток на " + Thread.currentThread().getName() + " прерван.");
    }
    System.out.println("Поток на " + Thread.currentThread().getName() + " завершен.");
  }
}

public class CarThreads {

  public static void main(String[] args) {
    // Демонстрация создания потоков
    // На вход подается имя бензоколонки и кол-во автомобилей,
    //которые должны заправиться на этой бензоколонке
    PetrolStation t1 = new PetrolStation("Бензоколонка №1", 7);
    PetrolStation t2 = new PetrolStation("Бензоколонка №2", 11);
    PetrolStation t3 = new PetrolStation("Бензоколонка №3", 20);
    t1.setPriority(Thread.MIN_PRIORITY);
    t2.setPriority(Thread.NORM_PRIORITY);
    t3.setPriority(Thread.MAX_PRIORITY);
    t1.start(); //создаем новый поток
    t2.start(); //создаем новый поток
    t3.start(); //создаем новый поток
  }
}
