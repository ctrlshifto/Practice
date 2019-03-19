package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/19 17:24
 * @Modified by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private String nickname;
    private int age;
}
