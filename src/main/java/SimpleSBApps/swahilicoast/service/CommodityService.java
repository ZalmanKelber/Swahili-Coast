package SimpleSBApps.swahilicoast.service;

import SimpleSBApps.swahilicoast.dao.CommodityDao;
import SimpleSBApps.swahilicoast.model.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {

    private final CommodityDao commodityDao;

    @Autowired
    public CommodityService(@Qualifier("fakeDao") CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    public int addCommodity(Commodity commodity) {
        return commodityDao.insertCommodity(commodity);
    }

    public List<Commodity> getAllCommodities() {
        return commodityDao.selectAllCommodities();
    }
}
