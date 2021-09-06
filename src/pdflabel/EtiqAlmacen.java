package pdflabel;

import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.model.ZebraLabel;
import fr.w3blog.zpl.model.element.ZebraBarCode39;
import fr.w3blog.zpl.model.element.ZebraText;
import fr.w3blog.zpl.utils.ZebraUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EtiqAlmacen
        implements Initializable {


    @FXML
    private TextField nombre;
    @FXML
    private TextField dir1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    public void Imprimir() {
        ZebraLabel zebraLabel = new ZebraLabel(512, 312);
        zebraLabel.setDefaultZebraFont(ZebraFont.ZEBRA_ZERO);

        zebraLabel.addElement(new ZebraText(1, 60, nombre.getText(), 14));
        zebraLabel.addElement(new ZebraText(1, 160, dir1.getText(), 8));

        String Mess="";

        try {
            ZebraUtils.printZpl(zebraLabel, "ARKSCAN 2054A");
            Mess="Archivo enviado correctamente : ARKSCAN 2054A";

        } catch (Exception e) {

            Mess="Error de impresion.";

        }
        System.out.println(Mess);

    }

}
