package com.example.android2hm1.data.model;

import com.example.android2hm1.R;
import com.example.android2hm1.data.model.BoardModel;

import java.util.ArrayList;

public class BoardClient {
    public static ArrayList<BoardModel> list = new ArrayList<>();

    public static ArrayList<BoardModel> getList(){
        ArrayList<BoardModel> list = new ArrayList<>();
        list.add(new BoardModel(R.drawable.image,"Экономь время","Дальше"));
        list.add(new BoardModel(R.drawable.image1,"Достигай целей","Дальше"));
        list.add(new BoardModel(R.drawable.image2,"Развеивайся","Начинаем"));
        return list;
    }
}
