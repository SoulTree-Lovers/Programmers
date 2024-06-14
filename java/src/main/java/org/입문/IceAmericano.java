package src.main.java.org.입문;

import java.util.ArrayList;
import java.util.List;

public class IceAmericano {
    static class Solution {
        public List<Integer> solution(int money) {
            List<Integer> answer = new ArrayList<>();

            answer.add(money / 5500);
            answer.add(money % 5500);

            return answer;
        }
    }
}
