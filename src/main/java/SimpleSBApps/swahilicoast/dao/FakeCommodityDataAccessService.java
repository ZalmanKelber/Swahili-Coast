package SimpleSBApps.swahilicoast.dao;

import SimpleSBApps.swahilicoast.model.Commodity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Commodity> selectCommodityById(UUID id) {
        return DB.stream()
                .filter(commodity -> commodity.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCommodityById(UUID id) {
        Optional<Commodity> commodity = selectCommodityById(id);
        if (commodity.isPresent()) {
            DB.remove(commodity.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateCommodityById(UUID id, BigDecimal price) {
        return selectCommodityById(id)
                .map(commodity -> {
                    commodity.setPrice(price);
                    return 1;
                })
                .orElse(0);
    }


}
