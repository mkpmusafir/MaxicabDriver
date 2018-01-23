package bthrust.maxicabdriver.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import bthrust.maxicabdriver.Bean.ModelClass;
import bthrust.maxicabdriver.R;

/**
 * Created by win-3 on 1/23/2018.
 */

public class newBookingAdapter extends RecyclerView.Adapter<newBookingAdapter.ViewHolder> {
    private Context context;
    private List<ModelClass> items;
    ModelClass modelClass;
    public newBookingAdapter(Context context, List<ModelClass> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public newBookingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newbooking_list_items , parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(newBookingAdapter.ViewHolder holder, int position) {
        modelClass = items.get(position);
        holder.paymentMod.setText(items.get(position).getPaymentMod());
        holder.itemView.setTag(modelClass);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView paymentMod;
        public TextView remarks_BTN;
        public ViewHolder(final View itemView) {
            super(itemView);

            paymentMod = itemView.findViewById(R.id.paymentMod);
            remarks_BTN = itemView.findViewById(R.id.remarks_BTN);

            remarks_BTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = itemView.getContext();

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.remark_layout);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setCancelable(false);
                    EditText driverRemark_Edit = (EditText) dialog.findViewById(R.id.driverRemark_Edit);
                    TextView close_BTN = (TextView) dialog.findViewById(R.id.close_BTN);
                    close_BTN.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            });


        }
    }
}
