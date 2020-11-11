package SimpleSBApps.swahilicoast.api;

import SimpleSBApps.swahilicoast.model.Commodity;
import SimpleSBApps.swahilicoast.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/commodity")
@RestController
public class CommodityController {

    final private CommodityService commodityService;

    @Autowired
    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @PostMapping
    public void addCommodity(@NonNull @RequestBody Commodity commodity) {
        commodityService.addCommodity(commodity);
    }

    @GetMapping
    public List<Commodity> getAllCommodities() {
        return commodityService.getAllCommodities();
    }

    @GetMapping(path = "{id}")
    public Commodity getCommodityById(@PathVariable("id") UUID id) {
        return commodityService.getCommodityById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCommodityById(@PathVariable("id") UUID id) {
        commodityService.deleteCommodityById(id);
    }

    @PatchMapping(path = "{id}")
    public void updateCommodityById(@PathVariable("id") UUID id, @NonNull @RequestBody String price) {
        System.out.println(price);
        System.out.println(id);
        commodityService.updatePriceById(id, new BigDecimal(price));
    }
}
