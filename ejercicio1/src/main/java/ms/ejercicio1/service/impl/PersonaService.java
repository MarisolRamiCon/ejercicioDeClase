package ms.ejercicio1.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1.constantes.PersonaConstantes;
import ms.ejercicio1.entity.Persona;
import ms.ejercicio1.model.ResponsePersona;
import ms.ejercicio1.model.ResponsePersonaDate;
import ms.ejercicio1.repository.PersonaRepository;
import ms.ejercicio1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public List<Persona> readAll() {
        return personaRepository.findAll().stream().filter(s->s.getIsActive()!= PersonaConstantes.filtrado).toList();
    }

    @Override
    public Persona readById(Long id) {
        Optional<Persona> personaOptional=personaRepository.findById(id);
        if(personaOptional.isPresent()){
            return personaOptional.get();
        }
        else {
            return new Persona();
        }
    }

    @Override
    public Persona insert(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void delete(Long id) {
        Optional<Persona> personaOptional= personaRepository.findById(id);
        if (personaOptional.isPresent()){
            Persona persona = personaOptional.get();
            persona.setIsActive(false);
            personaRepository.save(persona);
        }else{
            log.error("El id de departamento no se encuentra");
        }

    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public List<Persona> findByEdadPrecio(Long edad, Double precio) {
        return personaRepository.edadPrecio(edad,precio);
    }

    //@Override
    //public List<Persona> findByEdadPrecio(Long edad, Double precio) {
      //  return personaRepository.findByEdadLessThan(edad).stream().filter(s->s.getIdDepartamento().getPrecio()<=precio).toList();
    //}

    @Override
    public List<ResponsePersona> responsePersona(Long edad, Double precio) {
        //DTO - DATA TRANSFER OBJECT
        List<Persona> personaList= personaRepository.edadPrecio(edad,precio);
        return personaList.stream().map(s->{
            ResponsePersona responsePersona=new ResponsePersona();
            responsePersona.setIdPersona(s.getId());
            responsePersona.setNombre(s.getNombre());
            responsePersona.setEdad(s.getEdad());
            responsePersona.setIdDepartamento(s.getIdDepartamento().getId());
            responsePersona.setDireccion(s.getIdDepartamento().getDireccion());
            return responsePersona;
        }).toList();

    }

    @Override
    public List<Persona> findByDateLessThan(LocalDateTime dateCreate) {
        return personaRepository.DateLessThan(dateCreate);
    }

    @Override
    public List<ResponsePersonaDate> responsePersonaDate(LocalDateTime dateCreate) {
        //DTO - DATA TRANSFER OBJECT
        List<Persona> personaList= personaRepository.DateLessThan(dateCreate);
        return personaList.stream().map(s->{
            ResponsePersonaDate responsePersonaDate=new ResponsePersonaDate();
            responsePersonaDate.setIdPersona(s.getId());
            responsePersonaDate.setNombre(s.getNombre());
            responsePersonaDate.setIdDepartamento(s.getIdDepartamento().getId());
            responsePersonaDate.setDateCreate(s.getDateCreate());
            return responsePersonaDate;
        }).toList();
    }


}
