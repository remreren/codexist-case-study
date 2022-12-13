package dev.remreren.common.usecase;

import dev.remreren.common.model.UseCase;

public interface UseCaseHandler<E, T extends UseCase> {

    E handle(T useCase);

}
