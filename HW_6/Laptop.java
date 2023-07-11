package HW_Java.HW_6;

import java.util.*;

public class Laptop {
    private int RAM;
    private int SSD;
    private String operationSystem;
    private double screenSize;
    private String color;
    private int price;

    public Laptop(int RAM, int SSD, String operationSystem,
            double screenSize, String color, int price) {
        this.RAM = RAM;
        this.SSD = SSD;
        this.operationSystem = operationSystem.toLowerCase();
        this.screenSize = screenSize;
        this.color = color.toLowerCase();
        this.price = price;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getRAM() {
        return RAM;
    }

    public void setSSD(int SSD) {
        this.SSD = SSD;
    }

    public int getSSD() {
        return SSD;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ОЗУ: " + getRAM() + ", " + "Объем жесткого диска: " + getSSD() + ", " +
                "OC: "+ getOperationSystem() + ", " + "Размер экрана: " + getScreenSize() + ", " +
                "Цвет: " + getColor() + ", " + "Цена: " + getPrice();
    }

    public void getFiltredLaptop(HashMap<Integer, String> filter) {
        int count = 0;
        if (filter.isEmpty()) {
            System.out.println(toString());
        } else {
            for (Map.Entry<Integer, String> f : filter.entrySet()) {
                if (f.getKey() == 1) {
                    if (getRAM() >= Integer.parseInt(f.getValue())) {
                        count++;
                    }
                } else if (f.getKey() == 2) {
                    if (getSSD() >= Integer.parseInt(f.getValue())) {
                        count++;
                    }
                } else if (f.getKey() == 3) {
                    if (getOperationSystem().equals(f.getValue())) {
                        count++;
                    }
                } else if (f.getKey() == 4) {
                    if (getScreenSize() >= Double.parseDouble(f.getValue())) {
                        count++;
                    }
                } else if (f.getKey() == 5) {
                    if (getColor().equals(f.getValue())) {
                        count++;
                    }
                } else if (f.getKey() == 6) {
                    if (getPrice() >= Integer.parseInt(f.getValue())) {
                        count++;
                    }
                }
                if (count >= filter.size()) {
                    System.out.println(toString());
                }
            }
        }
    }
}
