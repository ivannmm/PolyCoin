package com.fierysoul.polycoin.app.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.databinding.RatingFragmentBinding;

import java.util.Objects;

public class RatingFragment extends Fragment {

    RatingFragmentBinding binding;

    TextView filter;

    final int REMOVE_FILTER = 0, INST_FILTER = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat) {

        binding = RatingFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        filter = root.findViewById(R.id.filter);
        filter.setOnClickListener(viewClickListener);

        return root;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };

    @SuppressLint("NonConstantResourceId")
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        popupMenu.inflate(R.menu.filter_menu);

        popupMenu
                .setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.remove:
                            Toast.makeText(getActivity(),
                                    "Вы сбросили все фильтры",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.inst:
                            Toast.makeText(getActivity(),
                                    "Вы выбрали фильтр по институтам",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            return false;
                    }
                });

        popupMenu.setOnDismissListener(menu -> Toast.makeText(getActivity(), "onDismiss",
                Toast.LENGTH_SHORT).show());
        popupMenu.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
