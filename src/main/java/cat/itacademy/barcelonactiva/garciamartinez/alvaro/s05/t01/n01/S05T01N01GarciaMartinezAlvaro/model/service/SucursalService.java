package cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.service;

import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService implements SucursalServiceinterface{
    @Autowired
    private SucursalRepository sucursalRepository;
    public SucursalDTO save(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setSucursalName(sucursalDTO.getSucursalName());
        sucursal.setSucursalCountry(sucursalDTO.getSucursalCountry());
        Sucursal savedSucursal = sucursalRepository.save(sucursal);
        return new SucursalDTO(savedSucursal);
    }
    public SucursalDTO update(SucursalDTO sucursalDTO) {
        return save(sucursalDTO);
    }
    public void delete(Integer id) {
        sucursalRepository.deleteById(id);
    }
    public Optional<SucursalDTO> getOne(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        return sucursal.map(SucursalDTO::new);
    }
    public List<SucursalDTO> getAll() {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        List<SucursalDTO> sucursalesDTO = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {
            sucursalesDTO.add(new SucursalDTO(sucursal));
        }
        return sucursalesDTO;
    }
}
