package com.example.camycarrentals.Controller;

import java.util.ArrayList;
import java.util.List;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardViewModel;
import com.example.camycarrentals.Controller.peticionGET.maquina.PeticionMaquinas;
import com.example.camycarrentals.Controller.respuestas.RespuestaMaquinas;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.Util.Conexion;
import com.example.camycarrentals.View.MainActivity;

public class MainController {

    private static MainController mySingleController;

    private List<Maquina> maquinasRequested;
    private MaquinaCardViewModel maquinaCardViewModel;

    private static MainActivity activeActivity;

    private MainController() {
        maquinasRequested = new ArrayList<>();
    }

    public static MainController getSingleton() {
        if (MainController.mySingleController == null) {
            mySingleController = new MainController();
        }
        return mySingleController;
    }

    public void setupViewModel(MaquinaCardViewModel maquinaCardViewModel) {
        this.maquinaCardViewModel = maquinaCardViewModel;
    }

    public MaquinaCardViewModel getMaquinaCardViewModel() {
        return maquinaCardViewModel;
    }

    public List<Maquina> getMaquinasRequested() {
        return this.maquinasRequested;
    }

    public void requestMaquinasFromHttp(MaquinaCardViewModel maquinaCardViewModel, String filtro) {
        PeticionMaquinas p = new PeticionMaquinas();
        p.requestMaquinas(Conexion.URL);
        this.maquinaCardViewModel = maquinaCardViewModel;
    }

    public void setMaquinasFromHttp(String json) {
        RespuestaMaquinas r = new RespuestaMaquinas(json);
        maquinasRequested = r.getMaquinas();
        maquinaCardViewModel.setData(maquinasRequested);
    }

    public void setErrorFromHttp(String error) {

    }

    public static void setActivity(MainActivity myAct) {
        activeActivity = myAct;
    }
}
