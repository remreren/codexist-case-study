package dev.remreren.location.usecase;

import dev.remreren.common.model.UseCase;

public record GetPlacesNearLocationUseCase(Double lat, Double lng, Long radius) implements UseCase {
}
