package ms.ejercicio1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity //Representa a una tabla
@Table(name = "departamento") // nombre de la tabla
@Data // actualizar getter y setter de manera automatica
@AllArgsConstructor// constructor con parametros
@NoArgsConstructor // constructor sin parametros

public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "m2")
    private Long m2;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "is_active")
    private Boolean isActive;
}
