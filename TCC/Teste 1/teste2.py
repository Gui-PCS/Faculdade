import requests
import itertools
import urllib.parse

# Substitua pela sua chave de API do Bing Maps
BING_MAPS_API_KEY = "AlcD7aCSgr7LdSD9e9l8vsfJOw4-0I0jEghLEEAoonYoVrCSgOT-43yLFedQmeNM"

def get_distance(point1, point2):
    url = f"https://dev.virtualearth.net/REST/V1/Routes/Driving?wp.0={point1}&wp.1={point2}&key={BING_MAPS_API_KEY}"
    response = requests.get(url)
    data = response.json()
    if "errorDetails" in data:
        print(f"Erro ao obter distância entre {point1} e {point2}: {data['errorDetails']}")
        return float("inf")
    return data["resourceSets"][0]["resources"][0]["travelDistance"]

def travelling_salesman(points):
    min_distance = float("inf")
    min_route = None

    for route in itertools.permutations(points[1:-1]):
        route = [points[0]] + list(route) + [points[-1]]
        total_distance = sum(get_distance(route[i], route[i+1]) for i in range(len(route) - 1))

        if total_distance < min_distance:
            min_distance = total_distance
            min_route = route

    return min_route, min_distance

def generate_gmaps_url(route):
    origin = urllib.parse.quote(route[0])
    destination = urllib.parse.quote(route[-1])
    waypoints = "|".join(urllib.parse.quote(point) for point in route[1:-1])
    return f"https://www.google.com/maps/dir/?api=1&origin={origin}&destination={destination}&travelmode=driving&waypoints={waypoints}"

points = ["Av. Alexandre Cazellato, 4555 - Parque das Indústrias, Paulínia - SP, 13148-218",
          "Av. Monsenhor Jerônimo Baggio, 40 - Nova Paulínia, Paulínia - SP",
          "Av. José Lozano Araújo, 1515 - Nossa Senhora Aparecida, Paulínia - SP",
          "R. Celso Ricardo Breda, 47 - Nova Veneza, paulinia - SP",
          "R. Aparai, 92 - Jardim de Itapoan, Paulínia - SP",
          "Av. Roberto Simonsen, 1459 - Recanto dos Pássaros, Paulínia - SP",
          "Av. Dr. Heitor Nascimento, 809 - Morumbi, Paulínia - SP"]
route, distance = travelling_salesman(points)
gmaps_url = generate_gmaps_url(route)
print("Rota:", route)
print("Distância:", distance)
print("URL do Google Maps:", gmaps_url)