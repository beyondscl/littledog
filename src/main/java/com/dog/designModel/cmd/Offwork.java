package com.dog.designModel.cmd;

/**
 * Created by Administrator on 2017/3/7.
 * 我发起下班命令,这不包含实体,包含一组命令的集合
 * 那么就关电脑，关灯，锁门，走人
 * 一个或一组对象的命令的集合
 */
public class Offwork implements Cmd {
    private Cmd[] cmds;

    public Offwork(Cmd[] cmds) {
        this.cmds = cmds;
    }

    @Override
    public void exeute() {
        for (Cmd cmd : cmds) {
            cmd.exeute();
        }
    }
}
