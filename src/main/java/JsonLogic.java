import org.json.JSONObject;

public class JsonLogic {


    //The json seems to have a pattern so in this attempt i am trying to manipulate the json with those patterns in mind

    JSONObject jsonValue = new JSONObject();
    JSONObject jsonValueInner = new JSONObject();


    public JSONObject createDummyJson(){
        jsonValue.put("a", 1);
        jsonValue.put("b", true);
        jsonValue.put("c",jsonValueInner.put("d",3));
        jsonValue.put("c",jsonValueInner.put("e","test"));

//        System.out.println(jsonValue);
        return jsonValue;
    }

    public String changeJsonToString(JSONObject json){
        String stringifiedJson = json.toString();
        return stringifiedJson;
    }

    /*check json for semi colon that directly is followed by a curly brace this makes it easy to flatten parent and single child parent
    e.g this is doable {parent:{childOne:1}}

    {parent:{childOne:1, childTwo:2}} this is not (at least at the moment)
     */
    public String checkJsonForCharacters(String stringifiedJson){

        char[] ca= new char[stringifiedJson.length()];

        //add characters to char array

        for(int i = 0;i<stringifiedJson.length();i++){
            boolean foundNestedJson = false;
            if(stringifiedJson.charAt(i) == ':' && stringifiedJson.charAt(i+1) == '{'){
                ca[i-1] = 0;
                ca[i] = '.';
                ca[i+1] = 0;
                ca[i+2] = 0;
                ca[i+4] = 0;
                i = (i+2);
            }else {
                ca[i] = stringifiedJson.charAt(i);
            }

        }
        //returning the json character as newly created String
        filterAgain(new String(ca));
        return new String(ca);
    }

    //was planning to make this filter the json even more by taking out some unnecessary quotation marks
    public void filterAgain(String partiallyFilterredJson){
        char[] finalJsonForm = new char[partiallyFilterredJson.length()];

        for(int i = 0; i < partiallyFilterredJson.length();i++){
            if(partiallyFilterredJson.charAt(i) == '.' && partiallyFilterredJson.charAt(i+2) == '"' ){
                finalJsonForm[i] = partiallyFilterredJson.charAt(i);
                finalJsonForm[i] = partiallyFilterredJson.charAt(i+1);
                i = (i+3);

            }else{
                finalJsonForm[i] = partiallyFilterredJson.charAt(i);
            }
        }
        System.out.println(finalJsonForm);
    }

}
