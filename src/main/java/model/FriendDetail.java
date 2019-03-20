package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/20 11:09
 * @Modified by:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//定义一个根Key
@JsonRootName("FriendDetail")
//生成json忽略这两个字段
@JsonIgnoreProperties({"uselessProp1", "uselessProp3"})

public class FriendDetail {

    private String name;

    private int age;
    private String uselessProp1;

    private int uselessProp2;
    private String uselessProp3;
}

