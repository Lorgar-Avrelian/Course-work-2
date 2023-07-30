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
class JavaQuestionServiceTest {
    @Mock
    @Qualifier("javaQuestionRepositoryImpl")
    QuestionRepository questionRepository;
    @InjectMocks
    JavaQuestionService questionService;

    @Test
    void add() {
        when(questionRepository.getQuestionSet()).thenReturn(JAVA_TEST_QUESTION_SET);
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
    }

    @Test
    void remove() {
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
        when(questionRepository.getQuestionSet()).thenReturn(JAVA_TEST_QUESTION_SET);
        Set<Question> testQuestionSet = new HashSet<>(Set.of(JAVA_TEST_QUESTION_1, JAVA_TEST_QUESTION_2, JAVA_TEST_QUESTION_3, JAVA_TEST_QUESTION_4, JAVA_TEST_QUESTION_5));
        assertEquals(questionService.getAll(), testQuestionSet);
    }

    @Test
    void getRandomQuestion() {
        when(questionRepository.getQuestionSet()).thenReturn(JAVA_TEST_QUESTION_SET);
        Question resultRandomQuestion = questionService.getRandomQuestion();
        assertTrue(
                resultRandomQuestion.equals(JAVA_TEST_QUESTION_1) ||
                        resultRandomQuestion.equals(JAVA_TEST_QUESTION_2) ||
                        resultRandomQuestion.equals(JAVA_TEST_QUESTION_3) ||
                        resultRandomQuestion.equals(JAVA_TEST_QUESTION_4) ||
                        resultRandomQuestion.equals(JAVA_TEST_QUESTION_5));
    }
}