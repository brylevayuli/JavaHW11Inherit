package org.example;

import java.util.Arrays;

public class Epic extends Task {
    protected String subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = Arrays.toString(subtasks); // заполнение своих полей
    }

    public String[] getSubtasks() {
        return new String[]{subtasks};
    }

    @Override
    public boolean matches(String query) {
        for (String subTask : subtasks) {
            if (subTask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}

