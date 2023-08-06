package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    MathQuestionService mathQuestionService;
    @Mock
    JavaQuestionService javaQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(JAVA_TEST_QUESTION_1)
                .thenReturn(JAVA_TEST_QUESTION_2)
                .thenReturn(JAVA_TEST_QUESTION_3)
                .thenReturn(JAVA_TEST_QUESTION_4)
                .thenReturn(JAVA_TEST_QUESTION_5);
        when(mathQuestionService.getRandomQuestion()).thenReturn(MATH_TEST_QUESTION_1)
                .thenReturn(MATH_TEST_QUESTION_2)
                .thenReturn(MATH_TEST_QUESTION_3)
                .thenReturn(MATH_TEST_QUESTION_4)
                .thenReturn(MATH_TEST_QUESTION_5);
        Collection<Question> actualSet = new HashSet<>(examinerService.getQuestions(5));
        Collection<Question> expectedSet1 = new HashSet<>(Set.of(JAVA_TEST_QUESTION_1, MATH_TEST_QUESTION_1, MATH_TEST_QUESTION_2, MATH_TEST_QUESTION_3, MATH_TEST_QUESTION_4));
        Collection<Question> expectedSet2 = new HashSet<>(Set.of(JAVA_TEST_QUESTION_1, JAVA_TEST_QUESTION_2, MATH_TEST_QUESTION_1, MATH_TEST_QUESTION_2, MATH_TEST_QUESTION_3));
        Collection<Question> expectedSet3 = new HashSet<>(Set.of(JAVA_TEST_QUESTION_1, JAVA_TEST_QUESTION_2, JAVA_TEST_QUESTION_3, MATH_TEST_QUESTION_1, MATH_TEST_QUESTION_2));
        Collection<Question> expectedSet4 = new HashSet<>(Set.of(JAVA_TEST_QUESTION_1, JAVA_TEST_QUESTION_2, JAVA_TEST_QUESTION_3, JAVA_TEST_QUESTION_4, MATH_TEST_QUESTION_1));
        assertTrue(actualSet.equals(MATH_TEST_QUESTION_SET) || actualSet.equals(JAVA_TEST_QUESTION_SET) ||
                actualSet.equals(expectedSet1) || actualSet.equals(expectedSet2) || actualSet.equals(expectedSet3) ||
                actualSet.equals(expectedSet4));
    }
}