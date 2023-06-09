package cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.controllers;

import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.service.SucursalService;
import cat.itacademy.barcelonactiva.garciamartinez.alvaro.s05.t01.n01.S05T01N01GarciaMartinezAlvaro.model.service.SucursalServiceinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
    @Autowired
    private SucursalServiceinterface sucursalService;

    @PostMapping("/add")
    public String addSucursal(@ModelAttribute SucursalDTO sucursalDTO) {
        sucursalService.save(sucursalDTO);
        return "redirect:/sucursal/getAll";
    }
    @GetMapping("/add")
    public String showAddSucursalForm(Model model) {
        model.addAttribute("sucursal", new SucursalDTO());
        return "addSucursalForm";
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SucursalDTO> update(@PathVariable("id") long id, @RequestBody SucursalDTO sucursalDTO) {
        if (id != sucursalDTO.getPk_SucursalID()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        SucursalDTO updtSucursal = sucursalService.update(sucursalDTO);
        if (updtSucursal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updtSucursal, HttpStatus.OK);
    }
    @GetMapping("/update/{id}")
    public String showUpdateSucursalForm(@PathVariable("id") Integer id, Model model) {
        Optional<SucursalDTO> sucursalDTO = sucursalService.getOne(id);
        model.addAttribute("sucursal", sucursalDTO);
        return "updateSucursalForm";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") Integer id) {
        sucursalService.delete(id);
        return "redirect:/sucursal/getAll";
    }
    @GetMapping("/getOne/{id}")
    public String getOneSucursal(@PathVariable("id") Integer id, Model model) {
        Optional<SucursalDTO> sucursalDTO = sucursalService.getOne(id);
        model.addAttribute("sucursal", sucursalDTO.orElse(null));
        return "sucursal";
    }
    @GetMapping({"/", "/getAll"})
    public String getAllSucursales(Model model) {
        model.addAttribute("sucursales", sucursalService.getAll());
        model.addAttribute("sucursal", new SucursalDTO());
        return "sucursales";
    }
}
