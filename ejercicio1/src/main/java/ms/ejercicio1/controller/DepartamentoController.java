package ms.ejercicio1.controller;

import ms.ejercicio1.entity.Departamento;
import ms.ejercicio1.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1")

public class DepartamentoController {
    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping("/departamento")
    public List<Departamento> readAll() {
        return departamentoService.readAll();
    }

    @GetMapping("departamento/{id}")
    public Departamento readById(@PathVariable Long id) {
        return departamentoService.readById(id);
    }
    @PostMapping("/departamento")
    public Departamento insert(@RequestBody Departamento departamento){
        return departamentoService.insert(departamento);
    }
    @PutMapping("/departamento")
    public Departamento update(@RequestBody Departamento departamento){
        return  departamentoService.update(departamento);
    }

    @DeleteMapping("/departamento/{id}")
    public void delete(@PathVariable Long id) {
        departamentoService.delete(id);
    }

    @GetMapping("departamento/direccion")
    public List<Departamento> direccion(@RequestParam String direccion,@RequestParam Double m2GreaterThan){
        return departamentoService.buscarDireccion(direccion,m2GreaterThan);

    }

    @GetMapping("departamento/precioLowerThan")
    public List<Departamento> precioLowerThan(@RequestParam Double precio){
        return departamentoService.precioLower(precio);
    }
}
