//package com.coke.sample.activities;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * to handle interaction events.
// * Use the {@link ProgressFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class ProgressFragment extends CokeProgressFragment {
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    private String mParam1;
//    private String mParam2;
//
//    private View mContentView;
//    private Handler mHandler;
//    private Runnable mShowContentRunnable = new Runnable() {
//
//        @Override
//        public void run() {
//
////            setContentShown(true);
//            setContentEmpty(ProgressFragment.this);
//        }
//
//    };
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CokeProgressFragment.
//     */
//    public static ProgressFragment newInstance(String param1, String param2) {
//        ProgressFragment fragment = new ProgressFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    public ProgressFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        // Inflate the layout for this fragment
//        mContentView = inflater.inflate(R.layout.fragment_progress, container, false);
//
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        // Setup content view
//        setContentView(mContentView);
//        // Setup text for empty content
////        setEmptyText(R.string.empty);
//        obtainData();
//    }
//
//    private void obtainData() {
//        // Show indeterminate progress
//        setContentShown(false);
//
//        mHandler = new Handler();
//        mHandler.postDelayed(mShowContentRunnable, 1000);
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        mHandler.removeCallbacks(mShowContentRunnable);
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }
//
//
//}
