import requests
import sys

# Defina suas credenciais da API do Bing Maps
BING_MAPS_API_KEY = 'AlcD7aCSgr7LdSD9e9l8vsfJOw4-0I0jEghLEEAoonYoVrCSgOT-43yLFedQmeNM'

def calcular_distancia(ponto1, ponto2):
    url = f"https://dev.virtualearth.net/REST/v1/Routes/Driving?wp.0={ponto1}&wp.1={ponto2}&key={BING_MAPS_API_KEY}"
    response = requests.get(url)
    data = response.json()
    distancia = data["resourceSets"][0]["resources"][0]["travelDistance"]
    return distancia

def encontrar_menor_rota(pontos):
    nao_visitados = pontos.copy()
    rota = [nao_visitados.pop(0)]
    while nao_visitados:
        proximo_ponto = min(nao_visitados, key=lambda ponto: calcular_distancia(rota[-1], ponto))
        nao_visitados.remove(proximo_ponto)
        rota.append(proximo_ponto)
    return rota, sum(calcular_distancia(rota[i-1], rota[i]) for i in range(len(rota)))

# Defina os pontos
pontos = ["-22.775,-47.163", "-22.754,-47.130", "-22.732,-47.164", "-22.761,-47.177", "-22.743,-47.162", "-22.764,-47.143", "-22.777,-47.152", "-22.737,-47.151", "-22.751,-47.172", "-22.768,-47.132"]

# Encontre a rota mais curta
melhor_rota, menor_distancia = encontrar_menor_rota(pontos)

# Imprima a rota mais curta e a distância total
print(f"A menor distância é {menor_distancia} km.")
print(f"A melhor rota é: {' -> '.join(melhor_rota)}.")

def criar_url_google_maps(rota):
    base_url = "https://www.google.com/maps/dir/"
    rota_url = '/'.join(rota)
    return base_url + rota_url

# Crie a URL do Google Maps
url_google_maps = criar_url_google_maps(melhor_rota)

# Imprima a URL do Google Maps
print(f"A URL do Google Maps para a melhor rota é: {url_google_maps}")