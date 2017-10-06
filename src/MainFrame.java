import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private Container cp;
    private JPanel jp = new JPanel(new GridLayout(9,1,3,3));
    private JTextArea jtL = new JTextArea();
    private JTextArea jtR = new JTextArea();
    private JScrollPane jscL = new JScrollPane(jtL);
    private JScrollPane jscR = new JScrollPane(jtR);
    private JButton jbtnExam = new JButton("Example");
    private JButton jbtnEncr = new JButton("Encryption");
    private JButton jbtnCecr = new JButton("Decrypted");
    private JButton jbtnClear = new JButton("Clear");
    private JButton jbtnClearL = new JButton("Clear Left");
    private JButton jbtnClearR = new JButton("Clear Right");
    private JButton jbtnExit = new JButton("Exit");
    private JTextField jtKey = new JTextField();
    private JLabel jlab = new JLabel("Key");
    public MainFrame(){
        init();
    }
    public void init(){
        this.setBounds(100,100,600,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Wang Jia En");
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jp,BorderLayout.CENTER);
        cp.add(jscL,BorderLayout.WEST);
        cp.add(jscR,BorderLayout.EAST);
        jtL.setLineWrap(true);
        jtR.setLineWrap(true);
        jtL.setPreferredSize(new Dimension(200,700));
        jtR.setPreferredSize(new Dimension(200,700));
        jp.add(jbtnExam);
        jp.add(jbtnEncr);
        jp.add(jlab);
        jp.add(jtKey);
        jp.add(jbtnClear);
        jp.add(jbtnClearL);
        jp.add(jbtnClearR);
        jp.add(jbtnCecr);
        jp.add(jbtnExit);

        //contor set
        jbtnExam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtL.setText("The curriculum provided by this department includes basic courses, " +
                        "core curriculums, major programs and free electives giving the curriculum design richness and diversity. " +
                        "Courses such as “Mobile and Internet Application”, “Semi-conductor Systems”, “" +
                        "Big Data Analytics”, and “Artificial Intelligence” " +
                        "stand out and are highly practical. Students can choose courses depending on " +
                        "their interests or take courses from other departments to work towards a double major to " +
                        "develop their professional ability and second skill.");
            }
        });

        jbtnEncr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = jtL.getText().toCharArray();
                int len = data.length;
                //Key = Integer.parseInt(jtKey.getText());
                char Key[] = jtKey.getText().toCharArray();
                int Keylen = Key.length;
                for(int i = 0;i<len;i++){
                    for(int j = 0;j<Keylen;j++){
                        data[i]^=Key[j];
                    }
                    jtR.setText(new String(data));
                }

            }
        });

        jbtnCecr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = jtR.getText().toCharArray();
                int len = data.length;
                //Key = Integer.parseInt(jtKey.getText());
                char Key[] = jtKey.getText().toCharArray();
                int Keylen = Key.length;
                for(int i = 0;i<len;i++){
                    for(int j = 0;j<Keylen;j++){
                        data[i]^=Key[j];
                    }
                    jtL.setText(new String(data));
                }

            }
        });

        jbtnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtL.setText(" ");
                jtR.setText(" ");
                jtKey.setText(" ");
            }
        });

        jbtnClearL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtL.setText(" ");
            }
        });

        jbtnClearR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtR.setText(" ");
            }
        });

        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
