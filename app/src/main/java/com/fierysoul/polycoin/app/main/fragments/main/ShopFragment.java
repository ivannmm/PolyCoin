package com.fierysoul.polycoin.app.main.fragments.main;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.fierysoul.polycoin.R;
import com.fierysoul.polycoin.databinding.ShopFragmentBinding;
import com.fierysoul.polycoin.items.ShopItem;
import com.fierysoul.polycoin.util.Util;

import java.util.List;

public class ShopFragment extends Fragment {

    ShopFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat) {

        binding = ShopFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        List<ShopItem> rating = Util.getShopItemList();
        LinearLayout scrollView = root.findViewById(R.id.rating_container);
        for (int i = 0; i < rating.size(); i += 2) {
            LinearLayout twoItemContainer = new LinearLayout(requireActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            twoItemContainer.setLayoutParams(layoutParams);
            twoItemContainer.setOrientation(LinearLayout.HORIZONTAL);

            twoItemContainer.addView(getItemView(rating.get(i)));
            twoItemContainer.addView(getItemView(rating.get(i + 1)));
            scrollView.addView(twoItemContainer);
        }
        return root;
    }

    public ConstraintLayout getItemView(ShopItem shopItem) {
        ConstraintLayout itemView = new ConstraintLayout(requireActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 10, 10, 10);
        layoutParams.weight = 0.1F;
        itemView.setLayoutParams(layoutParams);
        itemView.setBackground(ContextCompat.getDrawable(requireActivity(), R.drawable.border_style));

        View image = getImageView(shopItem);
        View name = getTextView(shopItem);
        ViewGroup price = getPriceView(shopItem);
        itemView.setId(View.generateViewId());

        itemView.addView(image);
        itemView.addView(name);
        itemView.addView(price);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(itemView);

        constraintSet.connect(image.getId(), ConstraintSet.END, itemView.getId(), ConstraintSet.END,5);
        constraintSet.connect(image.getId(), ConstraintSet.START, itemView.getId(), ConstraintSet.START,5);
        constraintSet.connect(image.getId(), ConstraintSet.BOTTOM, price.getId(), ConstraintSet.TOP, 5);
        constraintSet.connect(image.getId(), ConstraintSet.TOP, name.getId(), ConstraintSet.BOTTOM, 5);

        constraintSet.connect(name.getId(), ConstraintSet.END, itemView.getId(), ConstraintSet.END,0);
        constraintSet.connect(name.getId(), ConstraintSet.START, itemView.getId(), ConstraintSet.START,0);
        constraintSet.connect(name.getId(), ConstraintSet.TOP, itemView.getId(), ConstraintSet.TOP,10);

        constraintSet.connect(price.getId(), ConstraintSet.BOTTOM, itemView.getId(), ConstraintSet.BOTTOM, 10);
        constraintSet.connect(price.getId(), ConstraintSet.END, itemView.getId(), ConstraintSet.END,0);
        constraintSet.connect(price.getId(), ConstraintSet.START, itemView.getId(), ConstraintSet.START,0);

        constraintSet.applyTo(itemView);

        return itemView;

    }

    public View getImageView(ShopItem shopItem) {
        ImageView itemImg = new ImageView(requireActivity());
//        RequestBuilder<Drawable> loadedImg = ShopItem.CACHED_IMAGES.get(shopItem.id);
//
//        if (loadedImg != null)
//            loadedImg.into(itemImg);

        Glide.with(this).load(shopItem.imgUrl).into(itemImg);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(Util.getDP(requireActivity(), 100), Util.getDP(requireActivity(), 100));
        itemImg.setLayoutParams(layoutParams);
        itemImg.setId(View.generateViewId());

        return itemImg;
    }

    public View getTextView(ShopItem shopItem) {
        TextView itemNameView = new TextView(getActivity());
        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        itemNameView.setLayoutParams(textParams);
        itemNameView.setTypeface(typeface);
        itemNameView.setGravity(Gravity.CENTER);
        itemNameView.setTextColor(getResources().getColor(R.color.black, null));
        itemNameView.setText(shopItem.name);
        itemNameView.setId(View.generateViewId());

        return itemNameView;
    }

    @SuppressLint("DefaultLocale")
    public ViewGroup getPriceView (ShopItem shopItem) {
        LinearLayout priceContainer = new LinearLayout(requireActivity());
        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        priceContainer.setOrientation(LinearLayout.HORIZONTAL);
        priceContainer.setLayoutParams(containerParams);

        TextView price = new TextView(getActivity());
        Typeface typeface = ResourcesCompat.getFont(requireActivity(), R.font.velasans_medium);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

        price.setLayoutParams(textParams);
        price.setTypeface(typeface);
        price.setGravity(Gravity.CENTER);
        price.setTextColor(getResources().getColor(R.color.black, null));
        price.setText(String.format("%d", shopItem.price));

        ImageView polycoinImg = new ImageView(requireActivity());
        polycoinImg.setImageResource(R.drawable.logo);
        int imgDP = Util.getDP(requireActivity(), 30);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(imgDP, imgDP);
        imgParams.setMarginStart(8);
        polycoinImg.setLayoutParams(imgParams);

        priceContainer.addView(price);
        priceContainer.addView(polycoinImg);
        priceContainer.setId(View.generateViewId());

        return priceContainer;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
