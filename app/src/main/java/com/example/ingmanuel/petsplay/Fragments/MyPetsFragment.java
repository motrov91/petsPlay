package com.example.ingmanuel.petsplay.Fragments;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ingmanuel.petsplay.Adapters.PetsAdapter;
import com.example.ingmanuel.petsplay.Database.Entity.Pet;
import com.example.ingmanuel.petsplay.Interface.IComFragments;
import com.example.ingmanuel.petsplay.Interface.IComPetDescription;
import com.example.ingmanuel.petsplay.R;
import com.example.ingmanuel.petsplay.ViewModel.PetsViewModel;

import java.util.List;

public class MyPetsFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    FloatingActionButton fab;
    RecyclerView recyclerView;
    PetsAdapter adapter;

    Activity activity;
    IComFragments iComFragments;
    IComPetDescription iComPetDescription;

    private PetsViewModel pViewModel;

    public MyPetsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MyPetsFragment newInstance(String param1, String param2) {
        MyPetsFragment fragment = new MyPetsFragment();
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
        View v = inflater.inflate(R.layout.fragment_my_pets, container, false);
        recyclerView = v.findViewById(R.id.idRecycler);
        fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        configRecycler();

        return v;
    }

    private void configRecycler() {
        adapter = new PetsAdapter(getContext());
        adapter.setOnItemClickListener(new PetsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pet pet) {
                pet.setIdPet(pet.getIdPet());
                pet.setNamePet(pet.getNamePet());
                pet.setBreedPet(pet.getBreedPet());
                pet.setAgePet(pet.getAgePet());
                pet.setKindOfPet(pet.getKindOfPet());
                pet.setLastControl("11/01/18");

                iComPetDescription.sendDescriptionPet(pet);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        pViewModel = ViewModelProviders.of(getActivity()).get(PetsViewModel.class);

        pViewModel.getAllPets().observe(getActivity(), new Observer<List<Pet>>() {
            @Override
            public void onChanged(@Nullable List<Pet> pets) {
                adapter.setData(pets);
            }
        });
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

        if (context instanceof Activity){
            this.activity = (Activity) context;
            iComFragments = (IComFragments) this.activity;
        }

        if (context instanceof Activity){
            this.activity = (Activity) context;
            iComPetDescription = (IComPetDescription) this.activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                iComFragments.send();
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
