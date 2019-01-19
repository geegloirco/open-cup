package ir.geeglo.dev.opencup.serverapp.orm.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author Mohammad Rahmati, 1/15/2019
 */
@Entity
@Table(name = "province", schema = "public", catalog = "opencup_db")
@SequenceGenerator(name="province_id_seq",
        sequenceName="province_id_seq",
        allocationSize=1)
public class ProvinceEntity {
    private int id;
    private String title;
    private List<CityEntity> citiesById;
    private CountryEntity countryByCountryId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="province_id_seq")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvinceEntity that = (ProvinceEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @OneToMany(mappedBy = "provinceByProvinceId")
    public List<CityEntity> getCitiesById() {
        return citiesById;
    }

    public void setCitiesById(List<CityEntity> citiesById) {
        this.citiesById = citiesById;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
