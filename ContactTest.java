import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test that a valid Contact object is created successfully
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");

        // Verify each field is set correctly
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    // Test that an exception is thrown for a null contact ID
    @Test
    public void testContactIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    // Test that an exception is thrown when contact ID exceeds 10 characters
    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    // Test firstName length constraint
    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "JonathanTooLong", "Doe", "1234567890", "123 Main Street");
        });
    }

    // Test lastName length constraint
    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 Main Street");
        });
    }

    // Test phone number must be exactly 10 digits
    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "12345", "123 Main Street");
        });
    }

    // Test address length constraint
    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street 123 Main Street Extra Long Text");
        });
    }

    // Test updating firstName with valid input
    @Test
    public void testSetValidFirstName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    // Test updating phone with invalid input
    @Test
    public void testSetPhoneInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("abc123");
        });
    }
}