package dev.remreren.adapter.location.model;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GooglePlacesResponse {

    private List<Place> results;

    private String status;

}
