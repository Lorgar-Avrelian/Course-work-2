package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.data.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.Set;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    @Qualifier("mathQuestionRepositoryImpl")
    QuestionRepository questionRepository;
    @InjectMocks
    MathQuestionService questionService;

    @Test
    void add() {
        when(questionRepository.getQuestionSet()).thenReturn(MATH_TEST_QUESTION_SET);
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
    }

    @Test
    void remove() {
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
        when(questionRepository.getQuestionSet()).thenReturn(MATH_TEST_QUESTION_SET);
        Set<Question> testQuestionSet = new HashSet<>(Set.of(MATH_TEST_QUESTION_1, MATH_TEST_QUESTION_2, MATH_TEST_QUESTION_3, MATH_TEST_QUESTION_4, MATH_TEST_QUESTION_5));
        assertEquals(questionService.getAll(), testQuestionSet);
    }

    @Test
    void getRandomQuestion() {
        when(questionRepository.getQuestionSet()).thenReturn(MATH_TEST_QUESTION_SET);
        Question resultRandomQuestion = questionService.getRandomQuestion();
        assertTrue(
                resultRandomQuestion.equals(MATH_TEST_QUESTION_1) ||
                        resultRandomQuestion.equals(MATH_TEST_QUESTION_2) ||
                        resultRandomQuestion.equals(MATH_TEST_QUESTION_3) ||
                        resultRandomQuestion.equals(MATH_TEST_QUESTION_4) ||
                        resultRandomQuestion.equals(MATH_TEST_QUESTION_5));
    }
}