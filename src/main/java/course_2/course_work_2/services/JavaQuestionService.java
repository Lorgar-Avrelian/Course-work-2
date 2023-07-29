package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.data.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question addedQuestion = new Question(question, answer);
        questionRepository.add(addedQuestion);
        return addedQuestion;
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getQuestionSet();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(questionRepository.getQuestionSet());
        return questionList.get(random.nextInt(0, questionList.size()));
    }
}