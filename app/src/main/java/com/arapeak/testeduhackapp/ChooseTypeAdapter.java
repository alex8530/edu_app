package com.arapeak.testeduhackapp;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arapeak.model.ChooseTypeAccount;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


public class ChooseTypeAdapter extends RecyclerView.Adapter<ChooseTypeAdapter.CategoryViewHolder> {

    public static final String TAG = "CategoriesAdapter";

    private Context mContext;
    private List<ChooseTypeAccount> arrayListItem;
    private LayoutInflater layoutInflater;
    private AdapterCallback mCallback;
    private RecyclerView recyclerView;
    private int positionSelected;

    public ChooseTypeAdapter(Context mContext
            , List<ChooseTypeAccount> arrayListItem
            , AdapterCallback mCallback) {
        this.mContext = mContext;
        this.arrayListItem = arrayListItem;
        this.mCallback = mCallback;
        positionSelected = -1;

        layoutInflater = LayoutInflater.from(this.mContext);
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View view = layoutInflater.inflate(R.layout.item_choose_type_account_layout, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return arrayListItem.size();
    }



    public void clear() {
        arrayListItem.clear();
        notifyDataSetChanged();
    }

    public ChooseTypeAccount getItem(int position) {
        if (position < 0 || position >= getItemCount()) {
            return null;
        }
        return arrayListItem.get(position);
    }


    public int getPositionSelected() {
        return positionSelected;
    }

    public void setPositionSelected(int positionSelected) {
        this.positionSelected = positionSelected;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout categoryLinearLayout;
        private TextView tv_title;
        private ImageView img;
        private ImageView img_check;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryLinearLayout = itemView.findViewById(R.id.constraintLayout);
            tv_title = itemView.findViewById(R.id.tv_title);
            img = itemView.findViewById(R.id.img);
            img_check = itemView.findViewById(R.id.img_check);

        }

        public void onBind(final int position) {
            ChooseTypeAccount category = arrayListItem.get(position);
            if (category == null) {
                return;
            }

            tv_title.setText(category.getTitle());
            Picasso.get().load(category.getRes()).into(img);
            if (positionSelected == position) {
                img_check.setVisibility(View.VISIBLE);
                categoryLinearLayout.setBackground(ContextCompat.getDrawable(mContext, R.drawable.shape_with_strok_blue_with_corner_10));
            } else {
                img_check.setVisibility(View.GONE);

                categoryLinearLayout.setBackground(ContextCompat.getDrawable(mContext, R.drawable.shape_with_corner_10));
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tempPistionSelected = positionSelected;
                    positionSelected = position;
                    notifyItemChanged(positionSelected);
                    notifyItemChanged(tempPistionSelected);
//                    notifyDataSetChanged();



                    if (mCallback != null) {
                        mCallback.onItemClick(position, TAG);
                    }
                }
            });
        }
    }
}