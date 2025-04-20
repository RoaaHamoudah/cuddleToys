package com.example.cuddletoys;

import java.util.ArrayList;
import java.util.List;

public class ToysDA implements IToyDA{

    private List<Toy> toys = new ArrayList<>();

    public ToysDA(){

        toys.add(new Toy("T001", "Plush Teddy Bear", "Stuffed Animals", 45.99, 100,
                "A soft and cuddly teddy bear perfect for kids and adults.",
                "CuddleToys", true, R.drawable.plush_teddy_bear, true));

        toys.add(new Toy("T002", "Plush Bunny Rabbit", "Stuffed Animals", 32.99, 150,
                "A fluffy and soft bunny rabbit, perfect for cuddling.",
                "CuddleToys", true, R.drawable.plush_bunny_rabbit, false));

        toys.add(new Toy("T003", "Plush Lion", "Soft Toys", 99.99, 120,
                "A royal lion plush that brings the jungle to life.",
                "CuddleToys", true, R.drawable.plush_lion, false));
        toys.add(new Toy("T004", "Plush Elephant", "Soft Toys", 75.99, 80,
                "A large, cuddly elephant, great for kids who love elephants.",
                "CuddleToys", true, R.drawable.plush_elephant, true));

        toys.add(new Toy("T005", "Plush Giraffe", "Jungle Stuffed Animals", 59.99, 90,
                "A tall and cute giraffe plush, perfect for animal lovers.",
                "CuddleToys", true, R.drawable.plush_giraffe, false));
        toys.add(new Toy("T006", "Plush Zebra", "Jungle Stuffed Animals", 50.50, 110,
                "A soft zebra plush that adds fun and excitement to any collection.",
                "CuddleToys", true, R.drawable.plush_zebra, true));

        toys.add(new Toy("T007", "Plush Panda", "Wildlife Stuffed Animals", 120.99, 200,
                "A soft and adorable panda bear, loved by all ages.",
                "CuddleToys", true, R.drawable.plush_panda, true));
        toys.add(new Toy("T008", "Plush Koala", "Wildlife Stuffed Animals", 85.50, 140,
                "A cute and cuddly koala plush, perfect for wildlife enthusiasts.",
                "CuddleToys", true, R.drawable.plush_koala, false));

    }


    @Override
    public String[] getCats() {
        String[] cats = {"Stuffed Animals", "Soft Toys", "Jungle Stuffed Animals", "Wildlife Stuffed Animals"};
        return cats;
    }

    @Override
    public List<Toy> getToys(String category, double price, boolean isHandmade) {
        List<Toy> result = new ArrayList<>();

        for(Toy b: toys){
            if(b.getCategory().equals(category)&& b.getPrice() <= price && b.isHandmade() == isHandmade){
                result.add(b);
            }
        }
        return result;

    }

    @Override
    public List<Toy> getAllToys() {
        return toys;
    }


}
