package com.example.ingmanuel.petsplay.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ingmanuel.petsplay.Database.Entity.Pet;
import com.example.ingmanuel.petsplay.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfilePet.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfilePet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilePet extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView namePetProfile, ageProfilePet, ownerPet, kindofPet, lastControl, breedPet;

    public ProfilePet() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProfilePet newInstance(String param1, String param2) {
        ProfilePet fragment = new ProfilePet();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_pet, container, false);

        namePetProfile = v.findViewById(R.id.NamePetProfile);
        ageProfilePet = v.findViewById(R.id.AgeProfilePet);
        breedPet = v.findViewById(R.id.breedPetProfile);
        kindofPet = v.findViewById(R.id.kindOfPetProfile);
        ownerPet = v.findViewById(R.id.NameOwnerProfile);
        lastControl = v.findViewById(R.id.lastControlProfile);


        configView();

        return v;
    }

    private void configView() {
        Bundle objetoPet = getArguments();
        Pet petProfile = null;

        if (objetoPet != null){
            petProfile = (Pet) objetoPet.getSerializable("Object");
            namePetProfile.setText(petProfile.getNamePet());
            breedPet.setText(petProfile.getBreedPet());
            ageProfilePet.setText(petProfile.getAgePet());
            kindofPet.setText(petProfile.getKindOfPet());
            lastControl.setText(petProfile.getLastControl());

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
