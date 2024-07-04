package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitRecord;

public class PurchaseStrategy implements TypeService {
    @Override
    public void calculation(FruitRecord record) {
        Integer currentQuantity = Storage.storage.get(record.getFruit());
        int purchaseQuantity = record.getQuantity();
        if (currentQuantity == null || currentQuantity < 0) {
            throw new IllegalArgumentException("Invalid quantity of for purchase.");
        }
        int newQuantity = currentQuantity - purchaseQuantity;
        Storage.storage.put(record.getFruit(), newQuantity);
    }
}