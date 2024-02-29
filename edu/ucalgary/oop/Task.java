/**
 @version 1.3
 @since 1.0
 */

package edu.ucalgary.oop;

import java.util.Objects;

public class Task {
    // Properties
    private String id;
    private String title;
    private boolean isCompleted;

    // Constructor
    public Task(String id, String title) {
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    public Task(Task other) {
        this.id = other.id;
        this.title = other.title;
        this.isCompleted = other.isCompleted;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id) &&
               Objects.equals(title, task.title) &&
               isCompleted == task.isCompleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }
}
