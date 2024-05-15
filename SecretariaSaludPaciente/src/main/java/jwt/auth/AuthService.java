package jwt.auth;

import jwt.jwt.filter.service.JwtService;
import jwt.user.Paciente;
import jwt.user.PacienteRepository;
import jwt.user.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PacienteRepository pacienteRepository;
    
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse loginP(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getPassword()));
        UserDetails user=pacienteRepository.findByCorreo(request.getCorreo()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse registerP(RegisterRequest request) {
        Paciente paciente = Paciente.builder()
            .nombres(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .role(Role.PACIENTE)
            .build();

        pacienteRepository.save(paciente);

        return AuthResponse.builder()
            .token(jwtService.getToken(paciente))
            .build();
        
    }
    

}
