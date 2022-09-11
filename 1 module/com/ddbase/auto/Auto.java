package com.ddbase.auto;

public interface Auto {
    public void setMileage(int mileage); //ф-ция установки пробега авто
    public void increaseMileage(int mileage);
    public void increaseMileage(); //ф-ция увеличения пробега
    public int getMileage(); //ф-ция получения пробега
    public void setColor(String color); //ф-ция установки цвета авто
    public String getColor(); //ф-ция получения цвета
}
