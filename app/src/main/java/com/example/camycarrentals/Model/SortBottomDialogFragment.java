package com.example.camycarrentals.Model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.example.camycarrentals.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SortBottomDialogFragment extends BottomSheetDialogFragment {

    private static SortBottomDialogFragment mSortBottomDialogFragment;

    private SortBottomDialogFragment() {

    }

    public static SortBottomDialogFragment getmSortBottomDialogFragment() {
        if (SortBottomDialogFragment.mSortBottomDialogFragment == null) {
            mSortBottomDialogFragment = new SortBottomDialogFragment();
        }
        return mSortBottomDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sort_fragment, container, false);
    }
}
