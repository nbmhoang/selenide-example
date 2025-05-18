package org.example.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchCategory {
    ALL("All categories"),
    ACCESSORY_BUNDLES("Accessory Bundles"),
    AUDIO("Audio"),
    CAR_CAMERA("Car Camera"),
    EBOOK_READER("ebook Reader"),
    MP4_PLAYER("MP4 Player"),
    LAPTOP_ACCESSORIES("Laptop Accessories"),
    WATCHES("Watches");

    private final String text;

    @Override
    public String toString() {
        return text;
    }
}
