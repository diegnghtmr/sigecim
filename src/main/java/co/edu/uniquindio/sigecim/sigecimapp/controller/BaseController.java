package co.edu.uniquindio.sigecim.sigecimapp.controller;

import co.edu.uniquindio.sigecim.sigecimapp.utils.ModelFactory;

public abstract class BaseController {
    ModelFactory modelFactory;

    public BaseController() {
        modelFactory = ModelFactory.getInstance();
    }
}