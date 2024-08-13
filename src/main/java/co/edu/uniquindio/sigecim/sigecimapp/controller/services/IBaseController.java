package co.edu.uniquindio.sigecim.sigecimapp.controller.services;

public interface IBaseController<T> {
    boolean agregar(T object);
    boolean eliminar(String id);
    boolean actualizar(String id, T object);
}
