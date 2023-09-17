package com.aaa;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GameJFrame extends JFrame implements KeyListener {
    int[][] data = new int[4][4];
    int x = 0;
    int y = 0;
    public GameJFrame() {
        initJFrame();

        initJMenuBar();

        initData();

        initImage();

        setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for (int i=0;i<tempArr.length;i++){
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;

        }

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i]==0){
              x=i/4;
              y=i%4;
                System.out.print(i/4+"  "+i%4);
            }
            else {
                data[i/4][i%4] = tempArr[i];
            }

        }

    }

    private void initJFrame(){
        setSize(603,680);
        setTitle("拼图");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        addKeyListener(this);
    }
    private void initJMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于");
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);


        setJMenuBar(jMenuBar);
    }
    private void initImage(){

        this.getContentPane().removeAll();
    for (int j=0;j<4;j++){
        for (int i=0;i<4;i++){
            int num = data[j][i];
            JLabel jLabel = new JLabel(new ImageIcon("image\\animal\\animal3\\"+num+".jpg"));
            jLabel.setBounds(105*i+83,105*j+134,105,105);
            jLabel.setBorder(new BevelBorder(1));
            getContentPane().add(jLabel);

        }

    }
        ImageIcon bg = new ImageIcon("image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40,40,508,560);
        getContentPane().add(background);

        this.getContentPane().repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code==37){
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            initImage();
        } else if (code==38){
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            initImage();
        } else if (code==39) {
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            initImage();
        } else if (code==40) {
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            initImage();
        }
    }
}
