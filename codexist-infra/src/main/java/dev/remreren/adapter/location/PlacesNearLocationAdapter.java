package dev.remreren.adapter.location;

import dev.remreren.adapter.location.service.GooglePlacesApiClient;
import dev.remreren.configuration.GooglePlacesConfiguration;
import dev.remreren.location.model.PlaceModel;
import dev.remreren.location.port.PlacesNearLocationPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlacesNearLocationAdapter implements PlacesNearLocationPort {

    private final GooglePlacesApiClient googlePlacesClient;

    private final GooglePlacesConfiguration placesConfiguration;

    @Override
    @Cacheable(value = "places-cache", key = "#lat-#lng-#radius", condition = "#result != null")
    public List<PlaceModel> getPlacesNearLocation(Double lat, Double lng, Long radius) {

        var result = googlePlacesClient.getPlacesNearLocation("%f,%f".formatted(lat, lng), placesConfiguration.getKey(), radius);

        return result.getResults();

    }
}
