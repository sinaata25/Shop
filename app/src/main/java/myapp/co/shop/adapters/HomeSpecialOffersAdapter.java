package myapp.co.shop.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import myapp.co.shop.R;
import myapp.co.shop.model.ModelSpecialOfferHome;
import myapp.co.shop.model.Model_Categories;

public class HomeSpecialOffersAdapter extends RecyclerView.Adapter<HomeSpecialOffersAdapter.viewholder> {

        Context context;
        List<ModelSpecialOfferHome> list;
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_product_special_home,parent,false);
        return new viewholder(view);
    }

    public HomeSpecialOffersAdapter(Context context, List<ModelSpecialOfferHome>list){
        this.list=list;
        this.context=context;

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        ModelSpecialOfferHome modelSpecialOfferHome=list.get(position);
        holder.textViewNewPrice.setText(modelSpecialOfferHome.getCurrentPrice());
        holder.textViewOldPrice.setText(modelSpecialOfferHome.getLastPrice());
        holder.textViewName.setText(modelSpecialOfferHome.getName());
        holder.textViewOldPrice.setPaintFlags(holder.textViewOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Picasso.get()
                .load(modelSpecialOfferHome.getImage())
                //.resize(50, 50)
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView textViewOldPrice;
        TextView textViewNewPrice;
        ImageView imageView;
        TextView textViewName;
        CardView cardView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            textViewNewPrice=itemView.findViewById(R.id.textview_new_price_special);
            textViewOldPrice=itemView.findViewById(R.id.textview_old_price_special);
            textViewName=itemView.findViewById(R.id.textview_name_product_special);
            imageView=itemView.findViewById(R.id.imageview_categories_item_special);
            cardView=itemView.findViewById(R.id.card_special_home);

        }
    }



}
