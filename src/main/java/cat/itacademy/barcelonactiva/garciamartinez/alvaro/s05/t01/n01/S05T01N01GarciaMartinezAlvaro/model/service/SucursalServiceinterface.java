package cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.service;

import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.dto.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface SucursalServiceinterface {
    List<SucursalDTO> getAll();
    Optional<SucursalDTO> getOne(Integer id);
    void delete(Integer id);
    SucursalDTO update(SucursalDTO sucursalDTO);
    SucursalDTO save(SucursalDTO sucursalDTO);
}
