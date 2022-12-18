package dev.remreren.location.port;

import dev.remreren.location.model.*;

import java.util.List;

public class FakePlacesNearLocationPort implements PlacesNearLocationPort {

    @Override
    public PlaceResponse getPlacesNearLocation(Double lat, Double lng, Long radius) {

        return new PlaceResponse(
                List.of(
                        new PlaceModel(
                                new Geometry(
                                        new Location(lat, lng),
                                        new ViewPort()))));
    }

}
