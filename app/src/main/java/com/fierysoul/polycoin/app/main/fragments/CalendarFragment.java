package com.fierysoul.polycoin.app.main.fragments;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.databinding.CalendarFragmentBinding;
import com.fierysoul.polycoin.util.EventInfo;
import com.fierysoul.polycoin.util.Util;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class CalendarFragment extends Fragment {

    private CalendarFragmentBinding binding;

    CalendarView calendarView;
    Calendar calendar;
    LinearLayout eventList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat) {

        binding = CalendarFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        calendarView = root.findViewById(R.id.calendarView);
        eventList = root.findViewById(R.id.event_list);

        setCurrentDate();
        setCalendarViewListener();

        return binding.getRoot();

    }

    void setCurrentDate() {
        calendar = Calendar.getInstance();
        calendarView.setDate(calendar.getTimeInMillis());
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
                redrawEvents();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    void redrawEvents() {
        List<EventInfo> eventInfoList = Util.getEventInfo();
        eventList.removeAllViews();
        for (int i = 0; i < eventInfoList.size(); i++) {
            LinearLayout containerEvent = new LinearLayout(getActivity());

            containerEvent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            containerEvent.setOrientation(LinearLayout.HORIZONTAL);
            final float scale = requireContext().getResources().getDisplayMetrics().density;
            int pixels = (int) (5 * scale + 0.5f);
            containerEvent.setPadding(pixels, pixels, pixels, pixels);

            drawEventName(containerEvent, eventInfoList.get(i));
            drawEventJackdaw(containerEvent, eventInfoList.get(i));

            eventList.addView(containerEvent);
        }
    }

    void drawEventName(ViewGroup container, EventInfo eventInfo) {
        TextView eventName = new TextView(getActivity());
        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 1);
        textParams.setMargins(0,0,10,0);
        eventName.setLayoutParams(textParams);
        eventName.setTypeface(typeface);
        eventName.setBackground(ContextCompat.getDrawable(requireActivity(), R.drawable.border_style));
        eventName.setGravity(Gravity.CENTER);
        eventName.setText(eventInfo.name);


        eventName.setOnClickListener(view -> {
            EventFragment eventFragment = new EventFragment(eventInfo);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, eventFragment).commit();
        });

        container.addView(eventName);
    }

    void drawEventJackdaw(ViewGroup container, EventInfo eventInfo) {
        ImageView eventJackdaw = new ImageView(getActivity());
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(Util.getDP(requireContext(), 48), Util.getDP(requireContext(), 48));
        eventJackdaw.setLayoutParams(imageParams);

        drawState(eventJackdaw, eventInfo.isFavorite(), R.drawable.jackdaw_active, R.drawable.jackdaw);

        eventJackdaw.setOnClickListener(view -> {
            drawState(eventJackdaw, eventInfo.changeFavorite(), R.drawable.jackdaw_active, R.drawable.jackdaw);
        });

        container.addView(eventJackdaw);
    }

    void drawState(ImageView view, boolean state, int activeId, int passiveId) {
        int drawableId = (state) ? activeId : passiveId;
        view.setImageDrawable(ContextCompat.getDrawable(requireActivity(), drawableId));
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
