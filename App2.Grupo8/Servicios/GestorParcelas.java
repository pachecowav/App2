package services;

import models.Parcela;

import java.util.ArrayList;
import java.util.List;

public class GestorParcelas {
    private List<Parcela> parcelas;

    public GestorParcelas() {
        this.parcelas = new ArrayList<>();
    }

    public void agregarParcela(Parcela p) {
        parcelas.add(p);
    }

    public void eliminarParcela(Parcela p) {
        parcelas.remove(p);
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public Parcela buscarPorCodigo(String codigo) {
        for (Parcela p : parcelas) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}
