package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        when(questionService.getAll()).thenReturn(JAVA_TEST_QUESTION_SET)
                .thenReturn(MATH_TEST_QUESTION_SET);
        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(11));
        Set<Question> expectedSet = new HashSet<>();
        expectedSet.addAll(JAVA_TEST_QUESTION_SET);
        expectedSet.addAll(MATH_TEST_QUESTION_SET);
        when(questionService.getRandomQuestion()).thenReturn(JAVA_TEST_QUESTION_1)
                .thenReturn(JAVA_TEST_QUESTION_2)
                .thenReturn(JAVA_TEST_QUESTION_3)
                .thenReturn(JAVA_TEST_QUESTION_4)
                .thenReturn(JAVA_TEST_QUESTION_5)
                .thenReturn(MATH_TEST_QUESTION_1)
                .thenReturn(MATH_TEST_QUESTION_2)
                .thenReturn(MATH_TEST_QUESTION_3)
                .thenReturn(MATH_TEST_QUESTION_4)
                .thenReturn(MATH_TEST_QUESTION_5);
        Collection<Question> actualSet = examinerService.getQuestions(10);
        assertEquals(expectedSet, actualSet);
    }
}