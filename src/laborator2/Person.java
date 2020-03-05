package laborator2;

public class Person
{
    private String name;
    private String surname;
    private long idNo;
    private String type;
    private int age;


    public Person(String name, String surname, long idNo, String type, int age) {
        this.name = name;
        this.surname = surname;
        this.idNo = idNo;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String showInfo()
    {
        return (this.getName() + " " + this.getSurname() + " " + this.getType() + " " + this.getAge() + " " + this.getIdNo());
    }
}
