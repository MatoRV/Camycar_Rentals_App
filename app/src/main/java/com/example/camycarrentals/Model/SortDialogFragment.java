package com.example.camycarrentals.Model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.camycarrentals.R;

public class SortDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle sabedInstanceState) {
        super.onCreateView(inflater,container,sabedInstanceState);
        return inflater.inflate(R.layout.sort_fragment,container,false);
    }
}
