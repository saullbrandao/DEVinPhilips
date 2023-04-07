package com.example.jwt.controllers;

import com.example.jwt.controllers.dto.LoginDTO;
import com.example.jwt.controllers.dto.TokenDTO;
import com.example.jwt.controllers.dto.UserDTO;
import com.example.jwt.model.User;
import com.example.jwt.repository.ProfileRepository;
import com.example.jwt.repository.UserRepository;
import com.example.jwt.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authenticationManager, ProfileRepository profileRepository, UserRepository userRepository, TokenService tokenService, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.encoder = encoder;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Validated LoginDTO loginDto){
        UsernamePasswordAuthenticationToken login = loginDto.convert();
        try {
            Authentication authentication = authenticationManager.authenticate(login);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Validated UserDTO userDTO) {
        profileRepository.save(userDTO.getProfile());

        User user = User.builder()
                .username(userDTO.getUsername())
                .password(encoder.encode(userDTO.getPassword()))
                .profileList(List.of(userDTO.getProfile()))
                .build();
        userRepository.save(user);

        return ResponseEntity.created(URI.create("/auth/register")).build();
    }
}
