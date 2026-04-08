package com.busko.Models.Exeptions;

public class NoSeatsRemainingExeption extends RuntimeException {
    public NoSeatsRemainingExeption(Long id) {
        super("Сите места се потполнети");
    }
}
