package HW_ONE;

public class Person {
    private String name;
    private int phone;

    public Person(String name, int phone){
        setName(name);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }

    public void displayPerson(){
        System.out.println("Name: " + getName() + ", HW_ONE.Person: " + getPhone());
    }
}
