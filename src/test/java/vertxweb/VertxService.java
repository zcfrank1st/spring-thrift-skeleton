package vertxweb;

import org.springframework.stereotype.Component;

/**
 * Created by zcfrank1st on 28/04/2017.
 */
@Component
public class VertxService {

    public String hello() {
        throw new RuntimeException("");
//        return "he";
    }
}
