package dev.remreren.location.usecase;

import dev.remreren.common.DomainComponent;
import dev.remreren.common.usecase.UseCaseHandler;
import dev.remreren.location.model.PlaceResponse;
import dev.remreren.location.port.PlacesNearLocationPort;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class GetPlacesNearLocationUseCaseHandler implements UseCaseHandler<PlaceResponse, GetPlacesNearLocationUseCase> {

    private final PlacesNearLocationPort locationPort;

    @Override
    public PlaceResponse handle(GetPlacesNearLocationUseCase useCase) {

        return locationPort.getPlacesNearLocation(useCase.lat(), useCase.lng(), useCase.radius());

    }
}
