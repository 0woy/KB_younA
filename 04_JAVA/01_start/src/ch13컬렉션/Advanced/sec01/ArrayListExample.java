package ch13컬렉션.Advanced.sec01;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Board> list = new ArrayList<>();

        list.add(new Board("메롱시티","메롱시티의 기적","최고멋쟁이"));
        list.add(new Board("남이섬","번지점프","지으니와 나"));
        list.add(new Board("5.18","광주 민주화와 지은이 탄생일","민주주의와 지은"));
        list.add(new Board("1030","하늘이 열린 날","나"));
        list.add(new Board("짱구","못말리는 남자","신노스케"));

        System.out.println(list.size());
        System.out.println();

        System.out.println(list.get(3));
        System.out.println();

        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).toString());
        }
        System.out.println();

        list.remove(2);
        list.remove(2);

        for(Board board : list) {
            System.out.println(board.toString());
        }
    }
}
