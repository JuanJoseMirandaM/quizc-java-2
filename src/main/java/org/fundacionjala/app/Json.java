package org.fundacionjala.app;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.QuestionType;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.validator.ValidatorType;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Json {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Prueba");

        Question.QuestionBuilder builder1 = new Question.QuestionBuilder("Nombre", QuestionType.TEXT);
        builder1.addValidation(ValidatorType.REQUIRED);
        quiz.addQuestion(builder1.build());

        Question.QuestionBuilder builder2 = new Question.QuestionBuilder("Edad", QuestionType.NUMERIC);
        builder2.addValidation(ValidatorType.MIN);
        quiz.addQuestion(builder2.build());

        writeJsonFile(quiz);

        Quiz parsedQuiz = readJsonFile();
        System.out.println(parsedQuiz);
    }

    private static Quiz readJsonFile() {
        Gson gson = new Gson();
        Quiz quiz = null;
        try (JsonReader reader = new JsonReader(new FileReader("./myForm.json"))) {
            quiz = gson.fromJson(reader, Quiz.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return quiz;
    }

    public static void writeJsonFile(Quiz quiz) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("./myForm.json")) {
            gson.toJson(quiz, writer);
        } catch (JsonIOException | IOException exception) {
            exception.printStackTrace();
        }
    }
}
