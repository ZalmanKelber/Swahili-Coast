package SimpleSBApps.swahilicoast.service;

import SimpleSBApps.swahilicoast.dao.CommodityDao;
import SimpleSBApps.swahilicoast.model.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommodityService {

    private final CommodityDao commodityDao;

    @Autowired
    public CommodityService(@Qualifier("postgres") CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    public int addCommodity(Commodity commodity) {
        return commodityDao.insertCommodity(commodity);
    }

    public List<Commodity> getAllCommodities() {
        return commodityDao.selectAllCommodities();
    }

    public Optional<Commodity> getCommodityById(UUID id) {
        return commodityDao.selectCommodityById(id);
    }

    public int deleteCommodityById(UUID id) {
        return commodityDao.deleteCommodityById(id);
    }

    public int updatePriceById(UUID id, BigDecimal price) {
        return commodityDao.updateCommodityById(id, price);
    }
}
