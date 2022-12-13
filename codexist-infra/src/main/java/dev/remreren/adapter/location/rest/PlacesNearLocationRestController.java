package dev.remreren.adapter.location.rest;

import dev.remreren.location.model.PlaceResponse;
import dev.remreren.location.port.PlacesNearLocationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlacesNearLocationRestController {

    private final PlacesNearLocationPort placesNearLocationPort;

    @GetMapping
    public ResponseEntity<PlaceResponse> getPlace(@RequestParam("lat") Double lat,
                                                  @RequestParam("lng") Double lng,
                                                  @RequestParam("radius") Long radius) {

        var result = placesNearLocationPort.getPlacesNearLocation(lat, lng, radius);

        return ResponseEntity.ok(result);

    }

}
