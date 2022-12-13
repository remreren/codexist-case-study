package dev.remreren.location.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlaceModel {

    private final String formattedAddress;

    private final Geometry geometry;

}
