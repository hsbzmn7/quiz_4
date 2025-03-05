
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TaskTest {

    @Test
    public void testAssignTask() {
        Task task = new Task("Complete Project", null, "pending", LocalDate.of(2025, 3, 15));
        task.assignTo("Alice");
        assertEquals("Alice", task.getAssignedTo());
    }

    @Test
    public void testUpdateStatus() {
        Task task = new Task("Complete Project", "Alice", "pending", LocalDate.of(2025, 3, 15));
        task.updateStatus("in progress");
        assertEquals("in progress", task.getStatus());

        // Test invalid status
        try {
            task.updateStatus("not valid");
            fail("Exception should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid status: not valid", e.getMessage());
        }
    }

    @Test
    public void testIsOverdue() {
        Task task = new Task("Complete Project", "Alice", "pending", LocalDate.of(2025, 3, 1));
        assertTrue(task.isOverdue());

        task = new Task("Complete Project", "Alice", "pending", LocalDate.of(2025, 3, 15));
        assertFalse(task.isOverdue());
    }
}
