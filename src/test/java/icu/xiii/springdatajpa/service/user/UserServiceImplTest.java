package icu.xiii.springdatajpa.service.user;

import icu.xiii.springdatajpa.dto.user.UserDtoRequest;
import icu.xiii.springdatajpa.repository.user.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    void beforeEach() {
        userRepository.deleteAll();
        userService.create(new UserDtoRequest(null, "Test 123", "test@test.local"));
    }

    @Test
    void testThrowsExceptionAndRollback() {
        assertThrows(Exception.class, () -> userService.create(new UserDtoRequest(null, "Test 456", "test@test.local")));
        assertEquals(1, userRepository.count());
    }
}