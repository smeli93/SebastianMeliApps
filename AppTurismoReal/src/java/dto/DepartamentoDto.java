package dto;

public class DepartamentoDto {

    private int id_depto;
    private String numero_depto;
    private String direccion;
    private int piso;
    private int valor;
    private int cant_personas;
    private int cant_banos;
    private int cant_habitaciones;
    private boolean cocina;
    private boolean estacionamiento;
    private boolean tv_cable;
    private boolean internet;
    private boolean calefaccion;
    private boolean accesible;
    private boolean estado;
    private ComunaDto comuna_depto;

    public DepartamentoDto() {
    }

    public DepartamentoDto(int id_depto, String numero_depto, String direccion, int piso, int valor, int cant_personas, int cant_banos, int cant_habitaciones, boolean cocina, boolean estacionamiento, boolean tv_cable, boolean internet, boolean calefaccion, boolean accesible, boolean estado) {
        this.id_depto = id_depto;
        this.numero_depto = numero_depto;
        this.direccion = direccion;
        this.piso = piso;
        this.valor = valor;
        this.cant_personas = cant_personas;
        this.cant_banos = cant_banos;
        this.cant_habitaciones = cant_habitaciones;
        this.cocina = cocina;
        this.estacionamiento = estacionamiento;
        this.tv_cable = tv_cable;
        this.internet = internet;
        this.calefaccion = calefaccion;
        this.accesible = accesible;
        this.estado = estado;
        this.comuna_depto = new ComunaDto();
    }

    public int getId_depto() {
        return id_depto;
    }

    public void setId_depto(int id_depto) {
        this.id_depto = id_depto;
    }

    public String getNumero_depto() {
        return numero_depto;
    }

    public void setNumero_depto(String numero_depto) {
        this.numero_depto = numero_depto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public int getCant_banos() {
        return cant_banos;
    }

    public void setCant_banos(int cant_banos) {
        this.cant_banos = cant_banos;
    }

    public int getCant_habitaciones() {
        return cant_habitaciones;
    }

    public void setCant_habitaciones(int cant_habitaciones) {
        this.cant_habitaciones = cant_habitaciones;
    }

    public boolean isCocina() {
        return cocina;
    }

    public void setCocina(boolean cocina) {
        this.cocina = cocina;
    }

    public boolean isEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(boolean estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    public boolean isTv_cable() {
        return tv_cable;
    }

    public void setTv_cable(boolean tv_cable) {
        this.tv_cable = tv_cable;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    public boolean isAccesible() {
        return accesible;
    }

    public void setAccesible(boolean accesible) {
        this.accesible = accesible;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ComunaDto getComuna_depto() {
        return comuna_depto;
    }

    public void setComuna_depto(ComunaDto comuna_depto) {
        this.comuna_depto = comuna_depto;
    }

    @Override
    public String toString() {
        return "DepartamentoDto{" + "id_depto=" + id_depto + ", numero_depto=" + numero_depto + ", direccion=" + direccion + ", piso=" + piso + ", valor=" + valor + ", cant_personas=" + cant_personas + ", cant_banos=" + cant_banos + ", cant_habitaciones=" + cant_habitaciones + ", cocina=" + cocina + ", estacionamiento=" + estacionamiento + ", tv_cable=" + tv_cable + ", internet=" + internet + ", calefaccion=" + calefaccion + ", accesible=" + accesible + ", estado=" + estado + ", comuna_depto=" + comuna_depto + '}';
    }

}
