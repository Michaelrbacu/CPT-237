public class Car implements Cloneable, Comparable<Car> {

    private String make;
    private double price;
    private int year;

    public Car(String make, double price, int year) {
        this.make = make;
        this.price = price;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Car clone() {
        // Create a new Car object with the same make, price, and year
        Car clonedCar = new Car(make, price, year);
        // Create a new String object for the make so that the original and cloned objects have separate String objects
        clonedCar.make = new String(make);
        return clonedCar;
    }

    @Override
    public int compareTo(Car other) {
        if (this.make.equals(other.make)) {
            if (this.year == other.year) {
                return Double.compare(this.price, other.price);
            } else {
                return Integer.compare(this.year, other.year);
            }
        } else {
            return this.make.compareTo(other.make);
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 15000.00, 2018);
        Car car2 = car1.clone();
        car2.setMake("Honda");
        System.out.println(car1.compareTo(car2)); // should be negative
        System.out.println(car2.compareTo(car1)); // should be positive
        Car car3 = new Car("Ford", 12000.00, 2015);
        System.out.println(car1.compareTo(car3)); // should be positive
        System.out.println(car3.compareTo(car1)); // should be negative
        System.out.println(car1.compareTo(car1.clone())); // should be zero
    }

}