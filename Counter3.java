package com.itheima.demo.thinkinjava;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Counter3 extends Applet implements Runnable{

    private int count=0;
    private boolean runFlag=true;
    private Thread selfThread=null;

    @Override
    public void run() {
        while (true){
            try {
                selfThread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(runFlag){
                t.setText(Integer.toString(count++));
            }
        }
    }

    /*private class SeparateSubTask extends Thread{
        private int count=0;
        //private Counter2 c2;
        private boolean runFlag=true;

        public SeparateSubTask() {
            //this.c2 = c2;
            start();
        }

        *//*public void invertFlag(){
            runFlag=!runFlag;
        }*//*

        @Override
        public void run() {
            //super.run();
            while (true){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(runFlag){
                    t.setText(Integer.toString(count++));
                }
            }
        }

    }*/

    private TextField t = new TextField(10);
    //private SeparateSubTask sp=null;
    private Button onOff=new Button("Toggle"),start=new Button("Start");
    public void init(){
        add(t);
        start.addActionListener(new StartL());
        add(start);
        onOff.addActionListener(new OnOffL());
        add(onOff);
    }
    class StartL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(selfThread==null){
                //内部类使用外部类的用法
                selfThread=new Thread(Counter3.this);
                selfThread.start();
            }
        }
    }
    class OnOffL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(selfThread!=null){
                runFlag=!runFlag;
            }
        }
    }

    public static void main(String[] args) {
        Counter3 applet = new Counter3();
        Frame aFrame = new Frame("Counter3");
        aFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        aFrame.add(applet,BorderLayout.CENTER);
        aFrame.setSize(300,200);
        applet.init();
        applet.start();
        aFrame.setVisible(true);
    }
}
