package SimpleSBApps.swahilicoast.dao;

import java.util.List;
import java.util.UUID;

import SimpleSBApps.swahilicoast.model.Commodity;

public interface CommodityDao {
    int insertCommodity(UUID id, Commodity commodity); //returns 0 or 1
    default int insertCommodity(Commodity commodity) {
        UUID id = UUID.randomUUID();
        return insertCommodity(id, commodity);
    }

    List<Commodity> selectAllCommodities();
}
