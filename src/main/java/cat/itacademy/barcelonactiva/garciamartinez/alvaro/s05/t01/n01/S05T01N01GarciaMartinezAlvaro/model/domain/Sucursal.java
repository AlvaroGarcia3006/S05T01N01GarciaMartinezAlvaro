package cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer pk_SucursalID;
    @Column(name = "name")
    private String sucursalName;
    @Column(name = "country")
    private String sucursalCountry;

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }
    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }
    public String getSucursalName() {
        return sucursalName;
    }
    public void setSucursalName(String sucursalName) {
        this.sucursalName = sucursalName;
    }
    public String getSucursalCountry() {
        return sucursalCountry;
    }
    public void setSucursalCountry(String sucursalCountry) {
        this.sucursalCountry = sucursalCountry;
    }
}
