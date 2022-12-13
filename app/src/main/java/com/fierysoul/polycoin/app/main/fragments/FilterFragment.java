package com.fierysoul.polycoin.app.main.fragments;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.app.main.settings.FilterSettings;
import com.fierysoul.polycoin.databinding.FilterFragmentBinding;
import com.fierysoul.polycoin.util.Util;
import com.fierysoul.polycoin.util.enums.InstEnum;
import com.fierysoul.polycoin.util.enums.ScopeEnum;

public class FilterFragment extends Fragment {

    FilterSettings filterSettings;

    FilterFragmentBinding binding;

    LinearLayout instContainer, scopeContainer;

    public FilterFragment(FilterSettings filterSettings) {
        this.filterSettings = filterSettings;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat) {

        binding = FilterFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        instContainer = root.findViewById(R.id.inst_container);
        drawInst(instContainer);

        scopeContainer = root.findViewById(R.id.scope_container);
        drawScope(scopeContainer);


        return root;
    }

    public void drawInst(ViewGroup container) {
        for (InstEnum inst : InstEnum.values()) {
            View view = addDefaultViewToContainer(container, inst.translate);
            view.setOnClickListener(v -> filterSettings.setInst(inst));
        }
    }

    public void drawScope(ViewGroup container) {
        for (ScopeEnum scope : ScopeEnum.values()) {
            View view = addDefaultViewToContainer(container, scope.translate);
            view.setOnClickListener(v -> filterSettings.setScope(scope));
        }
    }

    public View addDefaultViewToContainer (ViewGroup container, String text) {
        TextView view = new TextView(getActivity());

        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(Util.getDP(requireActivity(), 90), Util.getDP(requireActivity(), 35));
        textParams.setMargins(10,5,10,5);
        int padding = Util.getDP(requireActivity(), 5);
        view.setPadding(padding, padding, padding, padding);

        view.setLayoutParams(textParams);
        view.setTypeface(typeface);
        view.setTextSize(14);
        view.setTextColor(getResources().getColor(R.color.black, null));
        view.setBackground(ContextCompat.getDrawable(requireActivity(), R.drawable.border_style));
        view.setGravity(Gravity.CENTER);
        view.setText(text);

        container.addView(view);
        return view;
    }

}
