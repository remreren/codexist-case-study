package dev.remreren.location.port;

import dev.remreren.common.DomainComponent;
import dev.remreren.location.model.PlaceModel;

import java.util.List;

@DomainComponent
public interface PlacesNearLocationPort {

    List<PlaceModel> getPlacesNearLocation(Double lat, Double lng, String query);

}
