package course_2.course_work_2.controllers;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/java")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping(path = "/java/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/java/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question removableQuestion = new Question(question, answer);
        return questionService.remove(removableQuestion);
    }
}