package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mj4ExLogin extends JFrame implements ActionListener {

    JLabel lblJikNo, lblJikName;
    JButton btnLog;
    JTextField txtJikNo, txtJikName;
    JTextArea txtArea;

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    String sql = "";

    public mj4ExLogin() {
        super("로그인");

        layoutInit();
        condb();

        setBounds(200, 300, 600, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            txtArea.setText(null);
            String url = "jdbc:mariadb://localhost:3306/mydb";
            conn = DriverManager.getConnection(url, "root", "123");

            //////유효성 검사/////
            String txtNo = txtJikNo.getText();
            String txtName = txtJikName.getText();

            //입력칸 빈칸 유무
            if (txtNo.equals("")) {
                JOptionPane.showMessageDialog(this, "사번을 입력하세요");
                txtJikNo.requestFocus();
                return;
            }
            if (txtJikName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "이름을 입력하세요");
                txtJikName.requestFocus();
            }

            //로그인
            int loginRes = login(txtNo, txtName);

            if (loginRes == 1) { //로그인 성공시
                // 전체 직원 이름 가져오기
                sql = "select jikwon_no 사번, jikwon_name 직원명,jikwon_pay 연봉,jikwon_jik 직급,jikwon_rating 평가 from jikwon";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                //결과 출력
                txtArea.append("전체 직원\n");
                while (rs.next()) {
                    txtArea.append(rs.getString("사번") + "\t" +
                            rs.getString("직원명") + "\t" +
                            rs.getString("연봉") + "\t" +
                            rs.getString("직급") + "\t" +
                            rs.getString("평가") + "\n");
                }
                //직급별 연봉평균
                txtArea.append("\n\n직급별 연봉 평균\n");
                sql = "select jikwon_jik 직급, Avg(jikwon_pay) as 평균  from jikwon group by jikwon_jik order by 직급";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    String imsi = rs.getString("직급") + " : " +
                            rs.getString("평균") + "    ";
                    txtArea.append(imsi);
                }

            } else if (loginRes == 0) {
                txtArea.setText(null);
                JOptionPane.showMessageDialog(this, "로그인에 실패했습니다.");
            } else if(loginRes == -1) {
                txtArea.setText(null);
                JOptionPane.showMessageDialog(this, "직원이 아닙니다.");
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, "actionPerformed err: ");
            System.out.println("actionPerformed err : " + e);
        }
    }

    private int login(String txtJikNo, String txtJikName) {
        try {
            String okSql = "select jikwon_name from jikwon where jikwon_no = ?";

            pstmt = conn.prepareStatement(okSql);
            pstmt.setString(1, txtJikNo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getString(1).equals(txtJikName)) { // 로그인 성공
                    return 1;
                } else {
                    return 0;
                }
            }
            return -1; //번호가 없음
        } catch (Exception e1) {
            System.out.println("login err : " + e1);
        }
        return 2; // DB sql err
    }

    private void layoutInit() { //lblJikNo, lblJikName //txtJikNo, txtJikName
        JPanel panel = new JPanel();

        lblJikNo = new JLabel("직원번호 : ");
        txtJikNo = new JTextField("", 6);

        lblJikName = new JLabel("이름 : ");
        txtJikName = new JTextField("", 6);

        btnLog = new JButton("로그인");

        panel.add(lblJikNo);
        panel.add(txtJikNo);
        panel.add(lblJikName);
        panel.add(txtJikName);
        panel.add(btnLog);
        add("North", panel);
        btnLog.addActionListener(this);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        add(txtArea);

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(txtArea);
        add(scroll);

    }

    private void condb() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("addDb err : " + e);
        }
    }

    public static void main(String[] args) {
        new mj4ExLogin();
    }

}