package rbd.thread;

public class MainThread {
  //Получить данные о главном потоке выполнения
  public static void main(String[] args) {
    //Получаем объект главного потока
    Thread t = Thread.currentThread();

    //Выводим данные о текущем потоке выполнения
    System.out.println("Текущий поток: " + t);

    //Устанавливаем новое имя потока выполнения с помощью ф-ции setName()
    t.setName("Мой поток");

    //Снова выводим данные о потоке выполнения
    System.out.println("Текущий поток: " + t);

    //Демонстрация работы потока выполнения
    try {
      for (int n=5; n>0; n--) {
        System.out.println(n);
        Thread.sleep(1000); //приостанавливаем выполнение вызывающего потока на 1 сек
      }
    }
    catch (InterruptedException e) {
      System.out.println("The main thread is interrupted.");
    }
  }
}
