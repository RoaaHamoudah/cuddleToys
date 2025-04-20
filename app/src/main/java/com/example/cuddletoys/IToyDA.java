package com.example.cuddletoys;

import java.util.List;

public interface IToyDA {

    String[] getCats();

    List<Toy> getToys(String category, double price, boolean isHandmade);

    List<Toy> getAllToys();
}
