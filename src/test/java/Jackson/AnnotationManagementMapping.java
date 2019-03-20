package Jackson;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.FriendDetail;

import java.io.IOException;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/20 11:18
 * @Modified by:
 */
public class AnnotationManagementMapping {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        FriendDetail fd = new FriendDetail("yitian", 25, "", 0, "");
        String text = mapper.writeValueAsString(fd);
        System.out.println(text);

        FriendDetail fd2 = mapper.readValue(text, FriendDetail.class);
        System.out.println(fd2);
    }

}
