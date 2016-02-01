package com.example.kwame.testing;

import java.io.Serializable;

/**
 * Created by kwame on 10/7/15.
 */
public class Data implements Serializable {

    private Afrique afrique;

    public Data(){};



    public Afrique getOfficial() {
        return afrique;
    }

    public void setOfficial(Afrique afrique) {
        this.afrique = afrique;
    }

}
