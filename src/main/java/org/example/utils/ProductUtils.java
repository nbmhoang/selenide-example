package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.example.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ProductUtils {

    /**
     * Check if a list of products is sort by price(low to high)
     *
     * @param products list of products
     * @return true if the list is sorted by price asc
     */
    public static boolean isSortByPriceAsc(List<Product> products) {
        for (int i = 0; i < products.size() - 1; i++) {
            if (products.get(i).getPrice() > products.get(i + 1).getPrice()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a list of products is sort by price(high to low)
     *
     * @param products list of products
     * @return true if the list is sorted by price desc
     */
    public static boolean isSortByPriceDesc(List<Product> products) {
        for (int i = 0; i < products.size() - 1; i++) {
            if (products.get(i).getPrice() < products.get(i + 1).getPrice()) {
                return false;
            }
        }
        return true;
    }

}
