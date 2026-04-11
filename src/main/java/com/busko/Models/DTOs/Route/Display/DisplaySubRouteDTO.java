package com.busko.Models.DTOs.Route.Display;

import com.busko.Models.SubRoute;

import java.math.BigDecimal;

public record DisplaySubRouteDTO(
        String companyName,
        String routeName,
        BigDecimal price
) {
    public static DisplaySubRouteDTO from(SubRoute subRoute) {
        return new DisplaySubRouteDTO(
                subRoute.getRoute().getCompany().getNameAndSurname(),
                subRoute.getName(),
                subRoute.getPrice()
        );
    }
}
