package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {

    @Test
    public void shouldFindMultipleTasks() {
        SimpleTask simpleTask1 = new SimpleTask(1, "Позвонить другу");
        SimpleTask simpleTask2 = new SimpleTask(2, "Позвонить собаке");
        SimpleTask simpleTask3 = new SimpleTask(3, "Позвонить кошке");

        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {simpleTask1, simpleTask2, simpleTask3};
        Task[] actual = todos.search("Позвонить");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoTasks() {
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

        Task[] expected = {};
        Task[] actual = todos.search("работа");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTask() {
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

        Task[] expected = {epic};
        Task[] actual = todos.search("молоко");

        assertArrayEquals(expected, actual);
    }
}