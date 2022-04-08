package com.example.android2hm1.ui.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android2hm1.R;
import com.example.android2hm1.databinding.FragmentDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class DialogFragment extends BottomSheetDialogFragment implements DatePickerDialog.OnDateSetListener {
    FragmentDialogBinding binding;
    private int startYear;
    private int startMonth;
    private int startDay;


    private String date;
    private String repeat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
    }

    private void initClickers() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToDataBase();
                dismiss();
            }
        });
        binding.chooseDateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        binding.chooseRepeatTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRepeatDialog();
            }
        });
    }

    private void writeToDataBase() {
//        String tasks = binding.taskEd.getText().toString();
//        String date = binding.chooseDateTv.getText().toString();
//        String repeat = binding.chooseRepeatTv.getText().toString();
//        Note note = new Note(tasks, date, repeat);
//        db.collection("Note").add(note).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//            }
//        });


    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        startYear = calendar.get(Calendar.YEAR);
        startMonth = calendar.get(Calendar.MONTH);
        startDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), this, startYear, startMonth, startDay);
        datePickerDialog.show();
    }

    private void showRepeatDialog() {
        Dialog alertDialog = new Dialog(requireContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.repeat_dialog, requireView().findViewById(R.id.bottom_shit_con));
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.setContentView(view);
        alertDialog.getWindow().setLayout(600,600); // It didn't work.

        alertDialog.show();

        RadioButton never = alertDialog.findViewById(R.id.never_radioBtn);
        RadioButton everyDay = alertDialog.findViewById(R.id.Every_day_btn);
        RadioButton everyWeer = alertDialog.findViewById(R.id.Every_week_btn);
        RadioButton everyMonth = alertDialog.findViewById(R.id.Every_month_btn);
        never.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String never = "Каждый день";
                binding.chooseRepeatTv.setText(never);
                repeat = never;
                alertDialog.dismiss();
            }
        });
        everyDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Every = "Каждую неделе";
                binding.chooseRepeatTv.setText(Every);
                repeat = Every;
                alertDialog.dismiss();
            }
        });
        everyWeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String week = "Каждый месяц";
                binding.chooseRepeatTv.setText(week);
                repeat = week;
                alertDialog.dismiss();
            }
        });
        everyMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String month = "Каждый год";
                binding.chooseRepeatTv.setText(month);
                repeat = month;
                alertDialog.dismiss();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        date = "" + day + "." + month + 1 + "." + year;
        binding.chooseDateTv.setText("" + day + "." + month + 1 + "." + year);
    }

}
