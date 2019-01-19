package ir.geeglo.dev.opencup.serverapp.orm.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Mohammad Rahmati, 1/15/2019
 */
@Entity
@Table(name = "user_info", schema = "public", catalog = "opencup_db")
@SequenceGenerator(name="user_info_id_seq",
        sequenceName="user_info_id_seq",
        allocationSize=1)
public class UserInfoEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String nationalCode;
    private String birthdate;
    private Integer age;
    private UserEntity user;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="user_info_id_seq")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 40)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 40)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "full_name", nullable = true, length = 80)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "national_code", nullable = true, length = 10)
    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Basic
    @Column(name = "birthdate", nullable = true, length = 10)
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoEntity that = (UserInfoEntity) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(nationalCode, that.nationalCode) &&
                Objects.equals(birthdate, that.birthdate) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, fullName, nationalCode, birthdate, age);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
