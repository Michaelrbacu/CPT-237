class School implements Cloneable, Comparable<School> {
    //3 instance variables
    private String name;
    private int rooms;
    private double revenue;

/*
Michael Bacu
CPT-237
Assignment06
3/23/2023
*/
    //constructor to initialize values
    public School(String name, int rooms, double revenue) {
        this.name = name;
        this.rooms = rooms;
        this.revenue = revenue;
    }


    //getter and setters to access and update the instance varianles
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
        School school1 = school.clone();
        System.out.println(school1);
        System.out.println(school == school1);
        School school2 = new School("ABCP Public School",5,10000);
        System.out.println(school2);
        System.out.println(school1.compareTo(school2));
        System.out.println(school2.compareTo(school1));
    }
}