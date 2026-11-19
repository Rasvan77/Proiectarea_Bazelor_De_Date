import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JFrame
{
    private JTextField txtNume;
    private JPasswordField txtCnp;
    private JButton btnIntra;

    public LoginForm()
    {
        //Configurare fereastra;
        setTitle("Casa de Schimb Valutar - Autentificare");
        setSize(420,260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel=new JPanel(new GridBagLayout());

        //Init gbc, il folosesc pentru a arata si a plasa fiecare element de care am nevoie;
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(8,8,8,8); //Spatiere intre elemente.

        JLabel lblTitlu=new JLabel("Casa de Schimb Valutar",SwingConstants.CENTER);
        lblTitlu.setFont(new Font("New Times Roman",Font.CENTER_BASELINE,18));

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        mainPanel.add(lblTitlu,gbc);

        gbc.gridwidth=1;
        gbc.gridy=1;
        gbc.gridx=0;
        mainPanel.add(new JLabel("Nume Angajat:"),gbc);

        txtNume=new JTextField(15);
        gbc.gridx=1;
        mainPanel.add(txtNume,gbc);

        gbc.gridy=2;
        gbc.gridx=0;
        mainPanel.add(new JLabel("CNP (Parola):"),gbc);

        txtCnp=new JPasswordField(15);
        gbc.gridx=1;
        mainPanel.add(txtCnp,gbc);

        btnIntra=new JButton("Autentificare");
        gbc.gridy=3;
        gbc.gridx=0;
        gbc.gridwidth=2;
        mainPanel.add(btnIntra,gbc);

        btnIntra.addActionListener(e->autentifica());

        setContentPane(mainPanel);
        setVisible(true);
    }

    private void autentifica(){
        String nume=txtNume.getText().trim();
        String cnp=new String(txtCnp.getPassword()).trim();

        if(nume.isEmpty()||cnp.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Completeaza Numele si CNP-ul!","Atentie",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql="SELECT Id_Angajat,Nume,Prenume,Functie,Id_Ghiseu FROM ANGAJAT WHERE Nume=? AND CNP_Angajat=?";
        try(Connection conn=DatabaseConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1,nume);
            ps.setString(2,cnp);

            try(ResultSet rs=ps.executeQuery())
            {
                if(rs.next())
                {
                    int idAngajat=rs.getInt("Id_Angajat");
                    String numeComplet=rs.getString("Nume")+" "+rs.getString("Prenume");
                    String functie=rs.getString("Functie");
                    int idGhiseu=rs.getInt("Id_Ghiseu");

                    if("Casier".equalsIgnoreCase(functie))
                    {
                        new CasierForm(idAngajat,numeComplet,idGhiseu);
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Autentificat ca "+functie+". Panoul Manager urmeaza sa fie adaugat!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Nume sau CNP incorect!","Eroare autentificare",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this,"Eroare baza de date: "+ex.getMessage(),"Eroare SQL",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args)
    {
        DarkTheme.apply();
        SwingUtilities.invokeLater(()->new LoginForm());
    }
}