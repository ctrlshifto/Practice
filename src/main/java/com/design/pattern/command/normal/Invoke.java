package com.design.pattern.command.normal;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/8/28 17:52
 */
//调用者/发起者
public class Invoke {
    //也可以通过容器List<Command>容纳很多命令对象，进行批处理。数据库底层的事务管理就是类似的结构！
    private Command command;

    public Invoke(Command command) {
        super();
        this.command = command;
    }

    //业务方法 ，用于调用命令类的方法
    public void call() {
        command.execute();
    }


}
