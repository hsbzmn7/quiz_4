package org.example;

import java.time.LocalDate;

public class Task {
    private String name;
    private String assignedTo;
    private String status;
    private LocalDate dueDate;

    public Task(String name, String assignedTo, String status, LocalDate dueDate) {
        this.name = name;
        this.assignedTo = assignedTo;
        this.status = status;
        this.dueDate = dueDate;
    }

    public void assignTo(String teamMember) {
        this.assignedTo = teamMember;
    }

    public void updateStatus(String newStatus) {
        if (!newStatus.equals("pending") && !newStatus.equals("in progress") && !newStatus.equals("completed")) {
            throw new IllegalArgumentException("Invalid status: " + newStatus);
        }
        this.status = newStatus;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getStatus() {
        return status;
    }
}
