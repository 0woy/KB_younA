package org.zowy.DataImport;

import org.zowy.DB.JDBCUtil;
import org.zowy.dao.TravelDao;
import org.zowy.dao.TravelDaoImpl;
import org.zowy.domain.TravelImgVO;

import java.io.File;

public class ImportTravelImgData {
    public static void main(String[] args) {
        TravelDao travelDao = new TravelDaoImpl();
        File dir = new File("../travelImg");
        File[] files = dir.listFiles();

        for (File file : files) {
            String fileName = file.getName();
            Long travelId = Long.parseLong(fileName.split("-")[0]);
            TravelImgVO travelImgVO = TravelImgVO
                    .builder()
                    .filename(fileName)
                    .travel_no(travelId)
                    .build();
            travelDao.insertImage(travelImgVO);
        }
        JDBCUtil.close();
    }
}
