package co.edu.uniquindio.sigecim.sigecimapp.controller;

public abstract class BaseController {
    ModelFactory modelFactory;

    public BaseController() {
        modelFactory = ModelFactory.getInstance();
    }
}