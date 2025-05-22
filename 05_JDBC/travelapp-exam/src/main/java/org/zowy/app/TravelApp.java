package org.zowy.app;

import org.zowy.DB.JDBCUtil;
import org.zowy.dao.TravelDao;
import org.zowy.dao.TravelDaoImpl;
import org.zowy.service.TravelService;
import org.zowy.service.TravelServiceImpl;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TravelApp {
    TravelService service;
    MenuItem[] menu;
    BufferedReader br;

    public TravelApp() {
        TravelDao travelDao = new TravelDaoImpl();
        service = new TravelServiceImpl(travelDao);
        menu = new MenuItem[]{
                new MenuItem("전체 목록", service::printTravels),
                new MenuItem("페이지 목록", service::printTravelByPage),
                new MenuItem("권역별 목록", service::printTravelByDistrict),
                new MenuItem("상세 보기", service::printTravel),
                new MenuItem("종료", this::exit)
        };
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void exit(){
        JDBCUtil.close();
        System.exit(0);
    }

    public void run(){
        while(true) {
            printMenu();
            int ix = getMenuIdx();
            Runnable command = menu[ix-1].getCommand();
            command.run();
        }
    }

    private int getMenuIdx() {
        System.out.print("선택: ");
        try {
            int ix = Integer.parseInt(br.readLine());
            return ix;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printMenu() {
        System.out.println("============================================================");
        for(int i=0;i<menu.length;i++) {
            System.out.printf("(%d) %s ", i+1, menu[i].getTitle());
        }
        System.out.println();
        System.out.println("============================================================");
    }

    public static void main(String[] args) {
        TravelApp app = new TravelApp();
        app.run();
    }
}
