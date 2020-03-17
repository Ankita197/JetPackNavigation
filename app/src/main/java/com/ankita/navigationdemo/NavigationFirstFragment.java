package com.ankita.navigationdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class NavigationFirstFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_first, container, false);
        final Bundle bundle = new Bundle();
        bundle.putBoolean("test_boolean", true);

        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);


        Button button = view.findViewById(R.id.btnGoToSecond);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(
                        NavigationFirstFragmentDirections.actionFirstFragmentToSecondFragment()
                                .setMyStrVal("asdasd")
                                .setMyIntValA(5)
                );
//                navController.navigate(R.id.action_firstFragment_to_secondFragment, bundle);
            }
        });
        return view;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        View.OnClickListener s = Navigation.createNavigateOnClickListener(R.id.action_firstFragment_to_secondFragment);
//        Button button = view.findViewById(R.id.btnGoToSecond);
//        button.setOnClickListener(s);
//    }
}
