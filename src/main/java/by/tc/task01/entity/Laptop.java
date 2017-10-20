package by.tc.task01.entity;

public class Laptop extends Appliance {
    private double batteryCapacity;
    private String os;
    private int memoryRom;
    private int systemMemory;
    private double cpu;
    private int displayInches;

    public Laptop(double batteryCapacity, String os, int memoryRom, int systemMemory, double cpu, int displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( (o == null) || (getClass() != o.getClass()) ) {
            return false;
        }

        Laptop laptop = (Laptop) o;

        if ( Double.compare(laptop.batteryCapacity, batteryCapacity) != 0 ) {
            return false;
        }
        if ( memoryRom != laptop.memoryRom ) {
            return false;
        }
        if ( systemMemory != laptop.systemMemory ) {
            return false;
        }
        if ( Double.compare(laptop.cpu, cpu) != 0 ) {
            return false;
        }
        if ( displayInches != laptop.displayInches ) {
            return false;
        }
        return os != null ? os.equals(laptop.os) : laptop.os == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + memoryRom;
        result = 31 * result + systemMemory;
        temp = Double.doubleToLongBits(cpu);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + displayInches;
        return result;
    }

    @Override
    public String toString() {
        return "Laptop : " +
                "BATTERY_CAPACITY=" + batteryCapacity +
                ", OS='" + os + '\'' +
                ", MEMORY_ROM=" + memoryRom +
                ", SYSTEM_MEMORY=" + systemMemory +
                ", CPU=" + cpu +
                ", DISPLAY_INCHES=" + displayInches +
                ';';
    }
}
