package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;

        int count1To1 = 0; //number가 1일 때 손뼉치는 개수, 0
        int count1To10 = 3; //number가 10일 때 손뼉치는 개수, 3
        int count1To100 = count1To10*10 + 10*3; //number가 100일 때 손뼉치는 개수, 60
        int count1To1000 = count1To100*10 + 100*3; //number가 1000일 때 손뼉치는 개수, 900


        ArrayList<Integer> ArrayOfCount = new ArrayList<>(); //number가 1, 10, 100, 1000일 때 손뼉치는 개수를 순서대로 배열로 만듦
        ArrayOfCount.add(count1To1);
        ArrayOfCount.add(count1To10);
        ArrayOfCount.add(count1To100);
        ArrayOfCount.add(count1To1000);

        /*제가 하고자하는 방법은, 예를 들어 4522가 number라면

        4000까지 박수 개수 = 1 ~ 999까지 박수 개수 + 1000 ~ 1999까지 박수 개수 + 2000~ 2999까지 박수 개수 + (3000 ~ 3999까지 박수 개수)
                         = count1To1000 + count1To1000 + count1To1000 + (count1To1000 + 1000)

        4500까지 박수 개수 = 4000까지 박수 개수 + 4000 ~ 4099까지 박수 개수 + 4100 ~ 4199까지 박수 개수 + 4200 ~ 4299까지 박수 개수 + (4300 ~ 4399까지 박수 개수) + 4400 ~ 4499까지 박수 개수
                         = 4000까지 박수 개수 + count1To100 + count1To100 + count1To100 + (count1To100 + 100) + count1To100

        4520까지 박수 개수 = 4500까지 박수 개수 + 4500 ~ 4509까지 박수 개수 + 4510 ~ 4519까지 박수 개수
                         = 4500까지 박수 개수 + count1To10 + count1To10

        4522까지 박수 개수 = 4520까지 박수 개수 + 4520 ~ 4521까지 박수 개수 + 4521 ~ 4522까지 박수 개수
                         = 4520까지 박수 개수 + count1To1 + count1To1
                         = 4 * count1To1000 + 1(=4/3) * 1000   +   5 * count1To100 + 1(=5/3) * 100   +   2 * count1To10 + 0(=2/3) * 10   +   2 * count1To1 + 0(=2/3) * 1

                         이런식으로 구해주려고 하고 있습니다.
        */

        ArrayList<Integer> arrayEachDigitOfNumber = new ArrayList<>(); // 위의 풀이를 보았을 때 4,5,2,2와 같은 각 자리수가 중요하므로 각 자리수를 하나씩 (일의 자리로) 만들어 주기 위해 배열을 정의

        while (number > 0) { //number의 각 자리수를 배열에 저장

            arrayEachDigitOfNumber.add(number%10);
            number /= 10;

        }




        int sizeOfNumber = arrayEachDigitOfNumber.size(); //number가 몇의 자리수인지 확인

        while (sizeOfNumber > 0) {

            answer += ArrayOfCount.get(sizeOfNumber-1) * arrayEachDigitOfNumber.get(sizeOfNumber-1);

            int quotientOfEachDigit = arrayEachDigitOfNumber.get(sizeOfNumber-1) / 3;

            if (arrayEachDigitOfNumber.get(sizeOfNumber-1)%3 == 0) { // 예외사항 각 자리수가 3의 배수일 때는 조금 다르게 풀림 그것에 관한 것

                int tenSquaredToProduct = 1;


                for (int i = 0; i < sizeOfNumber ; i++) { //몇의 자리 수 인지 확인 후 tenSquaredToProduct라는 변수에 저장
                    answer += tenSquaredToProduct * arrayEachDigitOfNumber.get(i-1);
                    tenSquaredToProduct *= 10;
                }

                answer += 1;

                answer += (quotientOfEachDigit-1) * tenSquaredToProduct;

            } else if (arrayEachDigitOfNumber.get(sizeOfNumber-1)%3 != 0) { // 예외사항이 아닌, 각 자리수가 3의 배수가 아닐 때는 일반적이게 풀림
                int pow = 1;
                int powValue = 1;
                while (pow < sizeOfNumber) { //제곱 수 구해주기
                    powValue *= 10;
                    pow += 1;
                }

                answer += (quotientOfEachDigit) * powValue;
            }
            sizeOfNumber -= 1;
        }




        return answer;
    }
}
