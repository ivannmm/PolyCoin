package com.fierysoul.polycoin.app.main.fragments.main;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.app.main.fragments.additional.FilterFragment;
import com.fierysoul.polycoin.app.main.settings.FilterSettings;
import com.fierysoul.polycoin.databinding.RatingFragmentBinding;
import com.fierysoul.polycoin.items.RatingUserItem;
import com.fierysoul.polycoin.util.Util;

import java.util.List;

public class RatingFragment extends Fragment {

    RatingFragmentBinding binding;

    TextView filter;
    LinearLayout ratingList;
    float scale;

    FilterSettings filterSettings;

    final int REMOVE_FILTER = 0, INST_FILTER = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat) {

        binding = RatingFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        filter = root.findViewById(R.id.filter);

        filterSettings = new FilterSettings();
        filter.setOnClickListener(view -> requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FilterFragment(filterSettings)).commit());

        ratingList = root.findViewById(R.id.rating_container);
        scale = requireContext().getResources().getDisplayMetrics().density;

        List<RatingUserItem> rating = Util.getRatingUserInfo();


        for (int i = 0; i < rating.size(); i++) {
            drawTop(ratingList, rating.get(i), i + 1);
        }

        EditText searchField = root.findViewById(R.id.editTextTextPersonName2);

        searchField.setOnKeyListener((view, keyCode, keyEvent) -> {
            if(keyEvent.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                String search = searchField.getText().toString();

                ratingList.removeAllViews();

                for (int i = 0; i < rating.size(); i++) {
                    if (rating.get(i).getName().toLowerCase().contains(search.toLowerCase()))
                        drawTop(ratingList, rating.get(i), i + 1);
                }
            }
            return false;
        });

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

//    View.OnClickListener viewClickListener = this::showPopupMenu;
//
//    @SuppressLint("NonConstantResourceId")
//    private void showPopupMenu(View v) {
//        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
//        popupMenu.inflate(R.menu.filter_menu);
//
//        popupMenu.setOnMenuItemClickListener(item -> {
//                    switch (item.getItemId()) {
//                        case R.id.remove:
//                            Toast.makeText(getActivity(),
//                                    "Вы сбросили все фильтры",
//                                    Toast.LENGTH_SHORT).show();
//                            return true;
//                        case R.id.inst:
//                            Toast.makeText(getActivity(),
//                                    "Вы выбрали фильтр по институтам",
//                                    Toast.LENGTH_SHORT).show();
//                            return true;
//                        default:
//                            return false;
//                    }
//                });
//
//        popupMenu.setOnDismissListener(menu -> Toast.makeText(getActivity(), "onDismiss",
//                Toast.LENGTH_SHORT).show());
//        popupMenu.show();
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void drawTop(ViewGroup container, RatingUserItem userInfo, int position) {

        LinearLayout userLayout = new LinearLayout(getActivity());

        int userLayoutHeight = (int) (40 * scale + 0.5f);

        userLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, userLayoutHeight));
        userLayout.setOrientation(LinearLayout.HORIZONTAL);

        int padding = (int) (5 * scale + 0.5f);

        userLayout.setPadding(padding, padding, padding, padding);

        drawPosition(userLayout, position);
        drawName(userLayout, userInfo.getName());
        drawPoints(userLayout, userInfo.getPoints());

        container.addView(userLayout);
    }

    @SuppressLint("DefaultLocale")
    public void drawPosition(ViewGroup container, int position) {
        TextView posView = new TextView(getActivity());
        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 2);
        textParams.setMargins(0,0,10,0);

        posView.setLayoutParams(textParams);
        posView.setTypeface(typeface);
        posView.setGravity(Gravity.CENTER);
        posView.setTextColor(getResources().getColor(R.color.black, null));
        posView.setText(String.format("%d.", position));

        container.addView(posView);
    }

    @SuppressLint("ResourceAsColor")
    public void drawName(ViewGroup container, String name) {
        TextView nameView = new TextView(getActivity());
        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 10);
        textParams.setMargins(0,0,10,0);

        nameView.setLayoutParams(textParams);
        nameView.setTypeface(typeface);
        nameView.setTextSize(18);
        nameView.setTextColor(getResources().getColor(R.color.black, null));
        nameView.setBackground(ContextCompat.getDrawable(requireActivity(), R.drawable.border_style));
        nameView.setGravity(Gravity.CENTER);
        nameView.setText(name);

        container.addView(nameView);
    }

    @SuppressLint({"ResourceAsColor", "DefaultLocale"})
    public void drawPoints(ViewGroup container, int points) {
        TextView pointsView = new TextView(getActivity());
        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 3);
        textParams.setMargins(0,0,10,0);


        pointsView.setLayoutParams(textParams);
        pointsView.setTypeface(typeface);
        pointsView.setTextSize(18);
        pointsView.setTextColor(getResources().getColor(R.color.black, null));
        pointsView.setBackground(ContextCompat.getDrawable(requireActivity(), R.drawable.border_style));
        pointsView.setGravity(Gravity.CENTER);
        pointsView.setText(String.format("%d",points));

        container.addView(pointsView);
    }
}
