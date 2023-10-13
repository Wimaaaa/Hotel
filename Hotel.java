import java.util.Arrays;

public class Hotel {

    private Apto[] hotel;
    private int ultimoApto;
    Hotel(int qtd) throws Exception{
        int qtd10Casal, qtd20Single, qtd15Duplos, qtd15Triplos, qtdDemais, qtdTotal; //quantidade de andares contendo cada tipo de apartamento e quantidade total de apartamentos
        int aptoAtual = 0, i, j, indice=0, ultimoAndar=0;

        if (qtd<0) throw new Exception("Quantidade de apartamentos inválida");

        qtd10Casal  = (int) (qtd*0.2); //define quantos andares com 10 apartamentos de casal com cama adicional vão existir
        qtd20Single = (int) (qtd*0.15); //define quantos andares com 20 apartamentos single vão existir
        qtd15Duplos = (int) (qtd*0.15); //define quantos andares com 15 apartamentos duplos vão existir
        qtd15Triplos= (int) (qtd*0.3); //define quantos andares com 15 apartamentos triplos vão existir
        qtdDemais= qtd-(qtd10Casal+qtd20Single+qtd15Duplos+qtd15Triplos); //define quantos andares com 5 apartamentos quadruplos e 5 de casal vão existir
        qtdTotal=(qtd10Casal*10)+(qtd20Single*20)+(qtd15Duplos*15)+(qtd15Triplos*15)+(qtdDemais*10); //calcula a quantidade total de apartamentos

        this.hotel = new Apto[qtdTotal];
        for(i=1;i<=qtd10Casal;i++){ //percorre os andares destinados a esse tipo de apartamento
            for(j=1;j<=10;j++){ //percorre cada apartamento por andar
                aptoAtual = (i*100)+j;
                System.out.println(aptoAtual);
                hotel[indice] = new Apto(aptoAtual, 3, true, false, false);
                indice++;
            }
            ultimoAndar=i;
            System.out.println(ultimoAndar);
        }
        System.out.println(i);
        for(i=ultimoAndar;i<=qtd20Single;i++){
            for(j=1;j<=20;j++){
                aptoAtual = (i*100)+j;
                System.out.println(aptoAtual);
                hotel[indice] = new Apto(aptoAtual, 1, false, false, false);
                indice++;
            }
            ultimoAndar=i;

        }
        for(i=ultimoAndar;i<=qtd15Duplos;i++){
            for(j=1;j<=15;j++){
                aptoAtual = (i*100)+j;
                System.out.println(aptoAtual);
                hotel[indice] = new Apto(aptoAtual, 2, false, false, false);
                indice++;
            }
        }
        for(i=qtd15Duplos+1;i<=qtd15Triplos;i++){
            for(j=1;j<=15;j++){
                aptoAtual = (i*100)+j;
                System.out.println(aptoAtual);
                hotel[indice] = new Apto(aptoAtual, 3, false, false, false);
                indice++;
            }
        }
        for(i=qtd15Triplos+1;i<=qtdDemais;i++){
            for(j=1;j<=5;j++){
                aptoAtual = (i*100)+j;
                System.out.println(aptoAtual);
                hotel[indice] = new Apto(aptoAtual, 4, false, false, false);
                indice++;
            }
            for(j=1;j<=5;j++){
                aptoAtual = (i*100)+j;
                System.out.println(aptoAtual);
                hotel[indice] = new Apto(aptoAtual, 2, true, false, false);
                indice++;
            }
        }
        ultimoApto=aptoAtual;
    }
    public void interdite (int numApto) throws Exception{
        int i;
        if(numApto<0) throw new Exception("Apartamento inválido.");
        if(numApto>ultimoApto) throw new Exception("Apartamento inválido.");
        for (Apto apartamento : hotel){
            if(apartamento.getNumero()==numApto){
                if(apartamento.isInterditado()) throw new Exception("Apartamento já estava interditado.");
                apartamento.setInterditado(true);
            }
        }
    }
    public void ocupe (int numApto) throws Exception{
        int i;
        if(numApto<0) throw new Exception("Apartamento inválido.");
        if(numApto>ultimoApto) throw new Exception("Apartamento inválido.");
        for (Apto apartamento : hotel){
            if(apartamento.getNumero()==numApto){
                if(apartamento.isOcupado()) throw new Exception("Apartamento já estava ocupado.");
                apartamento.setOcupado(true);
            }
        }
    }
    public void desocupe (int numApto) throws Exception{
        if(numApto<0) throw new Exception("Apartamento inválido.");
        if(numApto>ultimoApto) throw new Exception("Apartamento inválido.");
        for (Apto apartamento : hotel){
            if(apartamento.getNumero()==numApto){
                if(!(apartamento.isOcupado())) throw new Exception("Apartamento já estava desocupado.");
                apartamento.setOcupado(false);
            }
        }
    }
    public int capacidade(){
        int capacidadeTotal = 0;

        for (Apto apartamento : hotel) {
            if (apartamento != null) {
                capacidadeTotal += apartamento.getCapacidade();
            }
        }

        return capacidadeTotal;
    }

    @Override
    public String toString() {
        String ret="Hotel: ";
        for (Apto apartamento : hotel) {
            ret += apartamento.toString();
        };
        return ret;
    }
}
