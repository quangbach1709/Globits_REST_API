package com.quangbach1709.globits_rest_api.service;

import com.quangbach1709.globits_rest_api.DTO.UserDTO;
import com.quangbach1709.globits_rest_api.model.Person;
import com.quangbach1709.globits_rest_api.model.User;
import com.quangbach1709.globits_rest_api.repository.PersonRepository;
import com.quangbach1709.globits_rest_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    public UserDTO createUser(UserDTO userDTO) {
        Person person = personRepository.findById(userDTO.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found"));

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setActive(userDTO.isActive());
        user.setPerson(person);

        userRepository.save(user);
        return userDTO;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUserById(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Person person = personRepository.findById(userDTO.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found"));

        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setActive(userDTO.isActive());
        user.setPerson(person);

        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO getUserDTOById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setActive(user.isActive());
        userDTO.setPersonId(user.getPerson().getId());

        return userDTO;
    }
}
