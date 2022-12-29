package com.fierysoul.polycoin.app.main.fragments;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import com.fierysoul.polycoin.util.enums.DirectionEnum;
import com.fierysoul.polycoin.util.enums.InstEnum;
import com.fierysoul.polycoin.util.enums.ScopeEnum;

public class FilterFragment extends Fragment {

    FilterSettings filterSettings;

    FilterFragmentBinding binding;

    LinearLayout instContainer, scopeContainer, directionContainer;

    View activeInst, activeCourse, activeScope, activeDirection;

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

        directionContainer = root.findViewById(R.id.direction_container);
        drawDirection(directionContainer);


        return root;
    }

    public void drawInst(ViewGroup container) {
        for (InstEnum inst : InstEnum.values()) {
            View view = addDefaultViewToContainer(container, inst.translate);
            view.setOnClickListener(v -> {
                filterSettings.setInst(inst);

                changeBorderStyle(activeInst, false);
                activeInst = view;
                changeBorderStyle(activeInst, true);

                redrawDirection(directionContainer, inst);
            });
        }
    }

    public void drawScope(ViewGroup container) {
        for (ScopeEnum scope : ScopeEnum.values()) {
            View view = addDefaultViewToContainer(container, scope.translate);
            view.setOnClickListener(v -> {
                filterSettings.setScope(scope);

                changeBorderStyle(activeScope, false);
                activeScope = view;
                changeBorderStyle(activeScope, true);
            });
        }
    }

    public void drawDirection(ViewGroup container) {
        drawDirection(container, null);
    }

    public void redrawDirection(ViewGroup container, InstEnum inst) {
        container.removeAllViews();
        drawDirection(container, inst);
    }

    public void drawDirection(ViewGroup container, InstEnum inst) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Util.getDP(requireActivity(), 35));
        for (DirectionEnum direction : DirectionEnum.values()) {

            if (inst != null && (inst != InstEnum.ALL && inst != direction.inst))
                continue;

            String dirTranslate = direction.translate;
            if (direction.translate.length() > 30) {
                dirTranslate  = String.format("%s...", direction.translate.substring(0,30));
            }
            View view = addDefaultViewToContainer(container, dirTranslate, layoutParams);
            view.setOnClickListener(v -> {
                filterSettings.setDirection(direction);

                changeBorderStyle(activeDirection, false);
                activeDirection = view;
                changeBorderStyle(activeDirection, true);
            });
        }
    }

    public View addDefaultViewToContainer (ViewGroup container, String text, LinearLayout.LayoutParams layoutParams) {
        TextView view = new TextView(getActivity());

        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        LinearLayout.LayoutParams textParams = layoutParams;

        if (layoutParams == null) {
            textParams = new LinearLayout.LayoutParams(Util.getDP(requireActivity(), 90), Util.getDP(requireActivity(), 35));
        }

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

    public View addDefaultViewToContainer (ViewGroup container, String text) {
        return addDefaultViewToContainer(container, text, null);
    }

    public void changeBorderStyle(View view, boolean toActive) {
        if (view != null) {
            Drawable borderStyle = (toActive) ? ContextCompat.getDrawable(requireActivity(), R.drawable.border_style2) : ContextCompat.getDrawable(requireActivity(), R.drawable.border_style);
            view.setBackground(borderStyle);
        }
    }

}
