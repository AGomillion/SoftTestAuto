import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Alice", "Smith", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("001")); // Optional getter
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("002", "Bob", "Jones", "0987654321", "456 Elm St");
        service.addContact(contact);
        service.deleteContact("002");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("002")); // if using getContact
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("003", "Carol", "Davis", "5555555555", "789 Oak St");
        service.addContact(contact);
        service.updatePhone("003", "1112223333");
        assertEquals("1112223333", contact.getPhone());
    }
}