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

public class EtiqEnvio
        implements Initializable {

    String LogoInstagram;
    String LogoFlecha;
    String LogoMail;
    String LogoGhia;

    @FXML
    private TextField nombre;
    @FXML
    private TextField dir1;
    @FXML
    private TextField dir2;
    @FXML
    private TextField dir3;
    @FXML
    private TextField dir4;
    @FXML
    private TextField dir5;
    @FXML
    private TextField orden;
    @FXML
    private Label estado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LogoInstagram="^FO250,165^GFA,104,104,4,3KF,7KF8,CK0C,CI01CC,CI01EC,CI036C,C01E1EC,C07F88C,C0C0C0C,C18060C,C10020C,C30030C,:::C10020C,C18060C,C0C0C0C,C07F80C,C01E00C,CK0C,:::7KF8,3KF,^FS";
        LogoFlecha="^FO250,125^GFA,100,100,4,,L01,J03FF,I03FFE,:I01FFE,J07FE,J0FFC,I01FFC,I03FFC,I07FFC,I0IF8,001FF38,003FC38,00FF81,01FF,03FE,07FC,0FF8,1FF,3FE,3F8,1F,0E,04,^FS";
        LogoMail="^FO250,80^GFA,54,54,3,,7JFE7J0E7I01E5800364C00664600C643018641830641C706437D864638C64C00665800367I01E7J0E7JFE,^FS";
        LogoGhia="^FO50,60^GFA,2016,2016,21,,::T06P01C,:::::::T06,:::::::::::::T06I07FL0CL01FCJ0E,J01FF8I07806003FFEJ01CK01IFCI0E,J0JF800780600JF8I01CK07JF800E,I07JFE00780603F01FCI01CJ01FF03FE00E,I0FF007F80780607C003FI01CJ07FI03F80E,003F8I0FE078060FJ0F8001CJ0FCJ0FC0E,007EJ01F078061EJ07C001CI01FK03E0E,00F8K0F878063CJ01C001CI03EL0F0E,01FL03C780678K0E001CI078L078E,03CL01E78067L0F001CI0FM03CE,078M0F7806EL07001C001EM01EE,0F8M07F807CL03801C001EN0EE,0FN03F807CL03801C003CN0FE,1EN03F8078L01C01C0038N07E,1CN01F8078L01C01C0078N03E,3CN01F807N0C01C007O03E,38O0F807N0E01C00FO01E,38O0F807N0E01C00EO01E,78O07806N0E01C00EO01E,7P07806N0E01C01EP0E,7P07806N0601C01CP0E,:::7P03806N0601C01CP0E,7P07806N0601C01CP0E,::7P07806N0601C01EP0E,78O07806N0601C00EO01E,78O0F806N0601C00EO01E,38O0F806N0601C00EO01E,3CO0F806N0601C00FO03E,1CN01F806N0601C007O03E,1EN01F806N0601C0078N07E,0EN03F806N0601C0038N07E,0FN07F806N0601C003CN0FE,078M0F7806N0601C001EM01EE,03CL01E7806N0601CI0FM01CE,01EL03C7806N0601CI0F8L03CE,00FL0787806N0601CI07CL0F8E,007CJ01F07806N0601CI03EK01F0E,003FJ07E07806N0601CI01F8J07E0E,001FE001FC07806N0601CJ07EJ0F80E,I07KF007806N0601CJ03FC007F00E,I01JFC007806N0601CK0KFC00E,J03FFEI078R01CK03JFI0E,Q078R01CL07FFJ0E,Q078R01C,Q078,::Q07,:Q0F,Q0E,P01EN06,:P03CN06,P078K0C006003I0C0060030018,P078J013006004C0160090048024,P0FK021006008401I08008C03,O03EK021006008400C006008001C,O07CK023006008C002001008I04,O0F8K01F006007C01C00F007803C,N03FM01,M01FEL033,L03FF8L01C,L03FE,L03F,,^FS";


    }

    public void ImprimirEtiqueta() {

        String zpl="^XA"+LogoInstagram+LogoFlecha+LogoMail+LogoGhia+
                "^CFC,60"+
                //"^FO250,50^FDGhia Glasses^FS" +
                "^CF0,30" +
                "^FO290,80" +
                "^FDsales@ghiaglassess.com^FS" +
                "^FO290,120^FDwww.ghiaglasses.com^FS" +
                "^FO290,160^FDghiaglasses^FS" +
                "^CF0,30" +
                "^FO50,250" +
                "^GB700,3,3^FS" +
                "^CF0,30" +
                "^FO50,275^FDShip To^FS" +
                "^FO50,320^FD"+nombre.getText().toString()+"^FS" +
                "^FO50,360^FD"+dir1.getText().toString()+"^FS" +
                "^FO50,390^FD"+dir2.getText().toString()+"^FS" +
                "^FO50,430^FD"+dir3.getText().toString()+"^FS" +
                "^FO50,470^FD"+dir4.getText().toString()+"^FS" +
                "^FO50,510^FD"+dir5.getText().toString()+"^FS" +
                "^CFA,15" +
                "^FO638,270^FDOrder ^FS"+
                "^FO638,300^FD"+orden.getText().toString()+"^FS"+
                "^FO50,550^GB700,3,3^FS"+
                "^XZ";



        String Mess="";

        try {
            ZebraUtils.printZpl(zpl, "ARKSCAN 2054A");
            Mess="Archivo enviado correctamente : ARKSCAN 2054A";

        } catch (Exception e) {

            Mess="Error de impresion.";

        }
        estado.setText("Resultado del Proceso: "+Mess);


    }

}
