package com.ddbase.main;

import com.ddbase.auto.Automobile;
import com.ddbase.autotype.*;

public class Main {
    public static void main(String[] args) {
        PassengerCar car1 = new PassengerCar(); //вызов конструктора по умолчанию
        //вызов конструктора с параметрами
        PassengerCar car2 = new PassengerCar("BMW", 2012, 5, "Дизель", "Автомат", "Полный", 85, "X6", "Кроссовер", 1.69, 4.87);
        Truck truck1 = new Truck("MERCEDES-BENZ", 2011, 3, "Дизель", "Механика", "Задний", 400, "Actros 3336", "Седельный тягач", 20, 3);
        car1.setMileage(10000);
        car1.setColor("Серый");
        car2.setMileage(12000);
        car2.increaseMileage();
        car2.setColor("Белый");
        truck1.setMileage(30000);
        truck1.increaseMileage(5000);
        truck1.setColor("Красный");


        Automobile[] auto = new Automobile[] {car1, car2, truck1};

        for(int i = 0; i < auto.length; i++) {
            System.out.println("Автомобиль №"+ (i+1));
            auto[i].printInfo(); // полиморфный вызов метода
            System.out.println("\n");
        }
        
        //запись в файл
        truck1.writeAutomobileToFile("auto.txt");
        
        //чтение из файла информации про автомобиль
        PassengerCar car3 = new PassengerCar();
        car3 = car3.readAutomobileFromFile("car.txt");
        car3.printInfo();
        
        System.out.println("\n");
        
        //чтение из файла информации про автомобиль
        Truck truck2 = new Truck();
        truck2 = truck2.readAutomobileFromFile("truck.txt");
        truck2.printInfo();
    }
}
