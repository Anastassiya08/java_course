package com.ddbase.autotype;

import java.util.Calendar;
import java.util.Date;
import java.lang.Integer;
import com.ddbase.auto.*;
import com.ddbase.engine.Engine;
import java.io.*;

public class Truck extends Automobile //
{
    protected String model; //модель грузового автомобиля
    protected String bodyType; //тип кузова
    protected int loadCapacity; //грузоподъемность, т
    protected int numberChassis; //кол-во осей

    //наследование с использованием агрегации
    public Engine engine = new Engine(1800, 0.85, 6000);
    
    //конструктор по умолчанию
    public Truck() {
        super();
        this.model = "Hino 300";
        this.bodyType = "Тягач";
        this.loadCapacity = 3;
        this.numberChassis = 2;
    }

    public Truck(String brand, int release, int carCapacity,
                String fuelType, String transmission, String drive,
                int tankCapacity, String model, String bodyType,
                int loadCapacity, int numberChassis) {
        super(brand, release, carCapacity, fuelType, transmission, drive, tankCapacity);
        this.model = model;
        this.loadCapacity = loadCapacity;
        this.bodyType = bodyType;
        this.numberChassis = numberChassis;
    }

    //функция разбиения грузовых автомобилей по грузоподъемности
    public String truckLoadCapacity() {
        String LoadCapacity;
        if (this.loadCapacity < 2)
            LoadCapacity = "Малая грузоподъемность";
        else if (this.loadCapacity >= 2 & this.loadCapacity < 5)
            LoadCapacity = "Средняя грузоподъемность";
        else if (this.loadCapacity >= 5 & this.loadCapacity < 16)
            LoadCapacity = "Большая грузоподъемность";
        else
            LoadCapacity = "Особо большая грузоподъемность";
        return LoadCapacity;
    }

    @Override
    public int autoYear() {
        return Calendar.getInstance().get(Calendar.YEAR) - this.release;
    }

    //Виртуальный метод в качестве полиморфизма
    public void printInfo() {
        System.out.println("Марка машины: "+ this.brand +". Модель: "+ this.model +". Год выпуска: "+ this.release +" г. ("+ autoYear() +" лет).");
        System.out.println("Вместимость: "+ this.carCapacity +". Цвет: "+ getColor() +". Тип коробки передач: "+ this.gearBox +". Тип привода: "+ this.drive +".");
        System.out.println("Тип топлива: "+ this.fuelType +". Емкость топливного бака: "+ this.tankCapacity +" л.");
        System.out.println("Объем двигателя: "+ engine.capacity +" см3. Мощность двигателя: "+ engine.enginePower()+" кВт.");
        System.out.println("Количество осей: "+ this.numberChassis +". Грузоподъемность: "+ this.loadCapacity +"т ("+ truckLoadCapacity() +").");
        System.out.println("Пробег: "+ getMileage() +" км.");
    }
    
    // переопределение метода записи информации об автомобиле в файл
    @Override
    public void writeAutomobileToFile(String filePath) {
    	// подготовка строки для записи
 	String info = "Марка машины: "+ this.brand +". Модель: "+ this.model +". Год выпуска: "+ this.release +" г. ("+ autoYear() +" лет)." + "\n" + "Вместимость: "+ this.carCapacity +". Цвет: "+ getColor() +". Тип коробки передач: "+ this.gearBox +". Тип привода: "+ this.drive +"." + "\n" + "Тип топлива: "+ this.fuelType +". Емкость топливного бака: "+ this.tankCapacity +" л." + "\n" + "Объем двигателя: "+ engine.capacity +" см3. Мощность двигателя: "+ engine.enginePower()+" кВт." + "\n" + "Количество осей: "+ this.numberChassis +". Грузоподъемность: "+ this.loadCapacity +"т ("+ truckLoadCapacity() +")." + "\n" + "Пробег: "+ getMileage() +" км.";
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
    public Truck readAutomobileFromFile(String filePath) {
    	try(FileReader reader = new FileReader(filePath))
        {
            char[] buf = new char[256];
            reader.read(buf);
            String line = String.valueOf(buf);
            String[] lines = line.split(" ");
            Truck truck = new Truck(lines[0], Integer.parseInt(lines[1]), Integer.parseInt(lines[2]), lines[3], lines[4], lines[5], Integer.parseInt(lines[6]), lines[7], lines[8], Integer.parseInt(lines[9]), Integer.parseInt(lines[10]));
            
            reader.close();
            return truck;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
