package ms.ejercicio1.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePersonaDate {
    private Long idPersona;
    private String nombre;
    private Long idDepartamento;
    private LocalDateTime dateCreate;
}
