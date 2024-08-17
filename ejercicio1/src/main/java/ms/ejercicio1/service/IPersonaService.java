package ms.ejercicio1.service;


import ms.ejercicio1.entity.Persona;
import ms.ejercicio1.model.ResponsePersona;
import ms.ejercicio1.model.ResponsePersonaDate;

import java.time.LocalDateTime;
import java.util.List;

public interface IPersonaService {
    public List<Persona> readAll();
    public Persona readById(Long id);
    Persona insert(Persona persona);
    Persona update(Persona persona);
    void delete(Long id);
    public List<Persona> findAll();
    public List<Persona> findByEdadPrecio(Long edad, Double precio);
    public List<ResponsePersona> responsePersona(Long edad, Double precio);
    public List<Persona> findByDateLessThan(LocalDateTime dateCreate);
    public List<ResponsePersonaDate> responsePersonaDate(LocalDateTime dateCreate);

}
