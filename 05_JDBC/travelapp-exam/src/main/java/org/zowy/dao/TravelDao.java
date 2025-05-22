package org.zowy.dao;

import org.zowy.domain.TravelImgVO;
import org.zowy.domain.TravelVO;

import java.util.List;
import java.util.Optional;

public interface TravelDao {
    void insert(TravelVO travel);
    void insertImage(TravelImgVO travelImg);

    int getAllCount();  // 전체 데이터 건수
    List<String> getAllDistrict();  // 권역 목록
    List<TravelVO> findAll();   // 전체 목록
    List<TravelVO> findByDestrict(String destrict); // 특정 권역 목록
    List<TravelVO> findByPage(int page); // 페이지별 목록
    Optional<TravelVO> getTravel(Long no);  // 관광지 정보 하나 얻기


}
