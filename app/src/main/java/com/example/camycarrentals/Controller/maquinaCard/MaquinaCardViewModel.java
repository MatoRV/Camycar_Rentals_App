package com.example.camycarrentals.Controller.maquinaCard;

import java.util.List;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.camycarrentals.Controller.MainController;
import com.example.camycarrentals.Model.Maquina;

public class MaquinaCardViewModel extends ViewModel {
    private MutableLiveData<List<Maquina>> listaMaquina;
    public LiveData<List<Maquina>> getMaquinas() {
        if (listaMaquina == null) {
            listaMaquina = new MutableLiveData<>();
        }
        return listaMaquina;
    }

    public void loadMaquina() {
        MainController.getSingleton().requestMaquinasFromHttp(this);
        listaMaquina.postValue(MainController.getSingleton().getMaquinasRequested());
    }

    public void setData(List<Maquina> list) {
        listaMaquina.postValue(list);
    }
}
