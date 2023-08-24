package course_2.course_work_2.data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
@Primary
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    Map<String, String> javaQuestionMap = new HashMap<>();
    Set<Question> javaQuestionSet = new HashSet<>();

    @Override
    public Map<String, String> getQuestionMap() {
        return javaQuestionMap;
    }

    @Override
    public Set<Question> getQuestionSet() {
        return javaQuestionSet;
    }

    @Override
    public void add(Question question) {
        javaQuestionMap.put(question.getQuestion(), question.getAnswer());
        javaQuestionSet.add(question);
    }

    @Override
    public void remove(Question question) {
        javaQuestionMap.remove(question.getQuestion());
        javaQuestionSet.remove(question);
    }
}