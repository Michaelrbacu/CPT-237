import java.io.*;

class School implements Cloneable, Comparable<School>, Serializable {
    //3 instance variables
    private String name;
    private int rooms;
    private double revenue;

    /*
    Michael Bacu
    CPT-237
    Assignment08
    4/15/2023
    */
    //constructor to initialize values
    public School(String name, int rooms, double revenue) {
        this.name = name;
        this.rooms = rooms;
        this.revenue = revenue;
    }

    //getter and setters to access and update the instance variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    //cloning the school object, using new String so, that both strings points to 2 different string object
    @Override
    protected School clone() {
        return new School(new String(name), rooms, revenue);
    }

    //comparing the school object with other object
    @Override
    public int compareTo(School o) {
        if (o.name.compareTo(name) < 0 && o.rooms < rooms && o.revenue < revenue)
            return 1;
        else if (o.name.compareTo(name) > 0 && o.rooms > rooms && o.revenue > revenue)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "School := {Name: " + name + ", Rooms: " + rooms + ", Revenue: " + revenue + "}";
    }

    public static void main(String[] args) {
        School school = new School("RVCP Public School", 10, 200000);
        System.out.println(school);

        // Serialize the object to a file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("school.dat"))) {
            outputStream.writeObject(school);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object from the file and compare it to the original object
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("school.dat"))) {
            School schoolRead = (School) inputStream.readObject();
            System.out.println(schoolRead);
            System.out.println(school.compareTo(schoolRead));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

}
}
}