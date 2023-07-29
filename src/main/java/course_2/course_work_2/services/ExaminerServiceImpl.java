package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Qualifier("javaQuestionRepositoryImpl")
    private final QuestionService javaQuestionService;
    @Qualifier("mathQuestionRepositoryImpl")
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int javaQuestionCount = javaQuestionService.getAll().size();
        int mathQuestionCount = mathQuestionService.getAll().size();
        int questionCount = javaQuestionCount + mathQuestionCount;
        if (questionCount < amount) {
            throw new BadRequestException("Запрошено количество вопросов большее, чем хранится в сервисе!");
        }
        Set<Question> examSet = new HashSet<>();
        int javaQuestionAmount = (int) (Math.random() * amount);
        System.out.println(javaQuestionAmount);
        int mathQuestionAmount = amount - javaQuestionAmount;
        System.out.println(mathQuestionAmount);
        if (javaQuestionAmount > javaQuestionCount) {
            javaQuestionAmount = javaQuestionCount;
            mathQuestionAmount = amount - javaQuestionAmount;
        } else if (mathQuestionAmount > mathQuestionCount) {
            mathQuestionAmount = mathQuestionCount;
            javaQuestionAmount = amount - mathQuestionAmount;
        }
        System.out.println(javaQuestionAmount);
        System.out.println(mathQuestionAmount);
        examSet.addAll(getExamJavaQuestions(javaQuestionAmount));
        examSet.addAll(getExamMathQuestions(mathQuestionAmount));
        return examSet;
    }

    private Collection<Question> getExamJavaQuestions(int amount) {
        Set<Question> javaExamSet = new HashSet<>();
        while (javaExamSet.size() < amount) {
            javaExamSet.add(javaQuestionService.getRandomQuestion());
        }
        return javaExamSet;
    }
    private Collection<Question> getExamMathQuestions(int amount) {
        Set<Question> mathExamSet = new HashSet<>();
        while (mathExamSet.size() < amount) {
            mathExamSet.add(mathQuestionService.getRandomQuestion());
        }
        return mathExamSet;
    }
}