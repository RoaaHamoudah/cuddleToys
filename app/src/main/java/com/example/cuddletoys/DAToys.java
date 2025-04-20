package com.example.cuddletoys;

public class DAToys {

    public  IToyDA getInstance(){
        return new ToysDA();
    }
}

