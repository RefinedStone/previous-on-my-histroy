import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public int solution(int[] arr1) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //리스트에 0~9까지 넣기
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //int[]에 있는값 제거
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j <list.size(); j++) {
                if(arr1[i]==list.get(j)){
                    list.remove(j);
                }
            }
        }
        //정렬하기
        Collections.sort(list);
        int a= list.get(0);
        int b= list.get(1);
        int sum=0;
        for (int i = a; i <b+1; i++) {
        sum=sum+i;
        }
        return sum;

    }
    public static void main(String[] args) {

        Test method = new Test();
        int[] arr1 = {1,3,5,9,2,4,8,0};
        System.out.println(method.solution(arr1));
    }
}
