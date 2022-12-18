package dev.remreren.location.usecase;

import dev.remreren.location.model.Location;
import dev.remreren.location.port.FakePlacesNearLocationPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetPlacesNearLocationUseCaseHandlerTest {

    @Test
    void handle() {

        // Given
        final var lat = 41.0;
        final var lng = 29.0;
        final var radius = 1000L;

        final var placesNearLocationPort = new FakePlacesNearLocationPort();
        final var placesNearLocationUseCase = new GetPlacesNearLocationUseCase(lat, lng, radius);
        final var placesNearLocationUseCaseHandler = new GetPlacesNearLocationUseCaseHandler(placesNearLocationPort);

        // When
        var result = placesNearLocationUseCaseHandler.handle(placesNearLocationUseCase);

        // Then
        assertEquals(1, result.getPlaces().size());
        assertEquals(new Location(lat, lng), result.getPlaces().get(0).getGeometry().getLocation());

    }

}