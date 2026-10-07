class Main {
    public static void main(String[] args) {

        BMI person1 = new BMI("Ali", 25, 145.0, 70.0);
        System.out.println("Magaca: " + person1.getName());
        System.out.println("BMI: " + person1.getBMI());
        System.out.println("Status: " + person1.getStatus());

        System.out.println("---------------------------");


        BMI person2 = new BMI("Amina", 120.0, 65.0);
        System.out.println("Magaca: " + person2.getName());
        System.out.println("Da'da (Default): " + person2.getAge());
        System.out.println("BMI: " + person2.getBMI());
        System.out.println("Status: " + person2.getStatus());
    }
}

public class  BMI {

    private String name;
    private int age;
    private double weight;
    private double height;


    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }


    public BMI(String name, double weight, double height) {
        this(name, 20, weight, height);
    }

    // --- Getter Methods

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }


    public double getBMI() {
        double bmi = (weight * 703) / (height * height);
        return Math.round(bmi * 100.0) / 100.0;
    }


    public String getStatus() {
        double bmi = getBMI();

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}