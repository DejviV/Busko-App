package com.busko.Models.DTOs.Route.Create;

public record CreateRouteDTO(
        Long companyId,
        String startingPoint,
        String endingPoint
) {
}
