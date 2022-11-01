import java.util.HashMap;
import java.util.List;

public class Problem6Debugging {

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

                  int formsFirstRowLength = forms.toArray().length;
            int formsFirstRowNumber = formsFirstRowLength - 1; //열에 맞는 번호를 위해 미리 길이에서 1을 빼줌

            String nickName ="";
            String emailAddress ="";

            HashMap<String, String> hashMap = new HashMap<String, String>();




            while(formsFirstRowLength > 0){
                emailAddress = forms.toArray()[formsFirstRowNumber].get(0);
                nickName = forms.toArray()[formsFirstRowNumber].get(1);
                int nickNameLength = nickName.length();

                for (int i = 0; i < nickNameLength - 1; i++){
                    String twoWords = nickName.substring(i, i+2);

                    hashMap.put(twoWords,emailAddress);

                }



            }


    }
}
