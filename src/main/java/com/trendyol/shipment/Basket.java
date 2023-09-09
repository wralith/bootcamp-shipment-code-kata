package com.trendyol.shipment;

import java.util.HashMap;
import java.util.List;

public class Basket {

    private List<Product> products;

    public ShipmentSize getShipmentSize() {
        int sizeThreshold = 3;
        if  (products.size() <= 2) {
            return largestShipmentSize();
        }
        var size = ShipmentSize.SMALL;
        var m = new HashMap<ShipmentSize, Integer>();
        for (var product : products) {
            var currentSize = product.getSize();
            m.putIfAbsent(currentSize, 0);
            m.put(currentSize, m.get(currentSize) + 1);
        }
        for (var entry : m.entrySet()) {
            if (entry.getValue() >= sizeThreshold) {
                return entry.getKey().getOneSizeLarger();
            }
            if (entry.getKey().getNumberRepresentation() > size.getNumberRepresentation()) {
                size = entry.getKey();
            }
        }
        return size;
    }

    private ShipmentSize largestShipmentSize() {
        var size = ShipmentSize.SMALL;
        for (var product : products) {
            if (product.getSize().getNumberRepresentation() > size.getNumberRepresentation()) {
                size = product.getSize();
            }
        }
        return size;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
