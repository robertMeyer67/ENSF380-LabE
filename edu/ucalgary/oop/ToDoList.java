/**
 @version 1.3
 @since 1.0
 */


package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList{
    private List<Task> tasks = new ArrayList<>();
    private Stack<List<Task>> undoStack = new Stack<List<Task>>();
    //function to save the current state of tasks onto the undoStack
    private void saveState() {
        List<Task> taskCopy = new ArrayList<>();
        for (Task task : tasks) {
            taskCopy.add(new Task(task));
        }
        undoStack.push(taskCopy);
    }
    // function to add a new task to tasks
    @Override
    public void addTask(Task task) {
        saveState();
        this.tasks.add(task);
    }
    //function to mark a task (specified by id) to complete
    @Override
    public void completeTask(String id) {
        saveState();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
            }
        }
    }
    // function to delete a task by id
    @Override
    public void deleteTask(String id) {
        saveState();
        this.tasks.removeIf(task -> task.getId() == id);
    }
    // function to edit the title and isCompleted fields of a task by its id
    @Override
    public void editTask(String id, String newTitle, boolean isCompleted) {
        saveState();
        for (Task task : this.tasks) { // loop over each item in tasks
            if (task.getId() == id) {
                task.setTitle(newTitle);
                task.setCompleted(isCompleted);
            }
        }
    }
    // function to undo changes
    @Override
    public void undo() {
        if (!undoStack.isEmpty()) {
            this.tasks = this.undoStack.pop();
        }
    }
    // function to return the tasks in tasks variable.
    @Override
    public List<Task> listTasks() {
        return tasks;
    }
}
