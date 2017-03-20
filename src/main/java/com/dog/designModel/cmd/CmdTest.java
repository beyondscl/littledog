package com.dog.designModel.cmd;

/**
 * Created by Administrator on 2017/3/7.
 */
public class CmdTest {
    public static void main(String[] args) {
        Cmd[] cmds = new Cmd[1];
        cmds[0] = new OffComputer(new Computer());
//        cmds[1] = new OffLight();
//        cmds[2] = new OffDoor();

        Cmd offwork = new Offwork(cmds);
        offwork.exeute();
    }
}
