package SimpleSBApps.swahilicoast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.UUID;
import java.math.BigDecimal;

public class Commodity {
    private final UUID id;
    @NonNull
    private final String name;
    @NonNull
    private BigDecimal price;

    public Commodity(@JsonProperty("id") UUID id,
                     @JsonProperty("name") String name,
                     @JsonProperty("price") BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal newPrice) {
        price = newPrice;
    }
}
