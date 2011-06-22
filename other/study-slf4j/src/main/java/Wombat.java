import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
  
public class Wombat {
   
    final Logger logger = LoggerFactory.getLogger(Wombat.class);
    Integer t;
    Integer oldT;
 
   public void setTemperature(Integer temperature) {
    
     oldT = t;        
     t = temperature;

     logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);

     if(temperature.intValue() > 50) {
       logger.info("Temperature has risen above 50 degrees.");
     }
   }
} 