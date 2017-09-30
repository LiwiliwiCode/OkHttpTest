package com.okhttptest.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;
import com.okhttptest.activity.MainActivity;
import com.okhttptest.R;

/**
 * 引导页
 * Created by hhmsw on 2017/9/19.
 */

public class NavigationPicFragment extends Fragment {
    private Context mContext;
    private static String TAG = NavigationPicFragment.class.getSimpleName();
    private Button mbutton;
    private SimpleDraweeView mimageView;

    public static NavigationPicFragment newInstance(String path){
        NavigationPicFragment fragment = new NavigationPicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl",path);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.navigation_pic_fragment,container,false);
        mbutton =  (Button)view.findViewById(R.id.navigation_Enter);
        mimageView = (SimpleDraweeView)view.findViewById(R.id.navigation_imageview);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            String url = bundle.getString("imageUrl");
            Uri uri = Uri.parse(url);
            mimageView.setImageURI(uri);

        }
    }

    public void show() {
        mbutton.setVisibility(View.VISIBLE);
    }
}
