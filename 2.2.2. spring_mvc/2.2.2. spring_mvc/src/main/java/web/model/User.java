package web.model;
import javax.persistence.*;


@Entity
@Table(name = "users")
public class User{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;



    public User() {
    }

    public User(int id, String name, int age, String login, String password, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String name, int age, String login, String password, String role) {
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }


    @Override
    public int hashCode() {
        int result = 31 + name.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + (age * 131 << 18);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || getClass() != obj.getClass()) return false;

        User other = (User) obj;
        if (!other.name.equals(name)) return false;
        if (!(other.age == age)) return false;
        if (!(other.login.equals(login))) return false;
        if (!(other.password.equals(password))) return false;
        return other.role.equals(role);
    }

    @Override
    public String toString() {
        return "User{" +
                name + " " +
                age + " лет}";
    }
}
