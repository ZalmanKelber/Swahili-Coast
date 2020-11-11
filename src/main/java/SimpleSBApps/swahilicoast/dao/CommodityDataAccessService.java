package SimpleSBApps.swahilicoast.dao;

import SimpleSBApps.swahilicoast.model.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class CommodityDataAccessService implements CommodityDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommodityDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCommodity(UUID id, Commodity commodity) {
        final String sql = "INSERT INTO commodity (id, name, price) VALUES (?, ?, ?)";
        String name = commodity.getName();
        BigDecimal price = commodity.getPrice();
        jdbcTemplate.update(sql, new Object[]{id, name, price});
        return 1;
    }

    @Override
    public List<Commodity> selectAllCommodities() {
        final String sql = "SELECT id, name, price FROM commodity";
        List<Commodity> commodities = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            BigDecimal price = new BigDecimal(resultSet.getString("price"));
            return new Commodity(id, name, price);
        });
        return commodities;
    }

    @Override
    public Optional<Commodity> selectCommodityById(UUID id) {
        final String sql = "SELECT id, name, price FROM commodity WHERE id = ?";
        Commodity commodity = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID commodityId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            BigDecimal price = new BigDecimal(resultSet.getString("price"));
            return new Commodity(commodityId, name, price);
        });
        return Optional.ofNullable(commodity);
    }

    @Override
    public int deleteCommodityById(UUID id) {
        Optional<Commodity> commodity = selectCommodityById(id);
        if (commodity.isPresent()) {
            final String sql = "DELETE FROM commodity WHERE id = ?";
            jdbcTemplate.update(sql, new Object[]{id});
            return 1;
        }
        return 0;
    }

    @Override
    public int updateCommodityById(UUID id, BigDecimal price) {
        System.out.println("invoking updateCommodityById");
        System.out.println(id);
        System.out.println(price);
        Optional<Commodity> commodity = selectCommodityById(id);
        if (commodity.isPresent()) {
            final String sql = "UPDATE commodity SET price = ? WHERE id = ?";
            jdbcTemplate.update(sql, new Object[]{price, id});
            return 1;
        }
        return 0;
    }
}
