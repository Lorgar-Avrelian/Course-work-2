package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @Test
    void add() {
        assertEquals(questionService.add(TEST_QUESTION_1), TEST_QUESTION_1);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_1));
        assertEquals(questionService.add(TEST_QUESTION_2), TEST_QUESTION_2);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_2));
        assertEquals(questionService.add(TEST_QUESTION_3), TEST_QUESTION_3);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_3));
        assertEquals(questionService.add(TEST_QUESTION_4), TEST_QUESTION_4);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_4));
        assertEquals(questionService.add(TEST_QUESTION_5), TEST_QUESTION_5);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_5));
        removeTestQuestions();

        assertEquals(questionService.add(TEST_QUESTION_1.getQuestion(), TEST_QUESTION_1.getAnswer()), TEST_QUESTION_1);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_1));
        assertEquals(questionService.add(TEST_QUESTION_2.getQuestion(), TEST_QUESTION_2.getAnswer()), TEST_QUESTION_2);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_2));
        assertEquals(questionService.add(TEST_QUESTION_3.getQuestion(), TEST_QUESTION_3.getAnswer()), TEST_QUESTION_3);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_3));
        assertEquals(questionService.add(TEST_QUESTION_4.getQuestion(), TEST_QUESTION_4.getAnswer()), TEST_QUESTION_4);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_4));
        assertEquals(questionService.add(TEST_QUESTION_5.getQuestion(), TEST_QUESTION_5.getAnswer()), TEST_QUESTION_5);
        assertTrue(questionService.getAll().contains(TEST_QUESTION_5));
        removeTestQuestions();
    }

    @Test
    void remove() {
        addTestQuestions();
        questionService.remove(TEST_QUESTION_1);
        assertFalse(questionService.getAll().contains(TEST_QUESTION_1));
        questionService.remove(TEST_QUESTION_2);
        assertFalse(questionService.getAll().contains(TEST_QUESTION_2));
        questionService.remove(TEST_QUESTION_3);
        assertFalse(questionService.getAll().contains(TEST_QUESTION_3));
        questionService.remove(TEST_QUESTION_4);
        assertFalse(questionService.getAll().contains(TEST_QUESTION_4));
        questionService.remove(TEST_QUESTION_5);
        assertFalse(questionService.getAll().contains(TEST_QUESTION_5));
    }

    @Test
    void getAll() {
        addTestQuestions();
        Set<Question> testQuestionSet = new HashSet<>(Set.of(TEST_QUESTION_1, TEST_QUESTION_2, TEST_QUESTION_3, TEST_QUESTION_4, TEST_QUESTION_5));
        assertEquals(questionService.getAll(), testQuestionSet);
        removeTestQuestions();
    }

    @Test
    void getRandomQuestion() {
        addTestQuestions();
        Question resultRandomQuestion = questionService.getRandomQuestion();
        assertTrue(
                resultRandomQuestion.equals(TEST_QUESTION_1) ||
                        resultRandomQuestion.equals(TEST_QUESTION_2) ||
                        resultRandomQuestion.equals(TEST_QUESTION_3) ||
                        resultRandomQuestion.equals(TEST_QUESTION_4) ||
                        resultRandomQuestion.equals(TEST_QUESTION_5));
    }

    private void addTestQuestions() {
        questionService.add(TEST_QUESTION_1);
        questionService.add(TEST_QUESTION_2);
        questionService.add(TEST_QUESTION_3);
        questionService.add(TEST_QUESTION_4);
        questionService.add(TEST_QUESTION_5);
    }

    private void removeTestQuestions() {
        questionService.remove(TEST_QUESTION_1);
        questionService.remove(TEST_QUESTION_2);
        questionService.remove(TEST_QUESTION_3);
        questionService.remove(TEST_QUESTION_4);
        questionService.remove(TEST_QUESTION_5);
    }
}