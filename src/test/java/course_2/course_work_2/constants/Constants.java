package course_2.course_work_2.constants;

import course_2.course_work_2.data.Question;

import java.util.Set;

public class Constants {
    public static final Question TEST_QUESTION_1 = new Question("QuestionText1", "QuestionAnswer1");
    public static final Question TEST_QUESTION_2 = new Question("QuestionText2", "QuestionAnswer2");
    public static final Question TEST_QUESTION_3 = new Question("QuestionText3", "QuestionAnswer3");
    public static final Question TEST_QUESTION_4 = new Question("QuestionText4", "QuestionAnswer4");
    public static final Question TEST_QUESTION_5 = new Question("QuestionText5", "QuestionAnswer5");
    public static final Set<Question> TEST_QUESTION_SET = Set.of(TEST_QUESTION_1, TEST_QUESTION_2, TEST_QUESTION_3, TEST_QUESTION_4, TEST_QUESTION_5);
}