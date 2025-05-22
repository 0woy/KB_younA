package org.zowy.DataImport;

import com.opencsv.bean.CsvToBeanBuilder;
import org.zowy.DB.JDBCUtil;
import org.zowy.dao.TravelDao;
import org.zowy.dao.TravelDaoImpl;
import org.zowy.domain.TravelVO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ImportTravelData {
    public static void main(String[] args) {
        TravelDao travelDao = new TravelDaoImpl();
        try {
            List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                    .withType(TravelVO.class)
                    .build()
                    .parse();

            travels.forEach(travel -> {
                System.out.println(travel);
                travelDao.insert(travel);
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JDBCUtil.close();
    }
}
