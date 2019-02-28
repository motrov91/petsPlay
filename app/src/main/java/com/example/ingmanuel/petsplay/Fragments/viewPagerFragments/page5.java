package com.example.ingmanuel.petsplay.Fragments.viewPagerFragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ingmanuel.petsplay.Fragments.CreateNewUser;
import com.example.ingmanuel.petsplay.Interface.IComCreateUser;
import com.example.ingmanuel.petsplay.Interface.IComPetDescription;
import com.example.ingmanuel.petsplay.R;


public class page5 extends Fragment implements View.OnClickListener {

    Button btnInto, btnCreateUser;

    private page5.OnFragmentInteractionListener mListener;

    private Activity activity;
    private IComCreateUser iComCreateUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page5, container, false);

        btnInto = v.findViewById(R.id.btnInto);
        btnCreateUser = v.findViewById(R.id.btnCreateUser);

        btnInto.setOnClickListener(this);
        btnCreateUser.setOnClickListener(this);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof page5.OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        if (context instanceof Activity){
            this.activity = (Activity) context;
            iComCreateUser = (IComCreateUser) this.activity;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnInto:
                break;
            case R.id.btnCreateUser:
                iComCreateUser.sendCreateUser();
                break;
        }
    }
}
