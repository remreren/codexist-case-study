package dev.remreren.location.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ViewPort {

    private final Location northeast;

    private final Location southwest;

}
