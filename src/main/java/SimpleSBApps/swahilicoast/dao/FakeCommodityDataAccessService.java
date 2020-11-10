package SimpleSBApps.swahilicoast.dao;

import SimpleSBApps.swahilicoast.model.Commodity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeCommodityDataAccessService implements CommodityDao {

    private static List<Commodity> DB = new ArrayList<Commodity>();

    @Override
    public int insertCommodity(UUID id, Commodity commodity) {
        DB.add(new Commodity(id, commodity.getName(), commodity.getPrice()));
        return 1;
    }

    @Override
    public List<Commodity> selectAllCommodities() {
        return DB;
    }
}
