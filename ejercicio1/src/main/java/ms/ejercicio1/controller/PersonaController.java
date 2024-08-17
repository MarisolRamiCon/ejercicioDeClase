package ms.ejercicio1.controller;

import ms.ejercicio1.entity.Persona;
import ms.ejercicio1.model.ResponsePersona;
import ms.ejercicio1.model.ResponsePersonaDate;
import ms.ejercicio1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    private IPersonaService iPersonaService;
    @GetMapping("/persona")
    public List<Persona> readAll() {
        return iPersonaService.readAll();
    }

    @GetMapping("persona/{id}")
    public Persona readById(@PathVariable Long id) {
        return iPersonaService.readById(id);
    }

    @PostMapping("/persona")
    public Persona update(@RequestBody Persona persona){
        return iPersonaService.update(persona);
    }

    @PutMapping("/persona")
    public Persona insert(@RequestBody Persona persona){
        return iPersonaService.insert(persona);
    }
    @DeleteMapping("/persona/{id}")
    void delete(@PathVariable Long id){
        iPersonaService.delete(id);
    }

    @GetMapping("/edadPrecio")
    public List<Persona> findByEdadPrecio(@RequestParam Long edad, @RequestParam Double precio){
        return iPersonaService.findByEdadPrecio(edad,precio);
    }

    @GetMapping("/responsePersona")
    public List<ResponsePersona> responsePersona(@RequestParam Long edad,@RequestParam Double precio){
        return iPersonaService.responsePersona(edad,precio);

    }

    @GetMapping("/Fecha")
    public List<Persona> findByDateLessThan(@RequestParam LocalDateTime dateCreate){
        return iPersonaService.findByDateLessThan(dateCreate);
    }

    @GetMapping("/responsePersonaDate")
    public List <ResponsePersonaDate> responsePersonaDate(@RequestParam LocalDateTime dateCreate){
        return iPersonaService.responsePersonaDate(dateCreate);
    }


}
