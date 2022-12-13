package dev.remreren.adapter.location;

import dev.remreren.adapter.location.service.GooglePlacesApiClient;
import dev.remreren.configuration.GooglePlacesConfiguration;
import dev.remreren.location.model.PlaceModel;
import dev.remreren.location.port.PlacesNearLocationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlacesNearLocationAdapter implements PlacesNearLocationPort {

    private final GooglePlacesApiClient googlePlacesClient;

    private final GooglePlacesConfiguration placesConfiguration;

    @Override
    @Cacheable(value = "places-cache", key = "#lat-#lng-#query", condition = "#result != null or #result.size() != 0")
    public List<PlaceModel> getPlacesNearLocation(Double lat, Double lng, String query) {

        var result = googlePlacesClient.getPlacesNearLocation("%f,%f".formatted(lat, lng), query, placesConfiguration.getKey(), placesConfiguration.getRadius());

        return result.getResults();

    }
}
