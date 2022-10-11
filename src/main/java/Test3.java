import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test3 {
    public static void main(String[] args) {
        //초기값
        Test3 method= new Test3();
        String[] arr = {"coke", "water", "glass", "dog", "dog", "yogurt", "vitamin"};
        int n = 2;
        System.out.println(Arrays.toString(method.solution(arr, n)));

}
    public String[] solution(String[] arr, int n) {
        //시작
        //string[]를 리스트로 변환 할거에요 +빈 lsit
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
//        System.out.println("초기값");
//        System.out.println(list);
        //string 중 중복 삭제 합니다
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))){
                    list2.add(list.get(i));
                    break;
                }}}
        list.removeAll(list2);
//        System.out.println("중복삭제");
//        System.out.println(list);
        //
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).charAt(n)+list.get(i));
        }
//        System.out.println("string앞에 n배열 추가 합니다");
//        System.out.println(list);
//        System.out.println("sort");
          Collections.sort(list);
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).substring(1));
        }
//
//        System.out.println("최종 어레이리스트");
//        System.out.println(list);
//        System.out.println("어레이 -> 최종스트링어레이");
        String[] answer= list.toArray(new String[0]);
   //    System.out.println(Arrays.toString(answer));


        return answer;


    }

}
