package course_2.course_work_2.services;

import course_2.course_work_2.data.MathQuestionRepositoryImpl;
import course_2.course_work_2.data.Question;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest {
    private final MathQuestionRepositoryImpl questionRepository = new MathQuestionRepositoryImpl();
    private final QuestionService questionService = new MathQuestionService(questionRepository);

    @Test
    void add() {
        assertEquals(questionService.add(MATH_TEST_QUESTION_1), MATH_TEST_QUESTION_1);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_1));
        assertEquals(questionService.add(MATH_TEST_QUESTION_2), MATH_TEST_QUESTION_2);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_2));
        assertEquals(questionService.add(MATH_TEST_QUESTION_3), MATH_TEST_QUESTION_3);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_3));
        assertEquals(questionService.add(MATH_TEST_QUESTION_4), MATH_TEST_QUESTION_4);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_4));
        assertEquals(questionService.add(MATH_TEST_QUESTION_5), MATH_TEST_QUESTION_5);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_5));
        removeTestQuestions();

        assertEquals(questionService.add(MATH_TEST_QUESTION_1.getQuestion(), MATH_TEST_QUESTION_1.getAnswer()), MATH_TEST_QUESTION_1);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_1));
        assertEquals(questionService.add(MATH_TEST_QUESTION_2.getQuestion(), MATH_TEST_QUESTION_2.getAnswer()), MATH_TEST_QUESTION_2);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_2));
        assertEquals(questionService.add(MATH_TEST_QUESTION_3.getQuestion(), MATH_TEST_QUESTION_3.getAnswer()), MATH_TEST_QUESTION_3);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_3));
        assertEquals(questionService.add(MATH_TEST_QUESTION_4.getQuestion(), MATH_TEST_QUESTION_4.getAnswer()), MATH_TEST_QUESTION_4);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_4));
        assertEquals(questionService.add(MATH_TEST_QUESTION_5.getQuestion(), MATH_TEST_QUESTION_5.getAnswer()), MATH_TEST_QUESTION_5);
        assertTrue(questionService.getAll().contains(MATH_TEST_QUESTION_5));
        removeTestQuestions();
    }

    @Test
    void remove() {
        addTestQuestions();
        questionService.remove(MATH_TEST_QUESTION_1);
        assertFalse(questionService.getAll().contains(MATH_TEST_QUESTION_1));
        questionService.remove(MATH_TEST_QUESTION_2);
        assertFalse(questionService.getAll().contains(MATH_TEST_QUESTION_2));
        questionService.remove(MATH_TEST_QUESTION_3);
        assertFalse(questionService.getAll().contains(MATH_TEST_QUESTION_3));
        questionService.remove(MATH_TEST_QUESTION_4);
        assertFalse(questionService.getAll().contains(MATH_TEST_QUESTION_4));
        questionService.remove(MATH_TEST_QUESTION_5);
        assertFalse(questionService.getAll().contains(MATH_TEST_QUESTION_5));
    }

    @Test
    void getAll() {
        addTestQuestions();
        Set<Question> testQuestionSet = new HashSet<>(Set.of(MATH_TEST_QUESTION_1, MATH_TEST_QUESTION_2, MATH_TEST_QUESTION_3, MATH_TEST_QUESTION_4, MATH_TEST_QUESTION_5));
        assertEquals(questionService.getAll(), testQuestionSet);
        removeTestQuestions();
    }

    @Test
    void getRandomQuestion() {
        addTestQuestions();
        Question resultRandomQuestion = questionService.getRandomQuestion();
        assertTrue(
                resultRandomQuestion.equals(MATH_TEST_QUESTION_1) ||
                        resultRandomQuestion.equals(MATH_TEST_QUESTION_2) ||
                        resultRandomQuestion.equals(MATH_TEST_QUESTION_3) ||
                        resultRandomQuestion.equals(MATH_TEST_QUESTION_4) ||
                        resultRandomQuestion.equals(MATH_TEST_QUESTION_5));
    }

    private void addTestQuestions() {
        questionService.add(MATH_TEST_QUESTION_1);
        questionService.add(MATH_TEST_QUESTION_2);
        questionService.add(MATH_TEST_QUESTION_3);
        questionService.add(MATH_TEST_QUESTION_4);
        questionService.add(MATH_TEST_QUESTION_5);
    }

    private void removeTestQuestions() {
        questionService.remove(MATH_TEST_QUESTION_1);
        questionService.remove(MATH_TEST_QUESTION_2);
        questionService.remove(MATH_TEST_QUESTION_3);
        questionService.remove(MATH_TEST_QUESTION_4);
        questionService.remove(MATH_TEST_QUESTION_5);
    }
}