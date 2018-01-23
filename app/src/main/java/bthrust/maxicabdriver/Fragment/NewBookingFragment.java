package bthrust.maxicabdriver.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bthrust.maxicabdriver.Adapter.newBookingAdapter;
import bthrust.maxicabdriver.Bean.ModelClass;
import bthrust.maxicabdriver.R;


public class NewBookingFragment extends Fragment {

    private String arraypaymode[] = {"55.00","25.12" , "35.22" , "45.33" , "78.00"};
    private newBookingAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_booking, container, false);

        RecyclerView newBooking_RecyclerView = (RecyclerView) view.findViewById(R.id.newBooking_RecyclerView);
        newBooking_RecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity() ,1);
        newBooking_RecyclerView.setLayoutManager(layoutManager);

        List<ModelClass> items = loadData();
        adapter = new newBookingAdapter(getActivity() ,items);
        newBooking_RecyclerView.setAdapter(adapter);

        return view;
    }

    private List<ModelClass> loadData() {

        List<ModelClass> list = new ArrayList<ModelClass>();
        for(int i = 0 ; i < arraypaymode.length; i++){
            ModelClass modelClass = new ModelClass();
            modelClass.setPaymentMod(arraypaymode[i]);
            list.add(modelClass);
        }

        return list;
    }


}
