package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void testQeryСorrespondsSimpleTask() {
        SimpleTask simple = new SimpleTask(10, "Начать обучение");
        String query = "Начать обучение";

        boolean[] expected = {true};
        boolean[] actual = new boolean[]{simple.matches(query)};
        Assertions.assertArrayEquals(expected, actual);

//        System.out.println(simple.matches("Начать обучение"));
    }

    @Test
    public void testQeryNotСorrespondsSimpleTask() {
        SimpleTask simple = new SimpleTask(10, "Начать обучение");
        String query = "Запрос";

        boolean[] expected = {false};
        boolean[] actual = new boolean[]{simple.matches(query)};
        Assertions.assertArrayEquals(expected, actual);

//        System.out.println(simple.matches("запрос"));

    }

    @Test
    public void testQeryNotFilledSimpleTask() {
        SimpleTask simple = new SimpleTask(10, " ");
        String query = "Запрос";

        boolean[] expected = {false};
        boolean[] actual = new boolean[]{simple.matches(query)};
        Assertions.assertArrayEquals(expected, actual);

//        System.out.println(simple.matches("запрос"));

    }

    @Test
    public void testQeryСorrespondsEpic() {
        String[] subtasks = {"линейка", "ручка", "карандаш"};
        Epic epic = new Epic(10, subtasks);
        String query = "ручка";

        boolean[] expected = {true};
        boolean[] actual = new boolean[]{epic.matches(query)};
        Assertions.assertArrayEquals(expected, actual);

//        System.out.println(epic.matches("ручка"));
    }

    @Test
    public void testQeryNotСorrespondsEpic() {
        String[] subtasks = {"линейка", "ручка", "карандаш"};
        Epic epic = new Epic(10, subtasks);
        String query = "тетрадь";

        boolean[] expected = {false};
        boolean[] actual = new boolean[]{epic.matches(query)};
        Assertions.assertArrayEquals(expected, actual);


//        System.out.println(epic.matches("тетрадь"));
    }

    @Test
    public void testQeryNotFilledEpic() {
        String[] subtasks = {"", "", ""};
        Epic epic = new Epic(10, subtasks);
        String query = "тетрадь";

        boolean[] expected = {false};
        boolean[] actual = new boolean[]{epic.matches(query)};
        Assertions.assertArrayEquals(expected, actual);

//        System.out.println(epic.matches("тетрадь"));
    }

    @Test
    public void testQeryСorrespondsMeeting() {
        Meeting meeting = new Meeting(10, "решение", "задача", "вторник после восьми");
        String query = "задача";

        boolean[] expected = {true};
        boolean[] actual = new boolean[]{meeting.matches(query)};
        Assertions.assertArrayEquals(expected, actual);

//        System.out.println(meeting.matches("задача"));
    }

    @Test
    public void testQeryNotСorrespondsMeeting() {
        Meeting meeting = new Meeting(10, "решение", "задача", "вторник после восьми");
        String query = "творчество";

        boolean[] expected = {false};
        boolean[] actual = new boolean[]{meeting.matches(query)};
        Assertions.assertArrayEquals(expected, actual);

//        System.out.println(meeting.matches("творчество"));
    }

    @Test
    public void testQeryNotFillerMeeting() {
        Meeting meeting = new Meeting(10, "", "", "");
        String query = "творчество";

        boolean[] expected = {false};
        boolean[] actual = new boolean[]{meeting.matches(query)};
        Assertions.assertArrayEquals(expected, actual);

//        System.out.println(meeting.matches("творчество"));
    }
}
