package com.ankita.navigationdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;


public class NavigationSecondFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_navigation_second, container, false);

        Log.e("!_@_", NavigationSecondFragmentArgs.fromBundle(getArguments()).getMyStrVal()+" === ");
        Log.e("!_@_", NavigationSecondFragmentArgs.fromBundle(getArguments()).getMyIntValA()+" === ");


//        Toast.makeText(getActivity(), "Bundle args " + getArguments().getBoolean("test_boolean"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getActivity(), "Bundle args " + NavigationFirstFragmentArgs.fromBundle(getArguments()).getTestString(), Toast.LENGTH_SHORT).show();


        Button button = view.findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
                navController.navigateUp();

                navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {
                    @Override
                    public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
                        Log.d("TAG", destination.getLabel() + " ");
                    }
                });
            }
        });
        return view;
    }


}
