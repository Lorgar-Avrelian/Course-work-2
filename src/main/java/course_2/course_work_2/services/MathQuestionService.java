package course_2.course_work_2.services;

import course_2.course_work_2.data.Question;
import course_2.course_work_2.exceptions.MethodNotAllowed;
import course_2.course_work_2.exceptions.RandomGeneratorException;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowed("Метод не разрешен!");
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowed("Метод не разрешен!");
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowed("Метод не разрешен!");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowed("Метод не разрешен!");
    }

    @Override
    public Question getRandomQuestion() {
        String action = action();
        String mathAnswer;
        String mathQuestion;
        Random random = new Random();
        int firstNum = random.nextInt(1, 100);
        int secondNum = random.nextInt(1, 100);
        double result;
        switch (action) {
            case " + ":
                mathQuestion = firstNum + action + secondNum + " = ";
                result = firstNum + secondNum;
                mathAnswer = String.valueOf(result);
                break;
            case " - ":
                mathQuestion = firstNum + action + secondNum + " = ";
                result = firstNum - secondNum;
                mathAnswer = String.valueOf(result);
                break;
            case " * ":
                mathQuestion = firstNum + action + secondNum + " = ";
                result = firstNum * secondNum;
                mathAnswer = String.valueOf(result);
                break;
            case " : ":
                mathQuestion = firstNum + action + secondNum + " = ";
                result = (double) firstNum / secondNum;
                mathAnswer = new DecimalFormat("##.###").format(result);
                break;
            default:
                throw new RandomGeneratorException("Ошибка в формировании вопроса!");
        }
        Question newMathQuestion = new Question(mathQuestion, mathAnswer);
        return newMathQuestion;
    }

    private static String action() {
        Random random = new Random();
        int actionCode = random.nextInt(1, 5);
        switch (actionCode) {
            case 1:
                return " + ";
            case 2:
                return " - ";
            case 3:
                return " * ";
            case 4:
                return " : ";
            default:
                throw new RandomGeneratorException("Ошибка в формировании математического действия!");
        }
    }
}