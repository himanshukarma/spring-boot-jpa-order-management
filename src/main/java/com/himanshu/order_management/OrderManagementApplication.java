package com.himanshu.order_management;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.himanshu.order_management.entity.Address;
import com.himanshu.order_management.entity.User;
import com.himanshu.order_management.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class OrderManagementApplication implements CommandLineRunner {
	private final UserRepository userRepository;

	public OrderManagementApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("Himanshu");
		user.setEmail("himanshu@example.com");

		userRepository.save(user);
		user.setName("Himanshu Karma");
		userRepository.save(user);

		Optional<User> optional = userRepository.findById(user.getId());

		if (optional.isPresent()) {
			User user1 = optional.get();

			user1.setName("Updated Name");
		}

		// -------------------------
		Address address = new Address();
		address.setCity("Amravati");
		address.setStreet("Sai Nagar");
		
		user.setAddress(address);
	}

}
