package ms.ejercicio1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePersona {
    private Long idPersona;
    private String nombre;
    private Long edad;
    private Long idDepartamento;
    private String direccion;

}
