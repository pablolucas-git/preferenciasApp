package com.deneb.apppreferencias;

public class Pregunta {
    private int tv_enunciado;
    private int btn_opcion1;
    private int btn_opcion2;
    private int iv_imagen;

    public Pregunta(int tv_enunciado, int btn_opcion1, int btn_opcion2, int iv_imagen) {
        this.tv_enunciado = tv_enunciado;
        this.btn_opcion1 = btn_opcion1;
        this.btn_opcion2 = btn_opcion2;
        this.iv_imagen = iv_imagen;
    }

    public int getTv_enunciado() {
        return tv_enunciado;
    }

    public void setTv_enunciado(int tv_enunciado) {
        this.tv_enunciado = tv_enunciado;
    }

    public int getBtn_opcion1() {
        return btn_opcion1;
    }

    public void setBtn_opcion1(int btn_opcion1) {
        this.btn_opcion1 = btn_opcion1;
    }

    public int getBtn_opcion2() {
        return btn_opcion2;
    }

    public void setBtn_opcion2(int btn_opcion2) {
        this.btn_opcion2 = btn_opcion2;
    }

    public int getIv_imagen() {
        return iv_imagen;
    }

    public void setIv_imagen(int iv_imagen) {
        this.iv_imagen = iv_imagen;
    }
}
