package rs.raf.domaci3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import rs.raf.domaci3.requests.LoginRequest;
import rs.raf.domaci3.responses.LoginResponse;
import rs.raf.domaci3.services.UserService;
import rs.raf.domaci3.utils.JwtUtil;

import java.util.Arrays;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (Exception   e){
            //e.printStackTrace();
            return ResponseEntity.status(401).build();
        }
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        String perm = Arrays.toString(user.getAuthorities().toArray());

        return ResponseEntity.ok(new LoginResponse(jwtUtil.generateToken(loginRequest.getEmail()),  perm));
    }

}