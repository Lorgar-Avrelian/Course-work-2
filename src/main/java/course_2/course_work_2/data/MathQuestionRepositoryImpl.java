package course_2.course_work_2.data;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//@Repository
public class MathQuestionRepositoryImpl implements QuestionRepository {
    Map<String, String> mathQuestionMap = new HashMap<>();
    Set<Question> mathQuestionSet = new HashSet<>();

    @Override
    public Map<String, String> getQuestionMap() {
        return mathQuestionMap;
    }

    @Override
    public Set<Question> getQuestionSet() {
        return mathQuestionSet;
    }

    @Override
    public void add(Question question) {
        mathQuestionMap.put(question.getQuestion(), question.getAnswer());
        mathQuestionSet.add(question);
    }

    @Override
    public void remove(Question question) {
        mathQuestionMap.remove(question.getQuestion());
        mathQuestionSet.remove(question);
    }
}