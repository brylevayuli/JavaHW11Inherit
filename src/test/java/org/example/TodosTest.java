package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void falseTestSearch() {
        SimpleTask simpleTask = new SimpleTask(123, "выгулять собаку");
        Epic epic = new Epic(55, new String[]{"молоко", "масло", "хлеб"});
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] result = todos.search("работа");

        assertArrayEquals(expected, result);
    }

    @Test
    public void trueTestSearch() {
        SimpleTask simpleTask = new SimpleTask(123, "выгулять собаку");
        Epic epic = new Epic(55, new String[]{"молоко", "масло", "хлеб"});
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] result = todos.search("молоко");

        assertArrayEquals(expected, result);
    }
}