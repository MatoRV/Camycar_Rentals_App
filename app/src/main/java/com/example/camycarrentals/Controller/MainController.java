package com.example.camycarrentals.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardViewModel;
import com.example.camycarrentals.Controller.peticionGET.PeticionMaquinas;
import com.example.camycarrentals.Controller.respuestas.RespuestaMaquinas;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.View.MainActivity;

public class MainController {

    private static final String URL = "http://192.168.1.112:8080/";

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

    public List<Maquina> getMaquinasRequested() {
        return this.maquinasRequested;
    }

    public void requestMaquinasFromHttp(MaquinaCardViewModel maquinaCardViewModel) {
        PeticionMaquinas p = new PeticionMaquinas();
        p.requestMaquinas(URL);
        this.maquinaCardViewModel = maquinaCardViewModel;
    }

    public void setMaquinasFromHttp(String json) {
        RespuestaMaquinas r = new RespuestaMaquinas(json);
        maquinasRequested = r.getMaquinas();
        maquinaCardViewModel.loadMaquina();
    }

    public void setErrorFromHttp(String error) {

    }

    public static void setActivity(MainActivity myAct) {
        activeActivity = myAct;
    }
}
