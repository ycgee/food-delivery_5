package food.delivery.infra;
import food.delivery.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/deliveries")
@Transactional
public class DeliveryController {
    @Autowired
    DeliveryRepository deliveryRepository;





    @RequestMapping(value = "deliveries/{id}/decreaterider",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Delivery decreaterider(@PathVariable(value = "id") Long id, @RequestBody DecreateriderCommand decreateriderCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /delivery/decreaterider  called #####");
            Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
            
            optionalDelivery.orElseThrow(()-> new Exception("No Entity Found"));
            Delivery delivery = optionalDelivery.get();
            delivery.decreaterider(decreateriderCommand);
            
            deliveryRepository.save(delivery);
            return delivery;
            
    }
    



}
