package dev.remreren.adapter.location;

import dev.remreren.adapter.location.model.Place;
import dev.remreren.adapter.location.service.GooglePlacesApiClient;
import dev.remreren.configuration.GooglePlacesConfiguration;
import dev.remreren.location.model.PlaceModel;
import dev.remreren.location.model.PlaceResponse;
import dev.remreren.location.port.PlacesNearLocationPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlacesNearLocationAdapter implements PlacesNearLocationPort {

    private final GooglePlacesApiClient googlePlacesClient;

    private final GooglePlacesConfiguration placesConfiguration;

    @Override
    @Cacheable(value = "places-cache", key = "(#lat + ', ' + #lng + ', ' + #radius)", unless = "#result == null")
    public PlaceResponse getPlacesNearLocation(Double lat, Double lng, Long radius) {

        var result = googlePlacesClient.getPlacesNearLocation("%f,%f".formatted(lat, lng), placesConfiguration.getKey(), radius);

        return new PlaceResponse(result.getResults().stream().map(this::toPlaceModel).toList());

    }

    private PlaceModel toPlaceModel(Place place) {

        return new PlaceModel(place.getGeometry());

    }

}
