package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Service
public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    Map<String, String> getQuestionMap();

    Set<Question> getQuestionSet();
}
