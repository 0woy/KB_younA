package ch10라이브러리.Basic.baseModule.sec04;

public class MeasureRuntimeExample {
    public static void main(String[] args) {
        long time1 = System.nanoTime();
        int sum =0;
        for (int i = 0; i <= 1000000; i++) {
            sum += i;
        }
        long time2 = System.nanoTime();
        System.out.println("1~1,000,000까지의 합: "+sum);
        System.out.println("계산에 "+(time2-time1)+" 나노 초가 소요되었습니다.");
    }
}
