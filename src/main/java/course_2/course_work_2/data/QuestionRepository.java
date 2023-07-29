package course_2.course_work_2.data;

import java.util.Map;
import java.util.Set;

public interface QuestionRepository {
    Map<String, String> getQuestionMap();

    Set<Question> getQuestionSet();

    void add(Question question);

    void remove(Question question);
}