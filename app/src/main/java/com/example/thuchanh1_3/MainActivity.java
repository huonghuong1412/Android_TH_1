package com.example.thuchanh1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtId, txtName, txtDate;
    private Button btnAdd, btnDate;
    private Spinner spinner;
    private RatingBar ratingBar;
    private ListView listView;
    private TTAdapter ttAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        // date
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                dialog.show();
            }
        });

        // spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.listImage, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    String t = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // btn add
        List<Thathinh> list = new ArrayList<>();
        ttAdapter = new TTAdapter(list, this);
        listView.setAdapter(ttAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thathinh tt = null;
                int listImage[] = {R.drawable.a, R.drawable.b, R.drawable.c};
                String t = spinner.getSelectedItem().toString();
                if (t.equals("1")) {
                    tt = new Thathinh(txtId.getText().toString(), txtName.getText().toString(), txtDate.getText().toString(), listImage[0], ratingBar.getRating());
                } else  if (t.equals("2")) {
                    tt = new Thathinh(txtId.getText().toString(), txtName.getText().toString(), txtDate.getText().toString(), listImage[1], ratingBar.getRating());
                } else if (t.equals("3")) {
                    tt = new Thathinh(txtId.getText().toString(), txtName.getText().toString(), txtDate.getText().toString(), listImage[2], ratingBar.getRating());
                }

                list.add(tt);
                ttAdapter.notifyDataSetChanged();
            }
        });

    }

    private void init() {
        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        txtDate = findViewById(R.id.txtDate);
        btnAdd = findViewById(R.id.btnAdd);
        btnDate = findViewById(R.id.btnDate);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        ratingBar = findViewById(R.id.ratingBar2);
    }
}