package com.example.cuddletoys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Search_Browse_Activity extends AppCompatActivity {

    private TextView searchTV;

    private TextView categoryTV;
    private Spinner categorySP;
    private TextView priceTV;

    private RadioGroup priceRG;
    private TextView handmadeTV;
    private CheckBox handmadeCB;
    private CheckBox machinemadeCB;

    private Button filterBT;
    private Button resetBT;

    private ListView toysListView;

    private final IToyDA toyDA = new DAToys().getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_browse_activity);

        searchTV = findViewById(R.id.searchTV);
        categoryTV = findViewById(R.id.categoryTV);
        categorySP = findViewById(R.id.categorySP);
        priceTV = findViewById(R.id.priceTV);
        priceRG = findViewById(R.id.priceRG);
        handmadeTV = findViewById(R.id.handmadeTV);
        handmadeCB = findViewById(R.id.handmadeCB);
        machinemadeCB = findViewById(R.id.machinemadeCB);
        filterBT = findViewById(R.id.filterBT);
        resetBT = findViewById(R.id.resetBT);
        toysListView = findViewById(R.id.toysLV);

        DAToys toy = new DAToys();
        IToyDA toysData = toy.getInstance();
        String[] cats = toysData.getCats();

        ArrayAdapter<String> catsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cats);
        categorySP.setAdapter(catsAdapter);

        // show all toys (browse).
        List<Toy> result = toysData.getAllToys();
        ArrayAdapter<Toy> adapter = new ArrayAdapter<>(Search_Browse_Activity.this, android.R.layout.simple_list_item_1, result);
        toysListView.setAdapter(adapter);

        filterBT.setOnClickListener(v -> {
            String selectedCat = categorySP.getSelectedItem().toString();
            double price = getSelectedPrice();
            boolean handmade = isHMSelected();
            boolean machineMade = isMMSelected();

            List<Toy> filteredToys = filterToys(toysData.getAllToys(), selectedCat, price, handmade, machineMade);
            updateListView(filteredToys);
        });


        resetBT.setOnClickListener(v -> {
            categorySP.setSelection(0);
            priceRG.clearCheck();
            handmadeCB.setChecked(false);
            machinemadeCB.setChecked(false);
            updateListView(result);
        });

    }

    private double getSelectedPrice() {
        int selectedPriceId = priceRG.getCheckedRadioButtonId();
        if (selectedPriceId == R.id.lessThan50) {
            return 50;
        } else if (selectedPriceId == R.id.radio50to100) {
            return 100;
        } else if (selectedPriceId == R.id.greaterThan100) {
            return 101;
        }
        return -1;
    }

    private boolean isHMSelected() {
        return handmadeCB.isChecked();
    }

    private boolean isMMSelected() {
        return machinemadeCB.isChecked();
    }

    private void updateListView(List<Toy> toys) {
        ArrayAdapter<Toy> toyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, toys);
        toysListView.setAdapter(toyAdapter);
    }

    private static List<Toy> filterToys(List<Toy> allToys, String category, double price, boolean handmadeS, boolean machineMadeS) {
        List<Toy> filteredToys = new ArrayList<>();

        for (Toy toy : allToys) {
            boolean matchCat = category.equals("All") || toy.getCategory().equalsIgnoreCase(category);
            boolean matchPrice = (price == 50 && toy.getPrice() < 50) ||
                    (price == 100 && toy.getPrice() >= 50 && toy.getPrice() <= 100) ||
                    (price == 101 && toy.getPrice() > 100);
            boolean matchWay = (handmadeS && toy.isHandmade()) ||
                    (machineMadeS && !toy.isHandmade());

            if (matchCat && matchPrice && matchWay) {
                filteredToys.add(toy);
            }
        }

        return filteredToys;
    }


}
