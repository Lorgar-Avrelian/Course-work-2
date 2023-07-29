package course_2.course_work_2.data;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class QuestionRepository {
    Map<String, String> questionMap = new HashMap<>();
    Set<Question> questionSet = new HashSet<>();

    public Map<String, String> getQuestionMap() {
        return questionMap;
    }

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void add(Question question) {
        questionMap.put(question.getQuestion(), question.getAnswer());
        questionSet.add(question);
    }

    public void remove(Question question) {
        questionMap.remove(question.getQuestion());
        questionSet.remove(question);
    }
}