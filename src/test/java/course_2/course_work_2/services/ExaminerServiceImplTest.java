package course_2.course_work_2.services;

import course_2.course_work_2.data.JavaQuestionRepositoryImpl;
import course_2.course_work_2.data.MathQuestionRepositoryImpl;
import course_2.course_work_2.data.Question;
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
    private final JavaQuestionRepositoryImpl javaQuestionRepository = new JavaQuestionRepositoryImpl();
    private final MathQuestionRepositoryImpl mathQuestionRepository = new MathQuestionRepositoryImpl();
    private final QuestionService javaQuestionService = new JavaQuestionService(javaQuestionRepository);
    private final QuestionService mathQuestionService = new MathQuestionService(mathQuestionRepository);
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);

    @Test
    void getQuestions() {
        javaQuestionService.add(JAVA_TEST_QUESTION_1);
        javaQuestionService.add(JAVA_TEST_QUESTION_2);
        mathQuestionService.add(JAVA_TEST_QUESTION_3);
        mathQuestionService.add(JAVA_TEST_QUESTION_4);
        mathQuestionService.add(JAVA_TEST_QUESTION_5);
        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(6));
        Collection<Question> actualSet = examinerService.getQuestions(5);
        assertEquals(JAVA_TEST_QUESTION_SET, actualSet);
    }
}