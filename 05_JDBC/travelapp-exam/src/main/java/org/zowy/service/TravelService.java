package org.zowy.service;

public interface TravelService {
    void printTravels();    // 전체 관광지 목록
    void printTravelByDistrict();   // 특정 권역 관광지 목록 출력
    void printTravelByPage();   // 페이비의 관광지 목록 출력
    void printTravel(); // 관광지 상세 보기
}
