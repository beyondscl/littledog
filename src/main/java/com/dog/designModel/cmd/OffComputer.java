package com.dog.designModel.cmd;

/**
 * Created by Administrator on 2017/3/7.
 */
public class OffComputer implements Cmd {
    private Computer computer;

    public OffComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void exeute() {
        this.computer.Off();
    }
}
