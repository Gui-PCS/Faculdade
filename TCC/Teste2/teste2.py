import requests
import os
import json
from itertools import permutations
from datetime import datetime, timedelta

# Coordenadas de 5 endereços em Paulínia (substitua por suas coordenadas):
coordenadas = [
    (-22.925845104698688, -47.03803363513842), #Unip
    (-22.847155965544953, -47.062149636645394), #Shopping dom pedro
    (-22.78264182762355, -47.15379760853105), #Shopping paulinia
    (-22.789736520688336, -47.13977233756122), #Pastelaria
    (-22.768587360657886, -47.1435274302929), #Sport Club
    (-22.770704402707707, -47.154234808655346), #Dalben
    (-22.770011915951443, -47.15801940562633), #Kabi
    (-22.770044067202402, -47.149098378197706), #Hospital
    (-22.7682460959185, -47.14844974778038), #Cemitery
    (-22.792306652568872, -47.13834494972315) #Portal Medieval
]

# Chave da API Bing Maps (obtenha sua chave em https://www.bingmapsportal.com/)
chave_bing_maps = "AlcD7aCSgr7LdSD9e9l8vsfJOw4-0I0jEghLEEAoonYoVrCSgOT-43yLFedQmeNM"

# Função para calcular a distância entre dois pontos
def distancia(ponto1, ponto2):
    lat1, lon1 = ponto1
    lat2, lon2 = ponto2
    cache_file = f"distances/{lat1}_{lon1}_{lat2}_{lon2}.json"
    if os.path.exists(cache_file):
        # Verifica a idade do arquivo
        mod_date = datetime.fromtimestamp(os.path.getmtime(cache_file))
        if datetime.now() - mod_date > timedelta(days=20):
            # Se o arquivo tiver mais de 20 dias, renova o cache
            os.remove(cache_file)
        else:
            with open(cache_file, 'r') as f:
                distancia = json.load(f)['resourceSets'][0]['resources'][0]['travelDistance']
                return distancia

    # Se o arquivo não existir ou tiver sido removido, faz a requisição
    url = f"https://dev.virtualearth.net/REST/v1/Routes/Driving?wp.0={lat1},{lon1}&wp.1={lat2},{lon2}&key={chave_bing_maps}&distanceUnit=km"
    resposta = requests.get(url)
    if resposta.status_code == 200:
        # Extração da distância da rota
        distancia = resposta.json()['resourceSets'][0]['resources'][0]['travelDistance']
        with open(cache_file, 'w') as f:
            json.dump(resposta.json(), f)
    else:
        print(f"Erro ao consultar API Bing Maps: {resposta.status_code} na rota {lat1},{lon1} -> {lat2},{lon2}")
        return float('inf')
    return distancia

# Função para gerar matriz de distâncias
def matriz_distancias(coordenadas):
    matriz = []
    for i in range(len(coordenadas)):
        linha = []
        for j in range(len(coordenadas)):
            linha.append(distancia(coordenadas[i], coordenadas[j]))
        matriz.append(linha)
    return matriz

# Função para calcular a rota otimizada com o Caixeiro Viajante
def rota_otimizada(matriz_distancias):
    melhor_rota = None
    menor_distancia = float('inf')
    for permutacao in permutations(range(len(matriz_distancias))):
        distancia_total = 0
        for i in range(len(permutacao) - 1):
            distancia_total += matriz_distancias[permutacao[i]][permutacao[i+1]]
        distancia_total += matriz_distancias[permutacao[-1]][permutacao[0]]
        if distancia_total < menor_distancia:
            menor_distancia = distancia_total
            melhor_rota = permutacao
    return melhor_rota

def two_opt(matriz_distancias):
    num_cidades = len(matriz_distancias)
    rota = list(range(num_cidades))  # começa com uma rota simples
    melhorou = True
    while melhorou:
        melhorou = False
        for i in range(1, num_cidades - 1):
            for j in range(i + 1, num_cidades):
                if j - i == 1: continue  # alterações não resultariam em uma rota diferente
                nova_rota = rota[:]
                nova_rota[i:j] = rota[j - 1:i - 1:-1]  # esta é a operação 2-opt
                if distancia_total(nova_rota, matriz_distancias) < distancia_total(rota, matriz_distancias):
                    rota = nova_rota
                    melhorou = True
    return rota

def distancia_total(rota, matriz_distancias):
    distancia_total = 0
    num_cidades = len(rota)
    for i in range(num_cidades):
        distancia_total += matriz_distancias[rota[i]][rota[(i + 1) % num_cidades]]
    return distancia_total

# Cálculo da matriz de distâncias
matriz_distancias = matriz_distancias(coordenadas)

# Cálculo da rota otimizada
rota_otimizada = two_opt(matriz_distancias)

# Geração das instruções de rota
instrucoes_rota = []
for i in range(len(rota_otimizada) - 1):
    origem = coordenadas[rota_otimizada[i]]
    destino = coordenadas[rota_otimizada[i+1]]
    # Chamada à API Bing Maps para obter instruções de rota
    url = f"https://dev.virtualearth.net/REST/v1/Routes/Directions?wp.0={origem[0]},{origem[1]}&wp.1={destino[0]},{destino[1]}&key={chave_bing_maps}&routeAttributes=routeInstructions"
    resposta = requests.get(url)
    if resposta.status_code == 200:
        # Extração das instruções de rota
        instrucoes = resposta.json()['resourceSets'][0]['resources'][0]['routeInstructions']
        for instrucao in instrucoes:
            instrucoes_rota.append(instrucao['text'])
    else:
        print(f"Erro ao consultar API Bing Maps: {resposta.status_code} na rota {origem} -> {destino}")

# Impressão da rota otimizada e instruções
print("Rota otimizada:")
for i in range(len(rota_otimizada)):
    print(f"Ponto {i+1}: {coordenadas[rota_otimizada[i]]}")

# Geração do URL do Google Maps
url_google_maps = "https://www.google.com/maps/dir/"
for i in range(len(rota_otimizada)):
    coord = coordenadas[rota_otimizada[i]]
    url_google_maps += f"{coord[0]},{coord[1]}/"
url_google_maps = url_google_maps.rstrip('/')  # remove a última barra

print("URL do Google Maps para a rota otimizada:")
print(url_google_maps)