package SimpleSBApps.swahilicoast.api;

import SimpleSBApps.swahilicoast.model.Commodity;
import SimpleSBApps.swahilicoast.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/commodity")
@RestController
public class CommodityController {

    final private CommodityService commodityService;

    @Autowired
    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @PostMapping
    public void addCommodity(@RequestBody Commodity commodity) {
        commodityService.addCommodity(commodity);
    }

    @GetMapping
    public List<Commodity> getAllCommodities() {
        return commodityService.getAllCommodities();
    }
}
