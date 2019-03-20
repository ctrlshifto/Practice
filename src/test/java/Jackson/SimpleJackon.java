package Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Friend;

import java.io.File;
import java.io.IOException;

/**
 * @Author:WhomHim
 * @Description:简单映射
 * @Date: Create in 2019/3/19 18:25
 * @Modified by:
 */
public class SimpleJackon {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Friend friend = new Friend("yitian", 25);

        // 写为字符串
        String text = mapper.writeValueAsString(friend);
        System.out.println(text);

        // 写为文件
        mapper.writeValue(new File("friend.json"), friend);
        // 写为字节流
        byte[] bytes = mapper.writeValueAsBytes(friend);
        // 从字符串中读取
        Friend newFriend = mapper.readValue(text, Friend.class);
        // 从字节流中读取
        newFriend = mapper.readValue(bytes, Friend.class);
        // 从文件中读取
        newFriend = mapper.readValue(new File("friend.json"), Friend.class);
        System.out.println(newFriend);
    }

}
