# Importando as bibliotecas necessárias
import requests
import json

# Definindo a chave da API do bing maps
bing_maps_key = "AlcD7aCSgr7LdSD9e9l8vsfJOw4-0I0jEghLEEAoonYoVrCSgOT-43yLFedQmeNM"

# Definindo os endereços dos pontos
origem = "Rua Alemanha, 397 - jd europa, Paulínia - SP"
ponto_1 = "Av. Monsenhor Jerônimo Baggio, 40 - Nova Paulínia, Paulínia - SP"
ponto_2 = "Av. José Lozano Araújo, 1515 - Nossa Senhora Aparecida, Paulínia - SP"
destino = "R. Celso Ricardo Breda, 47 - Nova Veneza, paulinia - SP"

# Criando uma lista com os pontos
pontos = [origem, ponto_1, ponto_2, destino]

# Criando uma função para obter as coordenadas de um endereço usando a API do bing maps
def get_coordenadas(endereco):
  # Codificando o endereço para a URL
  endereco_codificado = requests.utils.quote(endereco, safe='')
  # Criando a URL da requisição
  url = f"http://dev.virtualearth.net/REST/v1/Locations?query={endereco_codificado}&key={bing_maps_key}"
  # Fazendo a requisição e obtendo a resposta em formato JSON
  resposta = requests.get(url).json()
  # Extraindo as coordenadas do primeiro resultado encontrado
  coordenadas = resposta["resourceSets"][0]["resources"][0]["point"]["coordinates"]
  # Retornando as coordenadas como uma tupla de latitude e longitude
  return (coordenadas[0], coordenadas[1])

# Criando uma função para obter a distância entre dois pontos usando a API do bing maps
def get_distancia(ponto_a, ponto_b):
  # Criando a URL da requisição
  url = f"http://dev.virtualearth.net/REST/v1/Routes/DistanceMatrix?origins={ponto_a[0]},{ponto_a[1]}&destinations={ponto_b[0]},{ponto_b[1]}&travelMode=driving&key={bing_maps_key}"
  # Fazendo a requisição e obtendo a resposta em formato JSON
  resposta = requests.get(url).json()
  # Extraindo a distância em quilômetros do primeiro resultado encontrado
  distancia = resposta["resourceSets"][0]["resources"][0]["results"][0]["travelDistance"]
  # Retornando a distância
  return distancia

# Criando um dicionário para armazenar as coordenadas de cada ponto
coordenadas = {}
# Percorrendo a lista de pontos
for ponto in pontos:
  # Obtendo as coordenadas do ponto
  coordenadas[ponto] = get_coordenadas(ponto)

# Criando um grafo para representar os pontos e as distâncias entre eles
grafo = {}
# Percorrendo a lista de pontos
for ponto in pontos:
  # Inicializando um dicionário vazio para armazenar os vizinhos do ponto
  grafo[ponto] = {}
  # Percorrendo a lista de pontos novamente
  for outro_ponto in pontos:
    # Se o ponto for diferente do outro ponto
    if ponto != outro_ponto:
      # Obtendo a distância entre os dois pontos
      distancia = get_distancia(coordenadas[ponto], coordenadas[outro_ponto])
      # Adicionando o outro ponto e a distância ao dicionário de vizinhos
      grafo[ponto][outro_ponto] = distancia

# Criando uma função para implementar o algoritmo de dijkstra para encontrar a menor rota entre dois pontos
def dijkstra(ponto_inicial, ponto_final):
  # Inicializando um dicionário para armazenar as distâncias mínimas para cada ponto
  distancias = {}
  # Inicializando um dicionário para armazenar os predecessores de cada ponto
  predecessores = {}
  # Inicializando um conjunto para armazenar os pontos visitados
  visitados = set()
  # Inicializando uma lista para armazenar a rota final
  rota = []
  # Atribuindo a distância zero para o ponto inicial e infinito para os demais pontos
  for ponto in pontos:
    if ponto == ponto_inicial:
      distancias[ponto] = 0
    else:
      distancias[ponto] = float("inf")
  # Enquanto o ponto final não for visitado
  while ponto_final not in visitados:
    # Selecionando o ponto com a menor distância entre os não visitados
    ponto_atual = min(distancias, key=lambda x: distancias[x] if x not in visitados else float("inf"))
    # Adicionando o ponto ao conjunto de visitados
    visitados.add(ponto_atual)
    # Percorrendo os vizinhos do ponto atual
    for vizinho in grafo[ponto_atual]:
      # Calculando a nova distância para o vizinho somando a distância do ponto atual e a distância entre eles
      nova_distancia = distancias[ponto_atual] + grafo[ponto_atual][vizinho]
      # Se a nova distância for menor que a distância atual do vizinho
      if nova_distancia < distancias[vizinho]:
        # Atualizando a distância do vizinho
        distancias[vizinho] = nova_distancia
        # Atualizando o predecessor do vizinho
        predecessores[vizinho] = ponto_atual
  # Iniciando a rota com o ponto final
  rota.append(ponto_final)
  # Iniciando o ponto atual com o predecessor do ponto final
  ponto_atual = predecessores[ponto_final]
  # Enquanto o ponto atual não for o ponto inicial
  while ponto_atual != ponto_inicial:
    # Adicionando o ponto atual à rota
    rota.append(ponto_atual)
    # Atualizando o ponto atual com o seu predecessor
    ponto_atual = predecessores[ponto_atual]
  # Adicionando o ponto inicial à rota
  rota.append(ponto_inicial)
  # Invertendo a ordem da rota
  rota.reverse()
  # Retornando a rota e a distância final
  return (rota, distancias[ponto_final])

# Criando uma lista para armazenar as possíveis soluções
solucoes = []
# Encontrando a menor rota entre a origem e o ponto 1, usando o algoritmo de dijkstra
rota_1, distancia_1 = dijkstra(origem, ponto_1)
# Encontrando a menor rota entre o ponto 1 e o ponto 2, usando o algoritmo de dijkstra
rota_2, distancia_2 = dijkstra(ponto_1, ponto_2)
# Encontrando a menor rota entre o ponto 2 e o destino, usando o algoritmo de dijkstra
rota_3, distancia_3 = dijkstra(ponto_2, destino)
# Somando as distâncias das três rotas e armazenando o resultado como uma possível solução
solucoes.append((rota_1 + rota_2[1:] + rota_3[1:], distancia_1 + distancia_2 + distancia_3))
# Repetindo os passos anteriores, mas trocando a ordem dos pontos 1 e 2
rota_1, distancia_1 = dijkstra(origem, ponto_2)
rota_2, distancia_2 = dijkstra(ponto_2, ponto_1)
rota_3, distancia_3 = dijkstra(ponto_1, destino)
solucoes.append((rota_1 + rota_2[1:] + rota_3[1:], distancia_1 + distancia_2 + distancia_3))
# Comparando as duas soluções e escolhendo a que tiver a menor distância total
menor_solucao = min(solucoes, key=lambda x: x[1])
# Imprimindo a menor rota e a distância total
print(f"A menor rota entre a origem e o destino é: {menor_solucao[0]}")
print(f"https://www.google.com/maps/dir/?api=1&"+
      f"origin={menor_solucao[0][0]}&"+
      f"destination={menor_solucao[0][-1]}&"+
      f"travelmode=driving&"+
      f"waypoints={menor_solucao[0][1]}|{menor_solucao[0][2]}")