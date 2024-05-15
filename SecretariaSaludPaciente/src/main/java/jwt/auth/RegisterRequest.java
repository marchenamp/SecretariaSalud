package jwt.auth;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    int id;
    String username;
    String nombres;
    String apellidoPaterno;
    String apellidoMaterno; 
    String correo;
    String password;
    Date fecha_nacimiento;
    String telefono;
    String estado_civil;
    String genero;
}
