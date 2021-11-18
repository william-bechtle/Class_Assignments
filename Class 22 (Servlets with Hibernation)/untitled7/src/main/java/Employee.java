import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private int id;
    private String username;
    private String password;
    private String gender;
    private int age;

    public Employee(){}

    public Employee(int id, String username, String password, String gender, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {return age;}

    public void setAge(int age){this.age = age;}

    public String getGender() {
        return gender;
    }

    public void setGender(String email) {
        this.gender = email;
    }

    public String getPassword(){return password;}

    public void setPassword(String pass){this.password = pass;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }


}
