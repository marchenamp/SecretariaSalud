/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jwt.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Hiram
 */
public interface PacienteRepository extends JpaRepository<Paciente,Integer>{
    Optional<Paciente> findByCorreo(String Correo);
}
