# Importar as bibliotecas necessárias
import geopy.distance
import requests

# Definir os endereços de origem e destino
origem = "Rua João Teodoro, 1200, Centro, Paulínia, SP"
destino = "Avenida José Paulino, 4127, Nossa Senhora de Fátima, Paulínia, SP"

# Criar uma chave válida da API do Bing Maps
bing_key = "AlcD7aCSgr7LdSD9e9l8vsfJOw4-0I0jEghLEEAoonYoVrCSgOT-43yLFedQmeNM"

# Obter as coordenadas dos endereços usando a geocodificação do Bing Maps
origem_url = f"http://dev.virtualearth.net/REST/v1/Locations?query={origem}&key={bing_key}"
destino_url = f"http://dev.virtualearth.net/REST/v1/Locations?query={destino}&key={bing_key}"
origem_res = requests.get(origem_url).json()
destino_res = requests.get(destino_url).json()
origem_coord = origem_res["resourceSets"][0]["resources"][0]["point"]["coordinates"]
destino_coord = destino_res["resourceSets"][0]["resources"][0]["point"]["coordinates"]

# Calcular a distância em quilômetros entre os pontos usando a geopy
distancia = geopy.distance.distance(origem_coord, destino_coord).km

# Obter a rota mais curta entre os pontos usando a API de direções do Bing Maps
rota_url = f"http://dev.virtualearth.net/REST/v1/Routes/Driving?wp.0={origem}&wp.1={destino}&key={bing_key}"
rota_res = requests.get(rota_url).json()
rota = rota_res["resourceSets"][0]["resources"][0]["routeLegs"][0]["itineraryItems"]

# Imprimir os resultados
print(f"A distância entre {origem} e {destino} é de {distancia:.2f} km.")
print(f"A rota mais curta é:")
for passo in rota:
    print(passo["instruction"]["text"])
