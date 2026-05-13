#include <stdio.h>

int main() {
    // Lista de transações (valores positivos = créditos, negativos = débitos)
    float transacoes[] = {100.50, -20.00, 500.00, -150.00, 10.00};
    int n = 5; // quantidade de transações
    
    // Array para armazenar apenas os créditos (valores positivos)
    float creditos[5]; // capacidade máxima igual ao original
    int qtd_creditos = 0; // contador de quantos créditos foram filtrados
    
    // -------------------- FILTRAGEM --------------------
    // Percorre todas as transações e mantém apenas as positivas
    for (int i = 0; i < n; i++) {
        if (transacoes[i] > 0) {
            creditos[qtd_creditos] = transacoes[i]; // copia o valor
            qtd_creditos++; // incrementa o contador
        }
    }
    
    // -------------------- TRANSFORMAÇÃO + AGREGAÇÃO --------------------
    float total = 0.0; // variável mutável que acumulará o resultado final
    
    // Aplica taxa de 2% sobre cada crédito e soma ao total
    // IMPORTANTE: o array 'creditos' é modificado diretamente (mutação in-place)
    for (int i = 0; i < qtd_creditos; i++) {
        creditos[i] = creditos[i] * 1.02; // mutação: o valor antigo é sobrescrito
        total += creditos[i]; // acumulação manual
    }
    
    // Exibe o resultado final
    printf("Total final após taxa: %.2f\n", total);
    return 0;
}