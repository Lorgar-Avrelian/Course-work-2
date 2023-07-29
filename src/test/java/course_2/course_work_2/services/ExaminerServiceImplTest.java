package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.data.QuestionRepository;
import course_2.course_work_2.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static course_2.course_work_2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExaminerServiceImpl.class)
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @MockBean
    QuestionRepository questionRepository = new QuestionRepository();
    @MockBean
    QuestionService questionService = new JavaQuestionService(questionRepository);
    @Autowired
    ExaminerService examinerService = new ExaminerServiceImpl(questionService);

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