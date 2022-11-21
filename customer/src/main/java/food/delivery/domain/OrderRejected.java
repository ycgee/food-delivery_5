package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private String storeId;
    private List<String> options;
}
