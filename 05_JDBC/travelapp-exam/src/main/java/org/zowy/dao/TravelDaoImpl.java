package org.zowy.dao;

import org.zowy.DB.JDBCUtil;
import org.zowy.domain.TravelImgVO;
import org.zowy.domain.TravelVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelDaoImpl implements TravelDao {
    Connection conn= JDBCUtil.getConnection();

    private TravelVO map(ResultSet rs) throws SQLException {
        return TravelVO
                .builder()
                .no(rs.getLong("no"))
                .district(rs.getString("district"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .address(rs.getString("address"))
                .phone(rs.getString("phone"))
                .build();
    }

    private TravelImgVO mapImg(ResultSet rs) throws SQLException {
        return TravelImgVO
                .builder()
                .no(rs.getLong("no"))
                .filename(rs.getString("filename"))
                .travel_no(rs.getLong("travel_no"))
                .build();
    }
    @Override
    public void insert(TravelVO travel) {
        String sql = "INSERT INTO tbl_travel VALUES(?,?,?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(1, travel.getNo());
            pstmt.setString(2, travel.getDistrict());
            pstmt.setString(3, travel.getTitle());
            pstmt.setString(4, travel.getDescription());
            pstmt.setString(5, travel.getAddress());
            pstmt.setString(6, travel.getPhone());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertImage(TravelImgVO travelImg) {
        String sql = "INSERT INTO tbl_travel_img(filename, travel_no) VALUES(?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, travelImg.getFilename());
            pstmt.setLong(2, travelImg.getTravel_no());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getAllCount() {
        String sql = "SELECT COUNT(*) FROM tbl_travel";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rs = pstmt.executeQuery()){
                rs.next();
                int count = rs.getInt(1);
                return count;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getAllDistrict() {
        List<String> district = new ArrayList<>();
        String sql = "SELECT DISTINCT(district) FROM tbl_travel";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                district.add(rs.getString(1));
            }
            return district;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TravelVO> findAll() {
        String sql = "SELECT * FROM tbl_travel";
        List<TravelVO> travels = new ArrayList<>();
        try(PreparedStatement pstmp = conn.prepareStatement(sql)){
            try(ResultSet rs = pstmp.executeQuery()){
                while(rs.next()){
                    TravelVO travel = map(rs);
                    travels.add(travel);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    @Override
    public List<TravelVO> findByDestrict(String destrict) {
        String sql = "SELECT * FROM tbl_travel WHERE district = ?";
        List<TravelVO> travels = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, destrict);
           try(ResultSet rs = pstmt.executeQuery()){
               while(rs.next()){
                   TravelVO travel = map(rs);
                   travels.add(travel);
               }
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    @Override
    public List<TravelVO> findByPage(int page) {
        List<TravelVO> travels = new ArrayList<>();
        String sql = "SELECT * FROM tbl_travel ORDER BY district, title LIMIT ?,?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int count = 10;
            int start = (page - 1) * count;
            pstmt.setInt(1, start);
            pstmt.setInt(2, count);

            try(ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    TravelVO travelVO = map(rs);
                    travels.add(travelVO);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    @Override
    public Optional<TravelVO> getTravel(Long no) {
        TravelVO travel = null;
        String sql = """
                SELECT t.*, ti.no as tino, ti.filename, ti.travel_no from tbl_travel t
                LEFT OUTER JOIN tbl_travel_img ti ON t.no = ti.travel_no
                WHERE t.no = ?
                """;
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(1, no);
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()){
                    travel = map(rs);
                    List<TravelImgVO> images = new ArrayList<>();
                    try {
                        do{
                            TravelImgVO image = mapImg(rs);
                            images.add(image);
                        }while(rs.next());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    travel.setImages(images);
                    return Optional.of(travel);
                }else{
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
