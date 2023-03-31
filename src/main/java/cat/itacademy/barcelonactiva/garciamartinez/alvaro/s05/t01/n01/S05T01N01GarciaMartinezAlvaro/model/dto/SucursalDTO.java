package cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.dto;

import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.domain.Sucursal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SucursalDTO extends Sucursal {
    private String sucursalType;
    private static final List<String> EU_COUNTRIES = new ArrayList<>(Arrays.asList("Alemania", "Austria", "Bélgica", "Bulgaria", "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Polonia", "Portugal", "República Checa", "Rumania", "Suecia"));

    public SucursalDTO(){

    }
    public SucursalDTO(Sucursal sucursal) {
        this.setPk_SucursalID(sucursal.getPk_SucursalID());
        this.setSucursalName(sucursal.getSucursalName());
        this.setSucursalCountry(sucursal.getSucursalCountry());
        this.sucursalType = EU_COUNTRIES.contains(sucursal.getSucursalCountry()) ? "UE" : "NOT UE";
    }
    public String getSucursalType() {
        return sucursalType;
    }
    public void setSucursalType(String sucursalType) {
        this.sucursalType = sucursalType;
    }
}
