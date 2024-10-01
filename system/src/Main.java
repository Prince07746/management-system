import java.util.Objects;

public class Main{
    public static void main(String[] args){

        Person p1 = new Person("prince","david","mato",24);
        Person p2 = new Person("david","matongo","maprinc",23);
        Person p3 = new Person("david","matongo","maprinc",23);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("\t P1 == P2 ");
        System.out.println("\t answer: "+p1.equals(p2));
        System.out.println("\t ============");
        System.out.println("\t P2 == P3 ");
        System.out.println("\t answer: "+p3.equals(p3));
        System.out.println("\t ============");

        Customer customer1 = new Customer("hana", "Debay", "password12", 27);
        Customer customer2 = new Customer("don", "jazy", "pa23", 32);
        Customer customer3 = new Customer("makmot", "robin", "p56", 29);
        Customer customer4 = new Customer("makmot", "robin", "p56", 29);
        System.out.println("\t customer1: \n"+customer1);
        System.out.println("\t set new balance");
        customer1.setBalance(500);
        System.out.println("\t customer1: \n"+customer1);
        System.out.println("\t =====================");
        System.out.println("\t customer1 == cumtomer2 ");
        System.out.println("\t answer: "+customer1.equals(customer2));
        System.out.println("\t ============");
        System.out.println("\t customer3 == customer 4 ");
        System.out.println("\t answer: "+customer3.equals(customer4));
        System.out.println("\t ============");


        Manager manager1 = new Manager("huseyin","pro","4657f",26);
        Manager manager2 = new Manager("mustafa","xpro","c56r7f",28);
        Manager manager3 = new Manager("huseyin","pro","4657f",26);

        System.out.println("\t Manager: \n ");
        System.out.println(manager1.toString());
        System.out.println("\t manager1 == manager2 ");
        System.out.println("\t answer: "+manager1.equals(manager2));
        System.out.println("\t ============");
        System.out.println("\t manager1 == manager3 ");
        System.out.println("\t answer: "+manager1.equals(manager3));
        System.out.println("\t ============");



    }
}


class Person{
    private String name;
    String surname;
    private int age;
    private String password;

    public Person(String name,String surname,String password,int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "\n\t Name: "+name+
                "\n\t Age: "+age+
                "\n\t =============";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(surname, person.surname) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, password);
    }
}



class Customer extends Person{

    private String customerID;
    private double balance;

    public Customer(String name,String surname,String password,int age){
        super(name, surname, password, age);
        customerID = AutoGenId();
        balance = 0.0;
    }
    public String AutoGenId(){
        int num = (int) (Math.random() * 1000);
        return ""+num;
    }

    public String getCustomerID() {
        return customerID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\n\t customerID = " + customerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return super.equals(o) || (customerID.equals(customer.customerID) && getPassword().equals(customer.getPassword()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerID);
    }
}

class Manager extends Person{
    private String managerId;
    private int actionNumber;

    public Manager(String name, String surname, String password, int age) {
        super(name, surname, password, age);
        this.actionNumber = 0;
        managerId = AutoGenId();
    }

    public int getActionNumber() {
        return actionNumber;
    }

    public String getManagerId(){
        return managerId;
    }
    public void setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
    }
    public String AutoGenId(){
        int id = (int) Math.random()*1000;
        return ""+id;
    }

    @Override
    public String toString() {
        return "\n\t Manager ID: "+managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return super.equals(o) || Objects.equals(managerId, manager.managerId) && getPassword().equals(manager.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), managerId);
    }
}