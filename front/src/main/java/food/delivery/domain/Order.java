package food.delivery.domain;

import food.delivery.domain.OrderPlaced;
import food.delivery.domain.OrderMoniter;
import food.delivery.domain.OrderCanceled;
import food.delivery.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    @ElementCollection
    
    private List<String> options;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();



        OrderMoniter orderMoniter = new OrderMoniter(this);
        orderMoniter.publishAfterCommit();

    }
    @PreRemove
    public void onPreRemove(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }

    @PrePersist
    public void onPrePersist() {
        // Get request from Inventory
        Delivery delivery =
           Application.applicationContext.getBean(DeliveryService.class).getriderQty();

        if(delivery.getOrderId() < getriderQty()) throw new RuntimeException("배송불가");

    }

    private int getriderQty() {
        return 0;
    }
    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
