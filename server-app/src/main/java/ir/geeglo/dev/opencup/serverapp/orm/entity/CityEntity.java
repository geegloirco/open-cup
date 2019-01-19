package ir.geeglo.dev.opencup.serverapp.orm.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Mohammad Rahmati, 1/15/2019
 */
@Entity
@Table(name = "city", schema = "public", catalog = "opencup_db")
@SequenceGenerator(name="city_id_seq",
        sequenceName="city_id_seq",
        allocationSize=1)
public class CityEntity {
    private int id;
    private String title;
    private String phonecode;
    private CountryEntity countryByCountryId;
    private ProvinceEntity provinceByProvinceId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="city_id_seq")
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
        CityEntity that = (CityEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(phonecode, that.phonecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, phonecode);
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    public ProvinceEntity getProvinceByProvinceId() {
        return provinceByProvinceId;
    }

    public void setProvinceByProvinceId(ProvinceEntity provinceByProvinceId) {
        this.provinceByProvinceId = provinceByProvinceId;
    }
}
