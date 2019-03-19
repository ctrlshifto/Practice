package ApacheCommon;




import model.WriteUserModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/19 16:08
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PraticeBeanUtils.class)
public class PraticeSpringFrameworkBeanUtils {

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
            }
        };
        //造数据
        WriteUserModel userModel1 = new WriteUserModel("WhomHim",1,1,1,list,1);
        WriteUserModel userModel2 = new WriteUserModel("xiaoming",2,2,2,list,2);

        List<WriteUserModel>writeUserModelList = new LinkedList<WriteUserModel>(){
            {
                add(userModel1);
                add(userModel2);
            }
        };
        /**
         * package org.springframework.beans;
         * BeanUtils.copyProperties(A,B);
         *是A中的值赋给B
         */
        List<WriteUserModel>userList = new LinkedList<>();
        for (WriteUserModel writeUserModel:writeUserModelList){
            WriteUserModel userModel = new WriteUserModel();
            BeanUtils.copyProperties(writeUserModel,userModel);
            userList.add(userModel);
        }

        userList.forEach((key)->System.out.println(key));

    }

}
