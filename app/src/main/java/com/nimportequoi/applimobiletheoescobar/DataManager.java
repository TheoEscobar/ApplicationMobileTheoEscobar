package com.nimportequoi.applimobiletheoescobar;

import java.util.ArrayList;
import java.util.List;

public class DataManager
{
    private static DataManager INSTANCE;

    private List<String> nameList;

    public List<String> getNameList() {
        return nameList;
    }

    private DataManager() {
        nameList = new ArrayList<>();
    }

    public void addItem(String name){
        nameList.add(name);
    }

    public static DataManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }
}
