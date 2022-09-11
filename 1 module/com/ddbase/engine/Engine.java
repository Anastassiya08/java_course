package com.ddbase.engine;

public class Engine
{
    protected int rpm; //количество оборотов в минуту, об/мин
    protected double mep; //среднее эффективное давление, МПа
    public int capacity; //объем двигателя, см3

    //конструктор по умолчанию
    public Engine() {
        this.rpm = 2000;
        this.mep = 0.85;
        this.capacity = 1500;
    }

    //перегрузка конструктора
    public Engine(int rpm, double mep, int capacity) {
        this.rpm = rpm;
        this.mep = mep;
        this.capacity = capacity;
    }

    //функция вычисления мощности двигателя
    public double enginePower() {
        return (this.capacity * this.mep * (this.rpm/120));
    }
}
