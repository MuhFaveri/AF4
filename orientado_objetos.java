import java.util.ArrayList;
import java.util.List;

// Classe que representa uma transação individual (encapsulamento)
class Transacao {
    private double valor; // atributo privado – só pode ser acessado via métodos
    
    // Construtor: inicializa o valor da transação
    public Transacao(double valor) {
        this.valor = valor;
    }
    
    // Getter público para acessar o valor (controle de acesso)
    public double getValor() { return valor; }
    
    // Verifica se a transação é um crédito (valor positivo)
    public boolean isCredito() { return valor > 0; }
    
    // Retorna uma NOVA transação com a taxa de 2% aplicada
    // Princípio da imutabilidade: não modifica o objeto atual, cria um novo
    public Transacao aplicarTaxa() {
        return new Transacao(this.valor * 1.02);
    }
}

// Classe gerenciadora que processa uma lista de transações
class ProcessadorFinanceiro {
    private List<Transacao> transacoes; // encapsulamento: lista privada
    
    // Construtor recebe a lista e a armazena
    public ProcessadorFinanceiro(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
    
    // Método público que calcula o total com a taxa aplicada apenas sobre créditos
    public double calcularTotalComTaxa() {
        double total = 0.0; // variável local mutável (dentro do método)
        
        // Itera sobre todas as transações
        for (Transacao t : transacoes) {
            if (t.isCredito()) {                // filtragem
                Transacao comTaxa = t.aplicarTaxa(); // transformação (novo objeto)
                total += comTaxa.getValor();    // agregação
            }
        }
        return total;
    }
}

// Classe principal (pública) – nome deve coincidir com o arquivo
public class orientado_objetos {
    public static void main(String[] args) {
        // Cria uma lista de transações a partir dos valores fornecidos
        List<Transacao> lista = new ArrayList<>();
        double[] valores = {100.50, -20.00, 500.00, -150.00, 10.00};
        for (double v : valores) {
            lista.add(new Transacao(v)); // cada valor vira um objeto Transacao
        }
        
        // Cria o processador e calcula o total
        ProcessadorFinanceiro pf = new ProcessadorFinanceiro(lista);
        double total = pf.calcularTotalComTaxa();
        
        // Exibe o resultado
        System.out.printf("Total final após taxa: %.2f\n", total);
    }
}