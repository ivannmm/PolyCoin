package com.fierysoul.polycoin.app.main.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.databinding.EventFragmentBinding;
import com.fierysoul.polycoin.databinding.ProfileFragmentBinding;
import com.fierysoul.polycoin.util.EventInfo;

import java.util.Calendar;

public class EventFragment extends Fragment {

    EventInfo eventInfo;

    EventFragmentBinding binding;

    TextView eventName, eventDesc, eventLevel, eventDate, eventPlace;

    public EventFragment(EventInfo eventInfo) {
        this.eventInfo = eventInfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat) {

        binding = EventFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        eventName = root.findViewById(R.id.event_name);
        eventName.setText(eventInfo.name);

        eventDesc = root.findViewById(R.id.event_desc);
        eventDesc.setText(eventInfo.description);

        eventLevel = root.findViewById(R.id.event_level);
        eventLevel.setText(eventInfo.level);

        Calendar cal = eventInfo.fullDate;

        @SuppressLint("DefaultLocale") String date = String.format("%d.%d.%d %d:%d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));

        eventDate = root.findViewById(R.id.event_date);
        eventDate.setText(date);

        eventPlace = root.findViewById(R.id.event_place);
        eventPlace.setText(eventInfo.place);
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
