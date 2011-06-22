import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    logger.info("Hello World");
    Wombat wombat = new Wombat();
    wombat.setTemperature(4);
    wombat.setTemperature(54);
  }
}