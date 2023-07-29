package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.data.QuestionRepository;
import course_2.course_work_2.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private final QuestionRepository questionRepository = new QuestionRepository();
    private final QuestionService questionService = new JavaQuestionService(questionRepository);
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(questionService);

    @Test
    void getQuestions() {
        questionService.add(TEST_QUESTION_1);
        questionService.add(TEST_QUESTION_2);
        questionService.add(TEST_QUESTION_3);
        questionService.add(TEST_QUESTION_4);
        questionService.add(TEST_QUESTION_5);
        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(6));
        Collection<Question> actualSet = examinerService.getQuestions(5);
        assertEquals(TEST_QUESTION_SET, actualSet);
    }
}