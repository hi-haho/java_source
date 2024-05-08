package pack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class mj3ExGogek extends JFrame implements ActionListener {
    Connection  conn;
    PreparedStatement pstmt;
    ResultSet rs;

    JButton btnOk;
    JLabel lblName, lbljum; // 고객명, 주민번호
    JTextField txtName, txtJuF, txtJuL; //고객명, 주민앞, 주민뒤
    JTextArea txtArea = new JTextArea();


    public mj3ExGogek(){
        super("담당자 찾기");

        layoutInit();
        adddb();

        setBounds(200,300,500,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            txtArea.setText(null);
            String url="jdbc:mariadb://localhost:3306/mydb";
            conn = DriverManager.getConnection(url,"root","123");

            String sql = "";

            //직원 정보
            // 열이름 가져오기 txtName, txtJuF, txtJuL
            sql = "select jikwon_no,jikwon_name,buser.buser_name, buser.buser_tel, jikwon_jik from jikwon ,buser where buser_no = buser_num and jikwon_no = (select gogek_damsano from gogek where gogek_damsano = (select jikwon_no from jikwon where gogek_damsano = jikwon_no and gogek_name = '박상운' and gogek_jumin = '790623-1023777'))";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,txtName.getText());
            pstmt.setString(2,txtJuF.getText());
            pstmt.setString(3,txtJuL.getText());
            rs = pstmt.executeQuery();

            //유효성 검사
            int juminF,juminL;
            String gogekN;
            //입력 확인
            if (txtName.getText().equals("")){
                JOptionPane.showMessageDialog(this,"이름을 입력하세요.");
                txtName.requestFocus();
                return;
            }
            if (txtJuF.getText().equals("") ||txtJuL.getText().equals("")){
                JOptionPane.showMessageDialog(this,"주민번호을 입력하세요.");
                txtJuF.requestFocus();
                return;
            }
            if (txtJuF.getText().length() != 6 ||txtJuL.getText().length() != 7 ){
                JOptionPane.showMessageDialog(this,"주민 번호를 입력하세요.");
                txtJuF.setText("");
                txtJuL.setText("");
                txtJuF.requestFocus();
                return;
            }
            //주민번호 숫자 확인
            try {
            juminF = Integer.parseInt(txtJuF.getText());
            juminL = Integer.parseInt(txtJuL.getText());
            }catch (NumberFormatException e2){
                JOptionPane.showMessageDialog(this,"주민 번호를 입력하세요.");
                txtJuF.setText("");
                txtJuL.setText("");
                txtJuF.requestFocus();
            }

            //결과 출력
            txtArea.append("담당 직원 정보\n");

            if (rs.next()){ //jikwon_no,jikwon_name,buser.buser_name, buser.buser_tel, jikwon_jik
                String imsi = rs.getString(1)+"\t"+
                        rs.getString(2)+"\t"+
                        rs.getString(3)+"\t"+
                        rs.getString(4)+"\t"+
                        rs.getString(5)+"\n";
                txtArea.append(imsi);
            }
        }catch (Exception e2){
            System.out.println("Db server conn err : "+e2);
        }
    }

    private void layoutInit(){
        // JLabel lblName, lbljum
        // txtName, txtJuF, txtJuL; //고객명, 주민앞, 주민뒤
        setLayout(new GridLayout(2,1));

        JPanel panel1 = new JPanel();
        lblName = new JLabel("이름: ");
        txtName = new JTextField("",10);
        panel1.add(lblName);
        panel1.add(txtName);
        add("N",panel1);

        JPanel panel2 = new JPanel();
        lbljum = new JLabel("주민번호: ");
        txtJuF = new JTextField("",6);
        txtJuL = new JTextField("",6);
        btnOk = new JButton("확인");
        panel2.add(lbljum);
        panel2.add(txtJuF);
        panel2.add(txtJuL);
        panel2.add(btnOk);
        add(panel2);
        btnOk.addActionListener(this);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2,1));
        panel3.add(panel1);
        panel3.add(panel2);
        add(panel3);

        txtArea.setEditable(false);
        add(txtArea);
    }

    private void adddb(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println("addDb err : "+ e);
        }
    }

    public static void main(String[] args) {
        new mj3ExGogek();
    }
}