package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}