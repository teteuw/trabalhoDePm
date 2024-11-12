package br.pm.businessLLM;

public interface Multa {
    /**
     * Método abstrato para calcular a multa por atraso.
     * 
     * @param diasAtrasados número de dias de atraso na devolução.
     * @return o valor da multa calculada.
     */
    double calcularMulta(int diasAtrasados);
}

