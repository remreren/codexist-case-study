package dev.remreren.adapter.location.model;

import dev.remreren.location.model.PlaceModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GooglePlacesResponse {

    private final List<PlaceModel> results;

    private final String status;

}
