import requests
import urllib.parse

# Substitua pela sua chave de API do Google Maps
GOOGLE_MAPS_API_KEY = "AIzaSyCEEqRHTgHUYVHBooQCw8t2Uw5A3h43toA"

# Cache para distâncias
distances = {}

def get_distance(point1, point2):
    # Use a distância do cache se já tiver sido calculada
    if (point1, point2) in distances:
        return distances[(point1, point2)]

    url = f"https://maps.googleapis.com/maps/api/directions/json?origin={urllib.parse.quote(point1)}&destination={urllib.parse.quote(point2)}&key={GOOGLE_MAPS_API_KEY}"
    response = requests.get(url)
    data = response.json()
    if data["status"] != "OK":
        print(f"Erro ao obter distância entre {point1} e {point2}: {data['status']}")
        return float("inf")

    # Armazene a distância no cache
    distances[(point1, point2)] = data["routes"][0]["legs"][0]["distance"]["value"]
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
          "Av. Monsenhor Jerônimo Baggio, 40 - Nova Paulínia, Paulínia - SP",
          "Av. José Lozano Araújo, 1515 - Nossa Senhora Aparecida, Paulínia - SP",
          "R. Aparai, 92 - Jardim de Itapoan, Paulínia - SP",
          "Av. Roberto Simonsen, 1459 - Recanto dos Pássaros, Paulínia - SP",
          "Av. Dr. Heitor Nascimento, 809 - Morumbi, Paulínia - SP",
          "R. Celso Ricardo Breda, 47 - Nova Veneza, paulinia - SP"]
route, distance = two_opt(points)
gmaps_url = generate_gmaps_url(route)
print("Rota:", route)
print("Distância:", distance)
print("URL do Google Maps:", gmaps_url)
print(distances)