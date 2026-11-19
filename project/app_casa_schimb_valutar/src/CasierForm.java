import javax.swing.*;
import java.awt.*;

public class CasierForm extends JFrame
{
    private int idAngajat;
    private String numeComplet;
    private int idGhiseu;
    private CardLayout cardLayout;
    private JPanel paginiPanel;

    public CasierForm(int idAngajat,String numeComplet,int idGhiseu)
    {
        this.idAngajat=idAngajat;
        this.numeComplet=numeComplet;
        this.idGhiseu=idGhiseu;

        setTitle("Casa de Schimb Valutar - Panou Casier");
        setSize(950,620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel=new JPanel(new BorderLayout());

        JPanel topBar=new JPanel(new BorderLayout());
        topBar.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
        topBar.setBackground(new Color(45,52,64));

        JLabel lblInfo=new JLabel("Casier: "+numeComplet+" | Ghiseu ID: "+idGhiseu);
        lblInfo.setForeground(Color.WHITE);
        lblInfo.setFont(new Font("Segoe UI",Font.BOLD,14));
        topBar.add(lblInfo,BorderLayout.WEST);

        JPanel menuButtonsPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        menuButtonsPanel.setOpaque(false);

        JButton btnDeconectare=new JButton("Deconectare");
        JButton btnTransfer=new JButton("Seif & Transfer");
        JButton btnSituatie=new JButton("Cursuri & Sold");
        JButton btnSchimb=new JButton("Schimb Valutar");

        menuButtonsPanel.add(btnDeconectare);
        menuButtonsPanel.add(btnTransfer);
        menuButtonsPanel.add(btnSituatie);
        menuButtonsPanel.add(btnSchimb);

        topBar.add(menuButtonsPanel,BorderLayout.EAST);
        mainPanel.add(topBar,BorderLayout.NORTH);

        cardLayout=new CardLayout();
        paginiPanel=new JPanel(cardLayout);

        paginiPanel.add(creeazaPagina("Pagina 1: Schimb Valutar"),"SCHIMB");
        paginiPanel.add(creeazaPagina("Pagina 2: Cursuri si Sold Ghiseu"),"SITUATIE");
        paginiPanel.add(creeazaPagina("Pagina 3: Seif si Transfer Sucursale"),"TRANSFER");

        btnSchimb.addActionListener(e->cardLayout.show(paginiPanel,"SCHIMB"));
        btnSituatie.addActionListener(e->cardLayout.show(paginiPanel,"SITUATIE"));
        btnTransfer.addActionListener(e->cardLayout.show(paginiPanel,"TRANSFER"));

        btnDeconectare.addActionListener(e->{
            new LoginForm();
            dispose();
        });

        mainPanel.add(paginiPanel,BorderLayout.CENTER);
        setContentPane(mainPanel);
        setVisible(true);
    }

    private JPanel creeazaPagina(String titlu)
    {
        JPanel panel=new JPanel(new GridBagLayout());
        JLabel lbl=new JLabel(titlu);
        lbl.setFont(new Font("Segoe UI",Font.BOLD,20));
        panel.add(lbl);
        return panel;
    }
}