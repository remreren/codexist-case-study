package dev.remreren.location.port;

import dev.remreren.common.DomainComponent;
import dev.remreren.location.model.PlaceResponse;

@DomainComponent
public interface PlacesNearLocationPort {

    PlaceResponse getPlacesNearLocation(Double lat, Double lng, Long radius);

}
