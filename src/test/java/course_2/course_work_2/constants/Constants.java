package course_2.course_work_2.constants;

import course_2.course_work_2.data.Question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Constants {
    public static final Question JAVA_TEST_QUESTION_1 = new Question("JAVA_QuestionText1", "JAVA_QuestionAnswer1");
    public static final Question JAVA_TEST_QUESTION_2 = new Question("JAVA_QuestionText2", "JAVA_QuestionAnswer2");
    public static final Question JAVA_TEST_QUESTION_3 = new Question("JAVA_QuestionText3", "JAVA_QuestionAnswer3");
    public static final Question JAVA_TEST_QUESTION_4 = new Question("JAVA_QuestionText4", "JAVA_QuestionAnswer4");
    public static final Question JAVA_TEST_QUESTION_5 = new Question("JAVA_QuestionText5", "JAVA_QuestionAnswer5");
    public static final Map<String, String> JAVA_TEST_QUESTION_MAP = new HashMap<>(Map.of(
            JAVA_TEST_QUESTION_1.getQuestion(), JAVA_TEST_QUESTION_1.getAnswer(),
            JAVA_TEST_QUESTION_2.getQuestion(), JAVA_TEST_QUESTION_2.getAnswer(),
            JAVA_TEST_QUESTION_3.getQuestion(), JAVA_TEST_QUESTION_3.getAnswer(),
            JAVA_TEST_QUESTION_4.getQuestion(), JAVA_TEST_QUESTION_4.getAnswer(),
            JAVA_TEST_QUESTION_5.getQuestion(), JAVA_TEST_QUESTION_5.getAnswer()));
    public static final Set<Question> JAVA_TEST_QUESTION_SET = Set.of(
            JAVA_TEST_QUESTION_1,
            JAVA_TEST_QUESTION_2,
            JAVA_TEST_QUESTION_3,
            JAVA_TEST_QUESTION_4,
            JAVA_TEST_QUESTION_5);
    public static final Question MATH_TEST_QUESTION_1 = new Question("MATH_QuestionText1", "MATH_QuestionAnswer1");
    public static final Question MATH_TEST_QUESTION_2 = new Question("MATH_QuestionText2", "MATH_QuestionAnswer2");
    public static final Question MATH_TEST_QUESTION_3 = new Question("MATH_QuestionText3", "MATH_QuestionAnswer3");
    public static final Question MATH_TEST_QUESTION_4 = new Question("MATH_QuestionText4", "MATH_QuestionAnswer4");
    public static final Question MATH_TEST_QUESTION_5 = new Question("MATH_QuestionText5", "MATH_QuestionAnswer5");
    public static final Map<String, String> MATH_TEST_QUESTION_MAP = new HashMap<>(Map.of(
            MATH_TEST_QUESTION_1.getQuestion(), MATH_TEST_QUESTION_1.getAnswer(),
            MATH_TEST_QUESTION_2.getQuestion(), MATH_TEST_QUESTION_2.getAnswer(),
            MATH_TEST_QUESTION_3.getQuestion(), MATH_TEST_QUESTION_3.getAnswer(),
            MATH_TEST_QUESTION_4.getQuestion(), MATH_TEST_QUESTION_4.getAnswer(),
            MATH_TEST_QUESTION_5.getQuestion(), MATH_TEST_QUESTION_5.getAnswer()));
    public static final Set<Question> MATH_TEST_QUESTION_SET = Set.of(
            MATH_TEST_QUESTION_1,
            MATH_TEST_QUESTION_2,
            MATH_TEST_QUESTION_3,
            MATH_TEST_QUESTION_4,
            MATH_TEST_QUESTION_5);
}
