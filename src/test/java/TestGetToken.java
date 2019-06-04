
import com.ace.wework.Wework;
import com.ace.wework.WeworkConfig;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


public class TestGetToken {
    @Test
    void testToken(){
       Wework wework=new Wework();
        String token=Wework.getWeworkToken(WeworkConfig.getInstance().Secret);
       assertThat(token,not(equalTo(null)));
    }


}
