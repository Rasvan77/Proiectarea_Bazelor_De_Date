import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DarkTheme
{
    public static void apply()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception ignored)
        {}

        Color bgPrincipal=new Color(18,18,22);
        Color bgInput=new Color(30,30,38);
        Color bgButon=new Color(37,99,235);
        Color bgButonApasat=new Color(29,78,216);
        Color textAlb=new Color(240,240,245);
        Color contur=new Color(60,62,75);

        Border borderInput=BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(contur,1),
                BorderFactory.createEmptyBorder(6,10,6,10)
        );
        Border borderButon=BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(59,130,246),1),
                BorderFactory.createEmptyBorder(7,16,7,16)
        );

        UIManager.put("Panel.background",bgPrincipal);
        UIManager.put("OptionPane.background",bgPrincipal);
        UIManager.put("OptionPane.messageForeground",textAlb);
        UIManager.put("Label.foreground",textAlb);

        UIManager.put("TextField.background",bgInput);
        UIManager.put("TextField.foreground",Color.WHITE);
        UIManager.put("TextField.caretForeground",Color.WHITE);
        UIManager.put("TextField.border",borderInput);

        UIManager.put("PasswordField.background",bgInput);
        UIManager.put("PasswordField.foreground",Color.WHITE);
        UIManager.put("PasswordField.caretForeground",Color.WHITE);
        UIManager.put("PasswordField.border",borderInput);

        UIManager.put("Button.background",bgButon);
        UIManager.put("Button.foreground",Color.WHITE);
        UIManager.put("Button.select",bgButonApasat);
        UIManager.put("Button.focus",new Color(0,0,0,0));
        UIManager.put("Button.border",borderButon);
        UIManager.put("Button.gradient",null);

        UIManager.put("ComboBox.background",bgInput);
        UIManager.put("ComboBox.foreground",textAlb);
        UIManager.put("ComboBox.selectionBackground",bgButon);
        UIManager.put("ComboBox.selectionForeground",Color.WHITE);

        UIManager.put("Table.background",bgInput);
        UIManager.put("Table.foreground",textAlb);
        UIManager.put("Table.gridColor",contur);
        UIManager.put("Table.selectionBackground",bgButon);
        UIManager.put("Table.selectionForeground",Color.WHITE);
        UIManager.put("TableHeader.background",new Color(26,27,34));
        UIManager.put("TableHeader.foreground",textAlb);

        UIManager.put("ScrollPane.background",bgPrincipal);
        UIManager.put("Viewport.background",bgPrincipal);
        UIManager.put("TitledBorder.titleColor",textAlb);
    }
}