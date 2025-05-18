package org.example.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortOption {
    DEFAULT("Default sorting"),
    POPULARITY("Popularity"),
    RATING("Sort by average rating"),
    LATEST("Sort by latest"),
    PRICE_ASC("Sort by price: low to high"),
    PRICE_DESC("Sort by price: high to low");

    private final String value;
}
