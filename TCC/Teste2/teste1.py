import requests
import math
from itertools import permutations

# Coordenadas de 5 endereços em Paulínia (substitua por suas coordenadas):
coordenadas = [
    (-22.761111111111, -47.154166666667), # Centro da cidade
    (-22.764722222222, -47.160277777778), # Parque Brasil 500
    (-22.774166666667, -47.148611111111), # Rodovia Anhanguera (km 118)
    (-22.753888888889, -47.134722222222), # Paulínia Shopping Center
    (-22.783055555556, -47.171388888889), # Represa de Jaguariúna
    (-22.766111111111, -47.145833333333), # Prefeitura Municipal de Paulínia
    (-22.763333333333, -47.1575), # Câmara Municipal de Paulínia
    (-22.768333333333, -47.1525), # Fórum de Paulínia
    (-22.758611111111, -47.1425), # Teatro Municipal de Paulínia
    (-22.760555555556, -47.147222222222), # Biblioteca Pública Municipal de Paulínia
    (-22.7625, -47.151388888889), # Museu Histórico Municipal de Paulínia
    (-22.771666666667, -47.158055555556), # Estação Rodoviária de Paulínia
    (-22.755555555556, -47.137222222222), # Hospital Municipal de Paulínia
    (-22.7775, -47.166666666667), # Unidade de Pronto Atendimento (UPA) de Paulínia
    (-22.7575, -47.140555555556), # Centro de Saúde de Paulínia
    (-22.769166666667, -47.153611111111), # Escola Estadual "Dr. Carlos de Campos"
    (-22.765, -47.146666666667), # Escola Municipal "Professora Maria José de Oliveira"
    (-22.767777777778, -47.155), # Faculdade de Paulínia (FAP)
    (-22.752777777778, -47.133333333333), # Paulínia Tennis Clube
    (-22.781666666667, -47.169444444444), # Clube Náutico de Paulínia
]

# Chave da API Bing Maps (obtenha sua chave em https://www.bingmapsportal.com/)
chave_bing_maps = "AlcD7aCSgr7LdSD9e9l8vsfJOw4-0I0jEghLEEAoonYoVrCSgOT-43yLFedQmeNM"

# Função para calcular a distância entre dois pontos
def distancia(ponto1, ponto2):
    lat1, lon1 = ponto1
    lat2, lon2 = ponto2
    R = 6371 # raio da Terra em km
    dlat = math.radians(lat2 - lat1)
    dlon = math.radians(lon2 - lon1)
    a = math.sin(dlat/2) * math.sin(dlat/2) + math.cos(math.radians(lat1)) * math.cos(math.radians(lat2)) * math.sin(dlon/2) * math.sin(dlon/2)
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a))
    return R * c

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
        print(f"Erro ao consultar API Bing Maps: {resposta.status_code}")

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