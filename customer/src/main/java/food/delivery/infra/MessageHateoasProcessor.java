package food.delivery.infra;
import food.delivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class MessageHateoasProcessor implements RepresentationModelProcessor<EntityModel<Message>>  {

    @Override
    public EntityModel<Message> process(EntityModel<Message> model) {

        
        return model;
    }
    
}
