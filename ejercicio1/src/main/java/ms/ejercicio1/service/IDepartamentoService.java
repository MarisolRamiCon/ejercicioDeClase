package ms.ejercicio1.service;

import ms.ejercicio1.entity.Departamento;

import java.util.List;

public interface IDepartamentoService {
    public List<Departamento> readAll();
    public Departamento readById(Long id);

    public Departamento insert(Departamento departamento);

    public Departamento update(Departamento departamento);

    public void delete(Long id);
    public List<Departamento> buscarDireccion(String direccion, Double greaterThan);
    public List<Departamento> precioLower(Double precio);

}
