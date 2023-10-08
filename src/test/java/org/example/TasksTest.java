package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {
    @Test
    public void matchesSimpleTask() {
        SimpleTask SimpleTask = new SimpleTask(3, "Выгулять собаку");

        boolean actual = SimpleTask.matches("собаку");
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void matchesSimpleTaskFalse() {
        SimpleTask SimpleTask = new SimpleTask(3, "Выгулять собаку");

        boolean actual = SimpleTask.matches("кошку");
        boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    public void matchesEpic() {
        Epic Epic = new Epic(321, new String[]{"выгулять собаку", "позвонить родителям"});

        boolean actual = Epic.matches("позвонить");
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void matchesEpicFalse() {
        Epic Epic = new Epic(321, new String[]{"выгулять собаку", "позвонить родителям"});

        boolean actual = Epic.matches("работа");
        boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    public void matchesMeeting() {
        Meeting Meeting = new Meeting(123, "стройка", "заливка фундамента", "Вторник");

        boolean actual = Meeting.matches("стройка");
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingFalse() {
        Meeting Meeting = new Meeting(123, "стройка", "заливка фундамента", "Вторник");

        boolean actual = Meeting.matches("ипотека");
        boolean expected = false;

        assertEquals(expected, actual);
    }
}
