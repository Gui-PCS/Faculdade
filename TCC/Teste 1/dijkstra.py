# Definir os cinco pontos e as distâncias entre eles
pontos = ["A", "B", "C", "D", "E"]
distancias = {
    ("A", "B"): 5,
    ("A", "C"): 3,
    ("A", "D"): 2,
    ("B", "C"): 4,
    ("B", "E"): 6,
    ("C", "D"): 1,
    ("C", "E"): 7,
    ("D", "E"): 8
}

# Definir o ponto de partida e o ponto de destino
partida = "A"
destino = "E"

# Criar uma função que implementa o algoritmo de Dijkstra
def dijkstra(pontos, distancias, partida):
    # Inicializar as listas de distâncias, visitados e anteriores
    infinito = float("inf")
    distancia = {ponto: infinito for ponto in pontos}
    distancia[partida] = 0
    visitado = {ponto: False for ponto in pontos}
    anterior = {ponto: None for ponto in pontos}

    # Enquanto houver pontos não visitados
    while not all(visitado.values()):
        # Selecionar o ponto não visitado com a menor distância atual
        min_distancia = infinito
        min_ponto = None
        for ponto, dist in distancia.items():
            if not visitado[ponto] and dist < min_distancia:
                min_distancia = dist
                min_ponto = ponto
        
        # Marcar o ponto selecionado como visitado
        visitado[min_ponto] = True

        # Para cada ponto vizinho do ponto selecionado
        for ponto in pontos:
            if (min_ponto, ponto) in distancias:
                # Calcular a distância até o ponto vizinho
                nova_distancia = distancia[min_ponto] + distancias[(min_ponto, ponto)]
                # Se a distância calculada for menor do que a distância atual do ponto vizinho
                if nova_distancia < distancia[ponto]:
                    # Atualizar a distância e o anterior do ponto vizinho
                    distancia[ponto] = nova_distancia
                    anterior[ponto] = min_ponto
    
    # Retornar as listas de distâncias e anteriores
    return distancia, anterior

# Chamar a função com os parâmetros definidos
distancia, anterior = dijkstra(pontos, distancias, partida)

# Obter a distância e o caminho mais curto entre o ponto de partida e o ponto de destino
distancia_final = distancia[destino]
caminho_final = [destino]
while anterior[destino] is not None:
    destino = anterior[destino]
    caminho_final.append(destino)
caminho_final.reverse()

# Imprimir os resultados
print(f"A distância entre {partida} e {caminho_final[-1]} é de {distancia_final} km.")
print(f"A rota mais curta é:")
for ponto in caminho_final:
    print(ponto, end=" ")
