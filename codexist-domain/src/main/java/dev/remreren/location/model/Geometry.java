package dev.remreren.location.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Geometry {

    private final Location location;

    private final ViewPort viewport;

}
