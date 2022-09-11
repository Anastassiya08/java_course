package com.ddbase.auto;

public abstract class Automobile implements Auto {
    protected String brand; //марка автомобиля
    protected int release; //год выпуска
    protected int carCapacity; //кол-во мест
    protected String fuelType; //тип топлива
    protected String gearBox; //тип коробки передач
    protected String drive; //тип привода
    protected int tankCapacity; //емкость топливного бака,
    protected int mileage = 0; //пробег
    protected String color; //цвет автомобиля

    //конструктор по умолчанию
    public Automobile() {
        this.brand = "Toyota";
        this.release = 2016;
        this.carCapacity = 5;
        this.fuelType = "Бензин";
        this.gearBox= "Автомат";
        this.drive = "Передний";
        this.tankCapacity = 50;
    }

    //перегрузка конструктора
    public Automobile(String brand, int release, int carCapacity,
                      String fuelType, String gearBox, String drive,
                      int tankCapacity)
    {
        this.brand = brand;
        this.release = release;
        this.carCapacity = carCapacity;
        this.fuelType = fuelType;
        this.gearBox = gearBox;
        this.drive = drive;
        this.tankCapacity = tankCapacity;
    }

    //реализация методов интерфейса
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void increaseMileage(int mileage) {
        this.mileage += mileage;
    }

    //перегрузка метода
    public void increaseMileage() {
        this.mileage += 100;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }


    //функция печати информации про автомобиль
    public void printInfo() {
        System.out.println("Информация про класс Автомобиль!");
    }

    public abstract int autoYear(); //абстрактный метод
    
    // абстрактный метод записи информации об автомобиле в файл
    public abstract void writeAutomobileToFile(String filePath);
    
    // абстрактный метод чтения информации о автомобиле из файла
    public abstract Automobile readAutomobileFromFile(String filePath);
}
