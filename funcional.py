from functools import reduce

# Lista de transações (imutável)
transacoes = [100.50, -20.00, 500.00, -150.00, 10.00]

# -------------------- FILTRAGEM --------------------
# filter retorna um iterador com apenas os valores > 0
# Nenhum dado original é alterado; um novo fluxo é criado
creditos = filter(lambda x: x > 0, transacoes)

# -------------------- TRANSFORMAÇÃO --------------------
# map aplica a função (multiplicar por 1.02) a cada elemento
# Gera um NOVO iterador, sem modificar o anterior
com_taxa = map(lambda x: x * 1.02, creditos)

# -------------------- AGREGAÇÃO --------------------
# reduce combina todos os valores em um único resultado (soma)
# O valor inicial 0.0 garante que a soma comece do zero
total = reduce(lambda acc, val: acc + val, com_taxa, 0.0)

print(f"Total final após taxa: {total:.2f}")

# -------------------- VERSÃO AINDA MAIS CONCISA (mesmo paradigma) --------------------
# Generator expression que já faz filtro, transformação e agregação em uma linha
total2 = sum(x * 1.02 for x in transacoes if x > 0)
print(f"Total (versão 2): {total2:.2f}")