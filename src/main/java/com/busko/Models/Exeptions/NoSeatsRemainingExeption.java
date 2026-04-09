package com.busko.Models.Exeptions;

public class NoSeatsRemainingExeption extends RuntimeException {
    public NoSeatsRemainingExeption() {
        super("Сите места се потполнети");
    }
}
