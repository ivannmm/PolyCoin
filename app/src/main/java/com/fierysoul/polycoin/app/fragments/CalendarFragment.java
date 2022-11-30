package com.fierysoul.polycoin.app.fragments;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.databinding.CalendarFragmentBinding;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Objects;

public class CalendarFragment extends Fragment {

    private CalendarFragmentBinding binding;

    CalendarView calendarView;
    Calendar calendar;
    TextView selectedDateText;
    LinearLayout eventScroll;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat) {

        binding = CalendarFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        calendarView = root.findViewById(R.id.calendarView);
//        selectedDateText = root.findViewById(R.id.selectedDateText);
        eventScroll = root.findViewById(R.id.event_list);

        setCurrentDate();
        setCalendarViewListener();

        return binding.getRoot();

    }

    void setCurrentDate() {
        calendar = Calendar.getInstance();
        calendarView.setDate(calendar.getTimeInMillis());
        redrawSelectedDateText();
        redrawEvents();
    }

    void setCalendarViewListener() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                redrawSelectedDateText();
                redrawEvents();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    void redrawSelectedDateText() {
//        selectedDateText.setText(String.format("%s - %d/%d/%d", getString(R.string.selected_date), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)));
    }



    void redrawEvents() {
//        eventScroll.removeAllViews();
        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        for (int i = 0; i < 50; i++) {
            TextView event = new TextView(getActivity());
//            event.setBackgroundTintList();
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
