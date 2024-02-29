package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList{
    private List<Task> tasks = new ArrayList<>();
    private Stack<List<Task>> undoStack = new Stack<List<Task>>();
    public void addTask(Task task) {
        undoStack.push(tasks);
        tasks.add(task);
    }
    public void completeTask(String id) {
        undoStack.push(tasks);
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
            }
        }
    }
    public void deleteTask(String id) {
        undoStack.push(tasks);
        tasks.removeIf(task -> task.getId() == id);
    }
    public void editTask(String id, String newTitle, boolean isCompleted) {
        undoStack.push(tasks);
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(newTitle);
                task.setCompleted(isCompleted);
            }
        }
    }
    public void undo() {
        tasks = undoStack.pop();
    }
    public List<Task> listTasks() {
//        for (Task task : tasks) {
//            if (task.isCompleted()) {
//                System.out.printf("%s10 Complete", task.getTitle());
//            }
//            else {
//                System.out.printf("%s10 Incomplete", task.getTitle());
//            }
//        }
        return tasks;
    }
}
