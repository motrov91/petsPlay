package com.example.ingmanuel.petsplay.Fragments;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ingmanuel.petsplay.Database.DataBase.AppDB;
import com.example.ingmanuel.petsplay.Database.Entity.Pet;
import com.example.ingmanuel.petsplay.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreateNewPet.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreateNewPet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateNewPet extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ImageView imgPet;
    EditText etNamPet, etBreed, etAge, kindOfPet, kindOfBreed;
    Button btnCreate;

    private Pet pet;



    CreatePetAsyncTask createPetAsyncTask;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CreateNewPet() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CreateNewPet newInstance(String param1, String param2) {
        CreateNewPet fragment = new CreateNewPet();
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
        View v = inflater.inflate(R.layout.fragment_create_new_pet, container, false);

        imgPet = v.findViewById(R.id.imagePet);
        etNamPet = v.findViewById(R.id.petName);
        kindOfPet = v.findViewById(R.id.kindOfPetCreate);
        etBreed = v.findViewById(R.id.petBreed);
        etAge = v.findViewById(R.id.petAge);


        btnCreate = v.findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(this);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
            case R.id.btnCreate:
                pet = new Pet();
                pet.setNamePet(etNamPet.getText().toString());
                pet.setKindOfPet(kindOfPet.getText().toString());
                pet.setBreedPet(etBreed.getText().toString());
                pet.setAgePet(etAge.getText().toString());

                createPetAsyncTask = new CreatePetAsyncTask();
                createPetAsyncTask.execute(pet);

                Log.d("ALMACENADO", "Se guardaron los datos");
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class CreatePetAsyncTask extends AsyncTask<Pet, Void, Void>{

        @Override
        protected Void doInBackground(Pet... pets) {
            AppDB.getAppDB(getActivity().getApplicationContext()).petDAO().insertPet(pets[0]);
            return null;
        }
    }
}
