import requests
import urllib.parse

# Substitua pela sua chave de API do Bing Maps
BING_MAPS_API_KEY = "AlcD7aCSgr7LdSD9e9l8vsfJOw4-0I0jEghLEEAoonYoVrCSgOT-43yLFedQmeNM"

# Cache para distâncias
distances = {}

def get_distance(point1, point2):
    # Use a distância do cache se já tiver sido calculada
    if (point1, point2) in distances:
        return distances[(point1, point2)]

    url = f"https://dev.virtualearth.net/REST/V1/Routes/Driving?wp.0={point1}&wp.1={point2}&key={BING_MAPS_API_KEY}"
    print(url)
    response = requests.get(url)
    data = response.json()
    if "errorDetails" in data:
        print(f"Erro ao obter distância entre {point1} e {point2}: {data['errorDetails']}")
        return float("inf")

    # Armazene a distância no cache
    distances[(point1, point2)] = data["resourceSets"][0]["resources"][0]["travelDistance"]
    return distances[(point1, point2)]

def two_opt(route):
    first_point = route[0]
    other_points = route[1:]
    min_distance = sum(get_distance(other_points[i], other_points[i+1]) for i in range(len(other_points) - 1))
    visited = set([first_point])
    for i in range(len(other_points)):
        for j in range(i+2, len(other_points) + (i>0)):
            new_route = other_points[:i] + other_points[i:j][::-1] + other_points[j:]
            new_distance = sum(get_distance(new_route[i], new_route[i+1]) for i in range(len(new_route) - 1))
            if new_distance < min_distance and all(point not in visited for point in new_route):
                other_points = new_route
                min_distance = new_distance
        visited.update(other_points)
    return [first_point] + other_points, min_distance

def generate_gmaps_url(route):
    origin = urllib.parse.quote(route[0])
    destination = urllib.parse.quote(route[-1])
    waypoints = "|".join(urllib.parse.quote(point) for point in route[1:-1])
    return f"https://www.google.com/maps/dir/?api=1&origin={origin}&destination={destination}&travelmode=driving&waypoints={waypoints}"

points = ["Av. Alexandre Cazellato, 4555 - Parque das Indústrias, Paulínia - SP, 13148-218",
          "PRAÇA, Av. Monsenhor Jerônimo Baggio, 40 - Nova Paulínia, Paulínia - SP, 13140-301",
          "Av. José Lozano Araújo, n° 1515 - Nossa Senhora Aparecida, Paulínia - SP, 13140-560",
          "R. Aparai, 92 - Jardim de Itapoan, Paulínia - SP, 13140-232",
          "Av. Roberto Simonsen, 1459 - Recanto dos Pássaros, Paulínia - SP, 13140-000",
          "Av. Dr. Heitor Nascimento, 809 - Jardim Nossa Sra. Aparecida, Paulínia - SP, 13140-262",
          "R. Celso Ricardo Breda, 47 - Nova Veneza, Paulínia - SP, 13140-000"]
route, distance = two_opt(points)
gmaps_url = generate_gmaps_url(route)
print("Rota:", route)
print("Distância:", distance)
print("URL do Google Maps:", gmaps_url)
print(len(distances))