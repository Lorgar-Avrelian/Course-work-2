package course_2.course_work_2.data;

import org.junit.jupiter.api.Test;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionRepositoryImplTest {
    QuestionRepository questionRepository = new JavaQuestionRepositoryImpl();

    @Test
    void getQuestionMap() {
        addTestQuestions();
        assertEquals(JAVA_TEST_QUESTION_MAP, questionRepository.getQuestionMap());
        removeTestQuestions();
    }

    @Test
    void getQuestionSet() {
        addTestQuestions();
        assertEquals(JAVA_TEST_QUESTION_SET, questionRepository.getQuestionSet());
        removeTestQuestions();
    }

    @Test
    void add() {
        addTestQuestions();
        assertTrue(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_1));
        assertTrue(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_1.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_1.getQuestion()));
        assertTrue(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_2));
        assertTrue(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_2.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_2.getQuestion()));
        assertTrue(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_3));
        assertTrue(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_3.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_3.getQuestion()));
        assertTrue(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_4));
        assertTrue(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_4.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_4.getQuestion()));
        assertTrue(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_5));
        assertTrue(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_5.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_5.getQuestion()));
        removeTestQuestions();
    }

    @Test
    void remove() {
        addTestQuestions();
        questionRepository.remove(JAVA_TEST_QUESTION_1);
        assertFalse(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_1));
        assertFalse(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_1.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_1.getQuestion()));
        questionRepository.remove(JAVA_TEST_QUESTION_2);
        assertFalse(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_2));
        assertFalse(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_2.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_2.getQuestion()));
        questionRepository.remove(JAVA_TEST_QUESTION_3);
        assertFalse(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_3));
        assertFalse(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_3.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_3.getQuestion()));
        questionRepository.remove(JAVA_TEST_QUESTION_4);
        assertFalse(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_4));
        assertFalse(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_4.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_4.getQuestion()));
        questionRepository.remove(JAVA_TEST_QUESTION_5);
        assertFalse(questionRepository.getQuestionSet().contains(JAVA_TEST_QUESTION_5));
        assertFalse(questionRepository.getQuestionMap().containsValue(JAVA_TEST_QUESTION_5.getAnswer()) && questionRepository.getQuestionMap().containsKey(JAVA_TEST_QUESTION_5.getQuestion()));
    }

    public void addTestQuestions() {
        questionRepository.add(JAVA_TEST_QUESTION_1);
        questionRepository.add(JAVA_TEST_QUESTION_2);
        questionRepository.add(JAVA_TEST_QUESTION_3);
        questionRepository.add(JAVA_TEST_QUESTION_4);
        questionRepository.add(JAVA_TEST_QUESTION_5);
    }

    public void removeTestQuestions() {
        questionRepository.remove(JAVA_TEST_QUESTION_1);
        questionRepository.remove(JAVA_TEST_QUESTION_2);
        questionRepository.remove(JAVA_TEST_QUESTION_3);
        questionRepository.remove(JAVA_TEST_QUESTION_4);
        questionRepository.remove(JAVA_TEST_QUESTION_5);
    }
}