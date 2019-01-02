package milionerzy;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JSONReading {

    public static Question readQuestionJSON() throws IOException {

        Question question = new Question();
        JSONObject json = readJsonFromUrl("http://127.0.0.1:8080/api/question/" + Integer.toString(Question.getCounter()));

        question.setQuestion(json.getString("question"));
        question.setAnswer1(json.getString("answer1"));
        question.setAnswer2(json.getString("answer2"));
        question.setAnswer3(json.getString("answer3"));
        question.setAnswer4(json.getString("answer4"));
        question.setCorrect_Answer(json.getString("correct_Answer"));

        return question;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

}
