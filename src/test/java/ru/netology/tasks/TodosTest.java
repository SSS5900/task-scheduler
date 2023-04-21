package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testQuerySearchZeroTasks() {
        Task simpleTask = new SimpleTask(5, "Оформить ДЗ");

        String[] subtasks = {"Оформить ИП"};
        Task epic = new Epic(55, subtasks);

        Task meeting = new Meeting(
                555,
                "Оформить 3ю версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Ноль";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testQuerySearchOneTask() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task epic = new Epic(55, subtasks);

        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Хлеб";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testQuerySearchTwoTasks() {
        Task simpleTask = new SimpleTask(5, "Разработчикам на заметку");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task epic = new Epic(55, subtasks);

        Task meeting = new Meeting(
                555,
                "Разработчикам Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Разработчикам";

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testQuerySearchThreeTasks() {
        Task simpleTask = new SimpleTask(5, "Оформить ДЗ");

        String[] subtasks = {"Оформить ИП"};
        Task epic = new Epic(55, subtasks);

        Task meeting = new Meeting(
                555,
                "Оформить 3ю версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Оформить";

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

}
