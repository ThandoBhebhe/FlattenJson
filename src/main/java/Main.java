import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        JsonLogic jl = new JsonLogic();

        JSONObject theJson = jl.createDummyJson();

        jl.checkJsonForCharacters(jl.changeJsonToString(theJson));
    }
}
