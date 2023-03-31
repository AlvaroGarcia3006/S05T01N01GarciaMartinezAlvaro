package cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.repository;

import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}
