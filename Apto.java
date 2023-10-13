import java.util.Objects;

public class Apto {
    private int numero, capacidade;
    private boolean comCamaDeCasal, ocupado, interditado;

    public Apto(int numero, int capacidade, boolean comCamaDeCasal, boolean ocupado, boolean interditado) throws Exception {
        if(numero<100) throw new Exception("Número inválido");
        if(capacidade<1 || capacidade> 5) throw new Exception("Capacidade inválida");

        this.numero = numero;
        this.capacidade = capacidade;
        this.comCamaDeCasal = comCamaDeCasal;
        this.ocupado = ocupado;
        this.interditado = interditado;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isComCamaDeCasal() {
        return comCamaDeCasal;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public boolean isInterditado() {
        return interditado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setComCamaDeCasal(boolean comCamaDeCasal) {
        this.comCamaDeCasal = comCamaDeCasal;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setInterditado(boolean interditado) {
        this.interditado = interditado;
    }

    public boolean compareTo(Object object) {
        if (this == object) return true;
        if (object==null) return false;
        if (object.getClass() != this.getClass()) return false;

        Apto o = (Apto) object;
        if (this.numero!=o.numero || this.capacidade!=o.capacidade || this.comCamaDeCasal!=o.comCamaDeCasal || this.ocupado!=o.ocupado || this.interditado!=o.interditado) return false;
        return true;
    }

    @Override
    public Apto clone() {
        try {
            return new Apto(numero, capacidade, comCamaDeCasal, ocupado, interditado);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, capacidade, comCamaDeCasal, ocupado, interditado);
    }

    @Override
    public String toString() {
        return "Apartamento " + numero +
                ":\n Capacidade = " + capacidade +
                "\n Com cama de casal = " + comCamaDeCasal +
                "\n Ocupado = " + ocupado +
                "\n Interditado = " + interditado +
                '\n';
    }

    public Apto(Apto modelo) throws Exception{
        if(modelo==null)throw new Exception("Modelo vazio");

        this.numero = modelo.numero;
        this.capacidade = modelo.capacidade;
        this.comCamaDeCasal = modelo.comCamaDeCasal;
        this.ocupado = modelo.ocupado;
        this.interditado = modelo.interditado;
    }
}