# Paradigmas de Programação: Processador Financeiro

Uma comparação educacional de três paradigmas de programação aplicados ao mesmo problema: processar transações financeiras.

**Autor**: Murilo Vinícius de Faveri

## 📋 Sobre o Projeto

Este projeto demonstra como resolver o mesmo problema usando três abordagens diferentes:

1. **Programação Orientada a Objetos (Java)** - `orientado_objetos.java`
2. **Programação Funcional (Python)** - `funcional.py`
3. **Programação Imperativa (C)** - `imperativo.c`

### O Problema

Processar uma lista de transações financeiras:
- Filtrar apenas os créditos (valores positivos)
- Aplicar uma taxa de 2% sobre cada crédito
- Retornar o total final

**Dados de exemplo**: `[100.50, -20.00, 500.00, -150.00, 10.00]`

**Resultado esperado**: `~ 621.03`

---

## 🔍 Análise por Paradigma

### 1️⃣ Orientação a Objetos (Java)

**Arquivo**: `orientado_objetos.java`

**Características principais**:
- **Encapsulamento**: Dados privados protegidos por métodos públicos
- **Abstração**: Classes `Transacao` e `ProcessadorFinanceiro` abstraem conceitos
- **Estado mutável**: Objetos podem mudar de estado
- **Responsabilidade única**: Cada classe tem uma função clara

**Como funciona**:
```java
// Cada transação é um objeto com seus próprios dados e comportamentos
Transacao t = new Transacao(100.50);
t.isCredito();      // verifica tipo
t.aplicarTaxa();    // retorna novo objeto com taxa aplicada

// ProcessadorFinanceiro itera e acumula resultados
ProcessadorFinanceiro pf = new ProcessadorFinanceiro(lista);
double total = pf.calcularTotalComTaxa();
```

**Vantagens**: 
- Reutilização de código
- Fácil manutenção para projetos grandes
- Modelagem intuitiva do mundo real

---

### 2️⃣ Programação Funcional (Python)

**Arquivo**: `funcional.py`

**Características principais**:
- **Imutabilidade**: Dados originais nunca são modificados
- **Funções de primeira classe**: `filter`, `map`, `reduce`
- **Composição**: Encadeamento de operações
- **Sem estado**: Resultado depende apenas da entrada

**Como funciona**:
```python
# Encadeamento de transformações (pipeline)
creditos = filter(lambda x: x > 0, transacoes)  # filtra
com_taxa = map(lambda x: x * 1.02, creditos)   # transforma
total = reduce(lambda acc, val: acc + val, com_taxa, 0.0)  # agrega

# Ou de forma mais concisa:
total = sum(x * 1.02 for x in transacoes if x > 0)
```

**Vantagens**:
- Concisão e legibilidade
- Facilita testes (sem efeitos colaterais)
- Mais fácil de raciocinar sobre o código

---

### 3️⃣ Programação Imperativa (C)

**Arquivo**: `imperativo.c`

**Características principais**:
- **Sequência de passos**: Como fazer, não o quê
- **Controle explícito**: Loops e condições manualmente escritos
- **Estado mutável**: Variáveis modificadas diretamente
- **Gerenciamento manual**: Sem abstrações de alto nível

**Como funciona**:
```c
// Passo 1: Filtrar manualmente com loop
for (int i = 0; i < n; i++) {
    if (transacoes[i] > 0) {
        creditos[qtd_creditos] = transacoes[i];
        qtd_creditos++;
    }
}

// Passo 2: Transformar e agregar
float total = 0.0;
for (int i = 0; i < qtd_creditos; i++) {
    creditos[i] = creditos[i] * 1.02;  // mutação in-place
    total += creditos[i];
}
```

**Vantagens**:
- Controle fino sobre performance
- Simples e direto para scripts pequenos
- Sem overhead de abstração

---

## 🚀 Como Executar

### Java
```bash
javac orientado_objetos.java
java orientado_objetos
```

**Saída esperada**:
```
Total final após taxa: 621.03
```

### Python
```bash
python3 funcional.py
```

**Saída esperada**:
```
Total final após taxa: 621.03
Total (versão 2): 621.03
```

### C
```bash
gcc -o imperativo imperativo.c
./imperativo
```

**Saída esperada**:
```
Total final após taxa: 621.03
```

---

## 📊 Comparação Resumida

| Aspecto | OOP (Java) | Funcional (Python) | Imperativo (C) |
|---------|-----------|------------------|----------------|
| **Linhas de código** | ~67 | ~26 | ~34 |
| **Imutabilidade** | ✗ (com opção) | ✓ | ✗ |
| **Abstração** | ✓ (Classes) | ✓ (Funções) | ✗ |
| **Curva de aprendizado** | Média | Baixa | Baixa |
| **Legibilidade** | Boa | Excelente | Boa |
| **Performance** | Boa | Boa | Excelente |
| **Escalabilidade** | Excelente | Boa | Média |

---

## 🎓 Conceitos-Chave Demonstrados

### Filtragem
- **OOP**: Método `isCredito()` dentro do loop
- **Funcional**: Função `filter()` com predicado
- **Imperativo**: Loop com condicional explícito

### Transformação
- **OOP**: Método `aplicarTaxa()` que retorna novo objeto
- **Funcional**: Função `map()` com lambda
- **Imperativo**: Loop que modifica array

### Agregação
- **OOP**: Acumulação manual em método
- **Funcional**: Função `reduce()`
- **Imperativo**: Variável mutável acumulando resultado

---

## 📚 Para Aprender Mais

- **OOP**: Design Patterns, SOLID Principles
- **Funcional**: Lambda Calculus, Type Classes (Haskell/Scala)
- **Imperativo**: Estruturas de Dados, Algoritmos clássicos

---

## 🔧 Estrutura do Projeto

```
.
├── orientado_objetos.java    # Implementação OOP
├── funcional.py               # Implementação Funcional
├── imperativo.c               # Implementação Imperativa
├── *.class                    # Arquivos compilados Java
└── README.md                  # Este arquivo
```

---

## 💡 Conclusão

Cada paradigma tem seus méritos:
- Use **OOP** para sistemas complexos que precisam evoluir
- Use **Funcional** para transformações de dados e concorrência
- Use **Imperativo** quando performance e controle fino são críticos

A escolha do paradigma deve ser orientada pelo problema e contexto do projeto!
