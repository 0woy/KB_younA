package org.zowy;

import com.opencsv.bean.CsvToBeanBuilder;
import org.zowy.domain.TravelVO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVTest2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<TravelVO> list = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                .withType(TravelVO.class)
                .build()
                .parse();

       list.forEach(t -> System.out.println(t));
    }
}
