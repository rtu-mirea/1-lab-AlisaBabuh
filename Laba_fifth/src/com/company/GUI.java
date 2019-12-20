package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

//Регистрация
//Вход
//Выход

//Гл.окно
public class GUI {
    public void Menu(){
        JFrame frame = new JFrame("Меню");
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setSize(300, 110);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Регистрация");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b2 = new JButton("Вход");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b3 = new JButton("Выход");
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b3.setForeground(Color.blue);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration();
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Authorization();
                frame.dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
//РЕГИСТРАЦИЯ
    public void Registration(){
        JFrame frame = new JFrame("Регистрация");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Имя");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Логин");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Пароль");
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l3.setForeground(Color.blue);
        l3.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t3 = new JTextField(10);
        t3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t3.setForeground(Color.blue);
        t3.setAlignmentX(Component.LEFT_ALIGNMENT);
        p3.add(l3);
        p3.add(t3);

        JPanel p4 = new JPanel();
        JButton b1 = new JButton("Зарегистрироваться");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean repeat = false;
                String name = t1.getText();
                String login = t2.getText();
                for (User user : PizzaSystem.users){
                    if (user.getLogin().compareTo(login) == 0){
                        JOptionPane.showMessageDialog(null, "Этот логин уже занят");
                        repeat = true;
                        break;
                    }
                }
                if(repeat)
                    return;
                String password = t3.getText();
                User a = new User(name, login, password);
                PizzaSystem.users.add(a);
                frame.dispose();
                Menu();
            }
        });
        p4.add(b1);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);

        frame.add(panel);

        frame.setVisible(true);
    }

    //АВТОРИЗАЦИЯ
    public void Authorization(){
        JFrame frame = new JFrame("Авторизация");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Логин");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Пароль");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JButton b1 = new JButton("Войти");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PizzaSystem.currentUser = null;
                String login = t1.getText();
                String password = t2.getText();
                for (User user : PizzaSystem.users){
                    if (user.enter(login, password)){
                        PizzaSystem.currentUser = user;
                    }
                }
                if (PizzaSystem.currentUser == null){
                    JOptionPane.showMessageDialog(null, "Неверно введен логин или пароль");
                    frame.dispose();
                    Menu();
                    return;
                }
                if (PizzaSystem.currentUser.getClass().getName().compareTo("com.company.Admin") == 0){
                    frame.dispose();
                    Admin();
                }else{
                    frame.dispose();
                    User();
                }
            }
        });
        p3.add(b1);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);

        frame.add(panel);

        frame.setVisible(true);
    }

    public void Admin(){
        JFrame frame = new JFrame("Админ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 400);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Добавить узел");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b2 = new JButton("Найти кратчайший путь");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b3 = new JButton("Выход");
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b3.setForeground(Color.blue);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] tables = {"Имя", "Логин", "Пароль"};
        String[][] data = new String[PizzaSystem.users.size()][3];
        int i = 0;
        for (User u : PizzaSystem.users){
            data[i][0] = u.getName();
            data[i][1] = u.getLogin();
            data[i][2] = u.getPassword();
            i++;
        }
        JTable t = new JTable(data, tables);
        t.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t.setForeground(Color.blue);
        t.setAlignmentX(Component.LEFT_ALIGNMENT);
        t.setPreferredScrollableViewportSize(t.getPreferredSize());
        t.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(t);

        b1.addActionListener(new ActionListener() { //Добавить узел
            @Override
            public void actionPerformed(ActionEvent e) {
                createYzel();
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener() { //Найти кратчайший путь
            @Override
            public void actionPerformed(ActionEvent e) {
                Map m = new Map();
                m.generateShortWay();
            }
        });

        b3.addActionListener(new ActionListener() { //Выход
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu();
            }
        });

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(sp);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void User(){
        JFrame frame = new JFrame("Пользователь");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Сформировать заказ на пиццу");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b2 = new JButton("Выход");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() { //Сформировать заказ
            @Override
            public void actionPerformed(ActionEvent e) {
                createZakaz(); //Создание узла
                frame.dispose();
            }
        });


        b2.addActionListener(new ActionListener() { //Выход
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu();
            }
        });
        panel.add(b1);
        panel.add(b2);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    public void createYzel(){
        JFrame frame = new JFrame("Создать узел");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Точка А:");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Точка В:");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JButton b1 = new JButton("Создать");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map map = new Map();
                Client client = new Client();


                String A = t1.getText();
                String B= t2.getText();

                map.get_shortest_way(A,B);
                frame.dispose();
                Admin();
            }
        });
        p3.add(b1);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);

        frame.add(panel);

        frame.setVisible(true);
    }


    public void createZakaz(){
        JFrame frame = new JFrame("Сделать заказ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Введите место:");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Введите время:");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JButton b1 = new JButton("Отправить");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map map = new Map();
                Client client = new Client();


                String place1 = t1.getText();
                String time= t2.getText();

                map.addPath(place1,client.getPlace(), parseInt(time));
                frame.dispose();
                User();
            }
        });
        p3.add(b1);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);

        frame.add(panel);

        frame.setVisible(true);
    }
}
