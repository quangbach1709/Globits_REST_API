package com.quangbach1709.globits_rest_api.Database;

import com.github.javafaker.Faker;
import com.quangbach1709.globits_rest_api.model.Person;
import com.quangbach1709.globits_rest_api.model.User;
import com.quangbach1709.globits_rest_api.repository.PersonRepository;
import com.quangbach1709.globits_rest_api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.stream.IntStream;

@Component
public class FakeDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public FakeDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // Fake dữ liệu
        IntStream.range(0, 10).forEach(i -> {
            Person person = new Person();
            person.setFullName(faker.name().fullName());
            person.setGender(faker.options().option("Male", "Female"));
            person.setBirthdate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            person.setPhoneNumber(faker.phoneNumber().phoneNumber());
            person.setAddress(faker.address().fullAddress());

            User user = new User();
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setActive(faker.bool().bool());
            user.setPerson(person); // Gắn liên kết với Person

            // Lưu User (Person sẽ tự động được lưu nhờ CascadeType.ALL)
            userRepository.save(user);
        });
    }
}
