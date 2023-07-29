package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    Map<String, String> questionMap = new HashMap<>();
    Set<Question> questionSet = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question addedQuestion = new Question(question, answer);
        questionMap.put(question, answer);
        questionSet.add(addedQuestion);
        return addedQuestion;
    }

    @Override
    public Question add(Question question) {
        questionMap.put(question.getQuestion(), question.getAnswer());
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionMap.remove(question.getQuestion());
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return getQuestionSet();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(questionSet);
        return questionList.get(random.nextInt(0, questionList.size()));
    }

    @Override
    public Map<String, String> getQuestionMap() {
        return questionMap;
    }

    @Override
    public Set<Question> getQuestionSet() {
        return questionSet;
    }
}
