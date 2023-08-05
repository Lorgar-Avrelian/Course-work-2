package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    //    @Qualifier("javaQuestionRepositoryImpl")
//    private final QuestionService javaQuestionService;
//    @Qualifier("mathQuestionRepositoryImpl")
//    private final QuestionService mathQuestionService;
//
//    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
//        this.javaQuestionService = javaQuestionService;
//        this.mathQuestionService = mathQuestionService;
//    }

    @Qualifier("javaQuestionService")
    QuestionService javaQuestionService;
    @Qualifier("mathQuestionService")
    QuestionService mathQuestionService;

    @Autowired
    public void setJavaQuestionService(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Autowired
    public void setMathQuestionService(QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
//        int javaQuestionCount = javaQuestionService.getAll().size();
//        int mathQuestionCount = mathQuestionService.getAll().size();
//        int questionCount = javaQuestionCount + mathQuestionCount;
//        if (questionCount < amount) {
//            throw new BadRequestException("Запрошено количество вопросов большее, чем хранится в сервисе!");
//        }
//        int javaQuestionAmount = (int) (Math.random() * amount);
//        int mathQuestionAmount = amount - javaQuestionAmount;
//        if (javaQuestionAmount > javaQuestionCount) {
//            javaQuestionAmount = javaQuestionCount;
//            mathQuestionAmount = amount - javaQuestionAmount;
//        } else if (mathQuestionAmount > mathQuestionCount) {
//            mathQuestionAmount = mathQuestionCount;
//            javaQuestionAmount = amount - mathQuestionAmount;
//        }
        Random random = new Random();
        Set<Question> examSet = new HashSet<>();
        int javaQuestionAmount = random.nextInt(amount);
        int mathQuestionAmount = amount - javaQuestionAmount;
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