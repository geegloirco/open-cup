package ir.geeglo.dev.opencup.serverapp.orm.entity;

import org.eclipse.persistence.internal.oxm.schema.model.All;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author Mohammad Rahmati, 1/15/2019
 */
@Entity
@Table(name = "users", schema = "public", catalog = "opencup_db")
@SequenceGenerator(name="users_id_seq",
        sequenceName="users_id_seq",
        allocationSize=1)
public class UserEntity {
    private int id;
    private String username;
    private String mail;
    private String mobile;
    private String password;
    private String image;
    private Timestamp enterDate;
    private List<UserInfoEntity> userInfos;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="users_id_seq")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 128)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "mail", nullable = true, length = 128)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 11)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 128)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "enter_date", nullable = false)
    public Timestamp getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Timestamp enterDate) {
        this.enterDate = enterDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(password, that.password) &&
                Objects.equals(image, that.image) &&
                Objects.equals(enterDate, that.enterDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, mail, mobile, password, image, enterDate);
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<UserInfoEntity> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfoEntity> userInfos) {
        this.userInfos = userInfos;
    }

    public void addUserInfo(UserInfoEntity userInfo) {
        if(this.userInfos != null) {
            this.userInfos.add(userInfo);
            userInfo.setUser(this);
        }
    }
}
