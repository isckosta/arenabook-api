package br.com.arenabook.arenabook.core.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.arenabook.arenabook.core.mappers.UserMapper;
import br.com.arenabook.arenabook.core.models.User;
import br.com.arenabook.arenabook.core.repositories.UserRepository;
import br.com.arenabook.arenabook.web.user.dtos.UserRequest;
import br.com.arenabook.arenabook.web.user.dtos.UserResponse;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        User user = UserMapper.toEntity(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        User saved = userRepository.save(user);
        return UserMapper.toResponse(saved);
    }

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return UserMapper.toResponse(user);
    }

    public User findEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return UserMapper.toResponse(user);
    }

    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }
}
