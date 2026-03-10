package dao;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dao2")
//@Profile("dev")
public class DaoImpl2 implements IDao {
    @Override public double getValue(){ return 20.0; }
}