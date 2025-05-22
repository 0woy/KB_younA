package org.zowy.service;

import lombok.RequiredArgsConstructor;
import org.zowy.dao.TravelDao;
import org.zowy.dao.TravelDaoImpl;
import org.zowy.domain.TravelImgVO;
import org.zowy.domain.TravelVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {
    private final TravelDao travelDao;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void printTravels(List<TravelVO> travels) {
        travels.forEach(travel -> {
            System.out.printf("%3d %6s %s\n", travel.getNo(), travel.getDistrict(), travel.getTitle());
        });
    }

    private void printDistrict(List<String> district) {
        for(int i=1;i<=district.size();i++) {
            System.out.printf("[%d] %s\n", i, district.get(i-1));
        }
    }

    private int getNumber(String prompt) {
        System.out.print(prompt);
        try {
            int n= Integer.parseInt(br.readLine());
            return n;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printTravels() {
        List<TravelVO> all = travelDao.findAll();
        printTravels(all);
    }

    @Override
    public void printTravelByDistrict() {
        List<String> allDistrict = travelDao.getAllDistrict();
        printDistrict(allDistrict);

        int idx = getNumber("선택: ");
        String district = allDistrict.get(idx-1);

        List<TravelVO> travels = travelDao.findByDestrict(district);
        printTravels(travels);
    }

    @Override
    public void printTravelByPage() {
        int totalPage = (int) Math.ceil(travelDao.getAllCount()/10.0);
        System.out.printf("총 페이지 = %d 페이지\n", totalPage);
        int page = getNumber(String.format("페이지 선택(1~%d): ",totalPage));

        List<TravelVO> travels = travelDao.findByPage(page);
        printTravels(travels);
    }

    @Override
    public void printTravel() {
        long no = getNumber("관광지 No: ");
//        TravelVO travel = travelDao.getTravel(no).orElseThrow(()->new NoSuchElementException("해당 관광지가 없습니다."));
        TravelVO travel = travelDao.getTravel(no).orElseThrow(NoSuchElementException::new);
        System.out.println("권역: "+travel.getDistrict());
        System.out.println("제목: "+travel.getTitle());
        System.out.println("설명");
        String[] desc = travel.getDescription().split("\\.");
        for(String des:desc) {
            System.out.println(des.trim());
        }

        System.out.println("주소: "+travel.getAddress());
        System.out.println("전화번호: "+travel.getPhone());
        System.out.println("사진들");
        for(TravelImgVO image : travel.getImages()) {
            System.out.println(image.getNo()+" "+image.getFilename());
        }
    }
}
