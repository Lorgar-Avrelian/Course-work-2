package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getQuestionSet().size() < amount) {
            throw new BadRequestException("Запрошено количество вопросов большее, чем хранится в сервисе!");
        }
        Set<Question> examSet = new HashSet<>();
        while (examSet.size() < amount) {
            examSet.add(questionService.getRandomQuestion());
        }
        return examSet;
    }
}
