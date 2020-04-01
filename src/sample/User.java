package sample;// This class will store information about the user such as;
//  name,age,height weight and will calculate the BMI

public class User
{

    /**
     *
     private String name,surname, age, email,username, password;
     private int age;


     private TextField name,surname, age, email,username, password ;
     */
    private String firstname;
    private String surname;
    private String email;
    private String userName;
    private String password;
    //Height to be measured as meters
    private double height;
    // Weight to be stored as Kg
    private double weight;
    private int age;
    public User()
    {

    }

    public User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public User(String name, String surname, String email, String userName, String password)
    {
        this.firstname = name;
        this.surname = surname;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public double BMI()
    {
        return weight / (height * height);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }

    public String getUserName() { return userName; }

    public String getName()
    {
        return firstname;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }

    public int getAge()
    {
        return age;
    }

    public void setName(String firstname)
    {
        this.firstname = firstname;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public static void main(String[] args)
    {

    }
}
