package tn.esprit.spring.services;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class UserServiceImplTest {
	@Autowired
	IUserService us;
	@Test
	@Order(1)
	 void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2011-11-11");

		us.addUser(new User("Nawres", "Boutabba", d,Role.INGENIEUR));
		List<User> listUsers= us.retrieveAllUsers();
		Assertions.assertEquals(10, listUsers.size());
	}

	@Test
	@Order(2)
	 void testRetrieveUser() {
		List<User> listUsers = us.retrieveAllUsers();
	Assertions.assertEquals(10, listUsers.size());
	}
	
	@Test
	@Order(3)
	 void testUpdateUser() {
		List<User> listUsers = us.retrieveAllUsers();
	User e = listUsers.get(0);
	e.setLastName("boutabaaaaaa");
	us.updateUser(e);
	listUsers = us.retrieveAllUsers();
		Assertions.assertEquals("boutabaaaaaa", listUsers.get(0).getLastName());
	}
	
	@Test
	@Order(4)
	 void testDeleteUser() {
		List<User> listUsers = us.retrieveAllUsers();
	us.deleteUser(listUsers.get(0).getId().toString());
		listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(9,listUsers.size());
	}

}