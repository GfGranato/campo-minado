package br.com.cod3r.cm.modelo;

@FunctionalInterface
public interface CampoObservador {
    void eventoOcorreu(Campo campo, CampoEvento evento);
}
