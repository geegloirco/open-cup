package ir.geeglo.dev.opencup.serverapp.orm.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author Mohammad Rahmati, 1/15/2019
 */
@Entity
@Table(name = "country", schema = "public", catalog = "opencup_db")
@SequenceGenerator(name="country_id_seq",
        sequenceName="country_id_seq",
        allocationSize=1)
public class CountryEntity {
    private int id;
    private String title;
    private String phonecode;
    private List<CityEntity> citiesById;
    private List<ProvinceEntity> provincesById;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="country_id_seq")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 128)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "phonecode", nullable = true, length = 10)
    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(phonecode, that.phonecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, phonecode);
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public List<CityEntity> getCitiesById() {
        return citiesById;
    }

    public void setCitiesById(List<CityEntity> citiesById) {
        this.citiesById = citiesById;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public List<ProvinceEntity> getProvincesById() {
        return provincesById;
    }

    public void setProvincesById(List<ProvinceEntity> provincesById) {
        this.provincesById = provincesById;
    }
}
