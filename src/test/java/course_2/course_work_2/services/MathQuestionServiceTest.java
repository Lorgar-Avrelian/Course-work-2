package course_2.course_work_2.services;

import course_2.course_work_2.exceptions.MethodNotAllowed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static course_2.course_work_2.constants.Constants.MATH_TEST_QUESTION_1;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @InjectMocks
    MathQuestionService questionService;

    @Test
    void add() {
        assertThrows(MethodNotAllowed.class, () -> questionService.add(MATH_TEST_QUESTION_1));
    }

    @Test
    void remove() {
        assertThrows(MethodNotAllowed.class, () -> questionService.remove(MATH_TEST_QUESTION_1));
    }

    @Test
    void getAll() {
        assertThrows(MethodNotAllowed.class, () -> questionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        String actualQuestion = questionService.getRandomQuestion().getQuestion();
        assertTrue(actualQuestion.contains(" + ") && actualQuestion.contains(" = ") ||
                actualQuestion.contains(" - ") && actualQuestion.contains(" = ") ||
                actualQuestion.contains(" * ") && actualQuestion.contains(" = ") ||
                actualQuestion.contains(" : ") && actualQuestion.contains(" = "));
    }
}