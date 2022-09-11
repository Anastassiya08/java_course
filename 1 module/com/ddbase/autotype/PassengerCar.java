package com.ddbase.autotype;

import java.util.Calendar;
import java.util.Date;
import java.lang.Integer;
import java.lang.Double;
import com.ddbase.auto.*;
import com.ddbase.engine.Engine;
import java.io.*;

//наследование от класса Automobile (быть чем-то)
public class PassengerCar extends Automobile {
    protected String model; //модель автомобиля
    protected String bodyType; //тип кузова
    protected double width; //ширина кузова
    protected double length; //длина кузова

    //наследование с использованием агрегации
    public Engine engine = new Engine();

    //конструктор по умолчанию
    public PassengerCar() {
        super();
        this.model = "Corolla";
        this.width = 1.78;
        this.length = 4.63;
        this.bodyType = "Седан";
    }

    //перегрузка конструктора
    public PassengerCar(String brand, int release, int carCapacity,
                        String fuelType, String gearBox, String drive,
                        int tankCapacity, String model, String bodyType,
                        double width, double length) {
        super(brand, release, carCapacity, fuelType, gearBox, drive, tankCapacity);
        this.model = model;
        this.width = width;
        this.length = length;
        this.bodyType = bodyType;
    }

    //функция определения класса легкового автомобиля
    public String carClass() {
        String cl;
        if (this.width < 1.6 & this.length < 3.6)
            cl = "Класс A - особо малый класс.";
        else if ((this.width >= 1.5 & this.width <= 1.7) & (this.length >= 3.6 & this.length < 3.9))
            cl = "Класс B - малый класс.";
        else if ((this.width >= 1.6 & this.width <= 1.75) & (this.length >= 3.9 & this.length < 4.4))
            cl = "Класс C - первый средний класс.";
        else if ((this.width >= 1.7 & this.width < 1.8) & (this.length >= 4.4 & this.length < 4.8))
            cl = "Класс D - второй средний класс.";
        else if (this.width >= 1.8 & (this.length >= 4.8 & this.length < 5))
            cl = "Класс E - бизнес-класс.";
        else
            cl = "Класс F - представительский класс.";
        return cl;
    }

    @Override
    public int autoYear() { //переопределение метода
        return Calendar.getInstance().get(Calendar.YEAR) - this.release;
    }

    //Виртуальный метод в наследуемом классе
    public void printInfo() {
        System.out.println("Марка машины: "+ this.brand +". Модель: "+ this.model +". Год выпуска: "+ this.release +" г. ("+ autoYear() +" лет).");
        System.out.println("Вместимость: "+ this.carCapacity +". Цвет: "+ getColor() +". Тип коробки передач: "+ this.gearBox +". Тип привода: "+ this.drive +".");
        System.out.println("Тип топлива: "+ this.fuelType +". Емкость топливного бака: "+ this.tankCapacity +" л.");
        System.out.println("Объем двигателя: "+ engine.capacity +" см3. Мощность двигателя: "+ engine.enginePower()+" кВт.");
        System.out.println("Длина кузова: "+ this.length +" м. Ширина кузова: "+ this.width +"м. Тип кузова: "+ this.bodyType +".");
        System.out.println(carClass());
        System.out.println("Пробег: "+ getMileage() +" км.");
    }
    
    // переопределение метода записи информации об автомобиле в файл
    @Override
    public void writeAutomobileToFile(String filePath) {
    	// подготовка строки для записи
 	String info = "Марка машины: "+ this.brand +". Модель: "+ this.model +". Год выпуска: "+ this.release +" г. ("+ autoYear() +" лет)." + "\n" + "Вместимость: "+ this.carCapacity +". Цвет: "+ getColor() +". Тип коробки передач: "+ this.gearBox +". Тип привода: "+ this.drive +"." + "\n" + "Тип топлива: "+ this.fuelType +". Емкость топливного бака: "+ this.tankCapacity +" л." + "\n" + "Объем двигателя: "+ engine.capacity +" см3. Мощность двигателя: "+ engine.enginePower()+" кВт." + "\n" + "Длина кузова: "+ this.length +" м. Ширина кузова: "+ this.width +"м. Тип кузова: "+ this.bodyType +"." + "\n" + carClass() + "\n" + "Пробег: "+ getMileage() +" км.";
 	try(FileWriter writer = new FileWriter(filePath, false))
        {
            // запись всей строки
            writer.write(info);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    // переопределение метода чтения информации о автомобиле из файла
    @Override
    public PassengerCar readAutomobileFromFile(String filePath) {
    	try(FileReader reader = new FileReader(filePath))
        {
            char[] buf = new char[256];
            reader.read(buf);
            String line = String.valueOf(buf);
            String[] lines = line.split(" ");
            
            PassengerCar car = new PassengerCar(lines[0], Integer.parseInt(lines[1]), Integer.parseInt(lines[2]), lines[3], lines[4], lines[5], Integer.parseInt(lines[6]), lines[7], lines[8], Double.parseDouble(lines[9]), Double.parseDouble(lines[10]));
            
            reader.close();
            return car;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
