package com.example.gongu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_rent_size#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_rent_size extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private Button ButtontoPay;
    private ImageButton Button_sizeM;
    private ImageButton Button_sizeL;
    private TextView txt_selectedSize;

    public Fragment_rent_size() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_rent_size.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_rent_size newInstance(String param1, String param2) {
        Fragment_rent_size fragment = new Fragment_rent_size();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rent_size, container, false);

        ButtontoPay = (Button) view.findViewById(R.id.button_temp_pay);
        txt_selectedSize = view.findViewById(R.id.txt_selectedSize);
        Button_sizeM = view.findViewById(R.id.Button_sizeM);
        Button_sizeL = view.findViewById(R.id.Button_sizeL);

        Button_sizeM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedSize.setText("M");
            }
        });
        Button_sizeL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_selectedSize.setText("L");
            }
        });
        ButtontoPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), pay.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        return view;
    }


}