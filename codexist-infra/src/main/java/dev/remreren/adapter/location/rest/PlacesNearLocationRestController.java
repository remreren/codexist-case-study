package dev.remreren.adapter.location.rest;

import dev.remreren.common.usecase.UseCaseHandler;
import dev.remreren.location.model.PlaceResponse;
import dev.remreren.location.usecase.GetPlacesNearLocationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlacesNearLocationRestController {

    private final UseCaseHandler<PlaceResponse, GetPlacesNearLocationUseCase> getPlacesNearUseCaseHandler;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<PlaceResponse> getPlace(@RequestParam("lat") Double lat,
                                                  @RequestParam("lng") Double lng,
                                                  @RequestParam("radius") Long radius) {

        var result = getPlacesNearUseCaseHandler.handle(new GetPlacesNearLocationUseCase(lat, lng, radius));

        return ResponseEntity.ok(result);

    }

}
