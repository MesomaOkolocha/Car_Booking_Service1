package org.mesoma.Cars;

public record CarRegistrationRequest(String regNumber, double rentalPrice, Brand brand, boolean isElectric) {
}
