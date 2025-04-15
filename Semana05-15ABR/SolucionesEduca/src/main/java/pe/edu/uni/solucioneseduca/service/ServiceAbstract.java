package pe.edu.uni.solucioneseduca.service;

public abstract class ServiceAbstract {

    private boolean estado;
    private String mensaje;

    public ServiceAbstract() {
        this(false, "Error en el proceso");
    }

    public ServiceAbstract(boolean estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
