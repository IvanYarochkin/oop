package by.tc.task01.entity;

public class Refrigerator extends Appliance {
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public Refrigerator(int powerConsumption, int weight, int freezerCapacity, double overallCapacity, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( (o == null) || (getClass() != o.getClass()) ) {
            return false;
        }

        Refrigerator that = (Refrigerator) o;

        if ( powerConsumption != that.powerConsumption ) {
            return false;
        }
        if ( weight != that.weight ) {
            return false;
        }
        if ( freezerCapacity != that.freezerCapacity ) {
            return false;
        }
        if ( Double.compare(that.overallCapacity, overallCapacity) != 0 ) {
            return false;
        }
        if ( Double.compare(that.height, height) != 0 ) {
            return false;
        }
        return Double.compare(that.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = powerConsumption;
        result = 31 * result + weight;
        result = 31 * result + freezerCapacity;
        temp = Double.doubleToLongBits(overallCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Refrigerator : " +
                "POWER_CONSUMPTION=" + powerConsumption +
                ", WEIGHT=" + weight +
                ", FREEZER_CAPACITY=" + freezerCapacity +
                ", OVERALL_CAPACITY=" + overallCapacity +
                ", HEIGHT=" + height +
                ", WIDTH=" + width +
                ';';
    }
}
