package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        questionService.add(TEST_QUESTION_1);
        questionService.add(TEST_QUESTION_2);
        questionService.add(TEST_QUESTION_3);
        questionService.add(TEST_QUESTION_4);
        questionService.add(TEST_QUESTION_5);
        System.out.println(questionService.getAll());
        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(6));
        Collection<Question> actualSet = examinerService.getQuestions(1);
        assertTrue(actualSet.contains(TEST_QUESTION_1) || actualSet.contains(TEST_QUESTION_2) || actualSet.contains(TEST_QUESTION_3) || actualSet.contains(TEST_QUESTION_4) || actualSet.contains(TEST_QUESTION_5));
    }
}