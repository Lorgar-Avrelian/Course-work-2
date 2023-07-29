package course_2.course_work_2.services;

import course_2.course_work_2.data.JavaQuestionRepositoryImpl;
import course_2.course_work_2.data.Question;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionRepositoryImpl questionRepository = new JavaQuestionRepositoryImpl();
    private final QuestionService questionService = new JavaQuestionService(questionRepository);

    @Test
    void add() {
        assertEquals(questionService.add(JAVA_TEST_QUESTION_1), JAVA_TEST_QUESTION_1);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_1));
        assertEquals(questionService.add(JAVA_TEST_QUESTION_2), JAVA_TEST_QUESTION_2);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_2));
        assertEquals(questionService.add(JAVA_TEST_QUESTION_3), JAVA_TEST_QUESTION_3);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_3));
        assertEquals(questionService.add(JAVA_TEST_QUESTION_4), JAVA_TEST_QUESTION_4);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_4));
        assertEquals(questionService.add(JAVA_TEST_QUESTION_5), JAVA_TEST_QUESTION_5);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_5));
        removeTestQuestions();

        assertEquals(questionService.add(JAVA_TEST_QUESTION_1.getQuestion(), JAVA_TEST_QUESTION_1.getAnswer()), JAVA_TEST_QUESTION_1);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_1));
        assertEquals(questionService.add(JAVA_TEST_QUESTION_2.getQuestion(), JAVA_TEST_QUESTION_2.getAnswer()), JAVA_TEST_QUESTION_2);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_2));
        assertEquals(questionService.add(JAVA_TEST_QUESTION_3.getQuestion(), JAVA_TEST_QUESTION_3.getAnswer()), JAVA_TEST_QUESTION_3);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_3));
        assertEquals(questionService.add(JAVA_TEST_QUESTION_4.getQuestion(), JAVA_TEST_QUESTION_4.getAnswer()), JAVA_TEST_QUESTION_4);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_4));
        assertEquals(questionService.add(JAVA_TEST_QUESTION_5.getQuestion(), JAVA_TEST_QUESTION_5.getAnswer()), JAVA_TEST_QUESTION_5);
        assertTrue(questionService.getAll().contains(JAVA_TEST_QUESTION_5));
        removeTestQuestions();
    }

    @Test
    void remove() {
        addTestQuestions();
        questionService.remove(JAVA_TEST_QUESTION_1);
        assertFalse(questionService.getAll().contains(JAVA_TEST_QUESTION_1));
        questionService.remove(JAVA_TEST_QUESTION_2);
        assertFalse(questionService.getAll().contains(JAVA_TEST_QUESTION_2));
        questionService.remove(JAVA_TEST_QUESTION_3);
        assertFalse(questionService.getAll().contains(JAVA_TEST_QUESTION_3));
        questionService.remove(JAVA_TEST_QUESTION_4);
        assertFalse(questionService.getAll().contains(JAVA_TEST_QUESTION_4));
        questionService.remove(JAVA_TEST_QUESTION_5);
        assertFalse(questionService.getAll().contains(JAVA_TEST_QUESTION_5));
    }

    @Test
    void getAll() {
        addTestQuestions();
        Set<Question> testQuestionSet = new HashSet<>(Set.of(JAVA_TEST_QUESTION_1, JAVA_TEST_QUESTION_2, JAVA_TEST_QUESTION_3, JAVA_TEST_QUESTION_4, JAVA_TEST_QUESTION_5));
        assertEquals(questionService.getAll(), testQuestionSet);
        removeTestQuestions();
    }

    @Test
    void getRandomQuestion() {
        addTestQuestions();
        Question resultRandomQuestion = questionService.getRandomQuestion();
        assertTrue(
                resultRandomQuestion.equals(JAVA_TEST_QUESTION_1) ||
                        resultRandomQuestion.equals(JAVA_TEST_QUESTION_2) ||
                        resultRandomQuestion.equals(JAVA_TEST_QUESTION_3) ||
                        resultRandomQuestion.equals(JAVA_TEST_QUESTION_4) ||
                        resultRandomQuestion.equals(JAVA_TEST_QUESTION_5));
    }

    private void addTestQuestions() {
        questionService.add(JAVA_TEST_QUESTION_1);
        questionService.add(JAVA_TEST_QUESTION_2);
        questionService.add(JAVA_TEST_QUESTION_3);
        questionService.add(JAVA_TEST_QUESTION_4);
        questionService.add(JAVA_TEST_QUESTION_5);
    }

    private void removeTestQuestions() {
        questionService.remove(JAVA_TEST_QUESTION_1);
        questionService.remove(JAVA_TEST_QUESTION_2);
        questionService.remove(JAVA_TEST_QUESTION_3);
        questionService.remove(JAVA_TEST_QUESTION_4);
        questionService.remove(JAVA_TEST_QUESTION_5);
    }
}