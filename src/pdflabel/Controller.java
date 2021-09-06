package pdflabel;

import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.model.ZebraLabel;
import fr.w3blog.zpl.model.element.ZebraBarCode39;
import fr.w3blog.zpl.model.element.ZebraText;
import fr.w3blog.zpl.utils.ZebraUtils;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.net.URL;
import java.util.*;

import static javafx.collections.FXCollections.observableArrayList;

public class Controller implements Initializable {

    ObservableList<Producto> lista = observableArrayList();

    @FXML
    private TableView<Producto> table = new TableView<Producto>();

    @FXML
    private Pane principal;

    @FXML
    private Label archivo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {





        TableColumn colbarra = new TableColumn("Barra");
        colbarra.setMinWidth(100);
        colbarra.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("barra"));

        TableColumn coldescrip = new TableColumn("Descripción");
        coldescrip.setMinWidth(300);
        coldescrip.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("descrip"));

        TableColumn select = new TableColumn("Imprimir");
        select.setMinWidth(50);
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Producto, CheckBox>,
                        ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue<CheckBox> call(
                    TableColumn.CellDataFeatures<Producto, CheckBox> arg0) {
                Producto user = arg0.getValue();

                CheckBox checkBox = new CheckBox();

                checkBox.selectedProperty().setValue(user.isImprimir());

                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {

                        user.setImprimir(new_val);


                    }
                });

                return new SimpleObjectProperty<CheckBox>(checkBox);

            }

        });


        table.getColumns().addAll(colbarra,coldescrip,select);
        table.setItems(lista);



    }

    public void getTheUserFilePath() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Carga de archivo PDF");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
        );


        File file = fileChooser.showOpenDialog(principal.getScene().getWindow());

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            //pickUpPathField.setText(file.getPath());
             archivo.setText(file.getPath()+"\\"+file.getName()+" procesando...");

             leerPdf(file);
        } else  {
            System.out.println("error");
        }

    }

    private void leerPdf(File file) {

        try {
            PDDocument document = PDDocument.load(file);

            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            procesar(text);
            //System.out.println(text);



            document.close();
        } catch (Exception e) {

        }


    }

    private void procesar(String Lineas) {
        //System.out.print(Lineas);
        StringTokenizer items = new StringTokenizer(Lineas);

        StringBuilder descrip=new StringBuilder();
        String barra="";
        while (items.hasMoreElements()) {

            String texto = items.nextToken();
            if (barra.length()==0) barra=texto;

            if (texto.contains("Nuevo")) {

                lista.add(new Producto(barra,descrip.toString(),true));
                System.out.print(barra);
                System.out.print("-" +descrip);
                System.out.println();
                descrip = new StringBuilder();
                barra=items.nextToken();
            } else {
                if (!texto.equals(barra)) {
                    descrip.append(texto + " ");
                }
            }

        }

    }

    public void PruebaImp() {

        String zpl="^XA" +
                "^CF0,60" +
                "^FO50,50^GB100,100,100^FS" +
                "^FO75,75^FR^GB100,100,100^FS" +
                "^FO93,93^GB40,40,40^FS" +
                "^FO220,50^FDInvestment Global Nac^FS" +
                "^CF0,30" +
                "^FO50,210^GB700,3,3^FS" +

                "^CFA,30" +
                "^FO50,220^FDShip To^FS" +
                "^FO50,300^FDEdward Gomez^FS" +
                "^FO50,340^FDCorapal Caraballeda ^FS" +
                "^FO50,380^FDLa Guaira 1165^FS" +
                "^FO50,420^FDVerezuela^FS" +
                "^CFA,15" +
                "^FO600,300^GB150,150,3^FS" +
                "^FO638,340^FDGhia^FS" +
                "^FO638,390^FD123456^FS" +
                "^FO50,500^GB700,3,3^FS" +
                "^XZ";

        ZebraLabel zebraLabel = new ZebraLabel(912, 912);
        zebraLabel.setDefaultZebraFont(ZebraFont.ZEBRA_ZERO);

        zebraLabel.addElement(new ZebraText(10, 84, "GlobalNac:", 14));
        zebraLabel.addElement(new ZebraText(395, 85, "Direccion", 14));

        zebraLabel.addElement(new ZebraText(10, 161, "CA201212AA", 14));

        //Add Code Bar 39
        zebraLabel.addElement(new ZebraBarCode39(10, 297, "CA201212AA", 118, 2, 2));

        String Mess="";

        try {
            ZebraUtils.printZpl(zpl, "ARKSCAN 2054A");

            Mess="Archivo enviado correctamente : ARKSCAN 2054A";

        } catch (Exception e) {

            Mess="Error de impresion.";

        }
        archivo.setText("Resultado del Proceso: "+Mess);


    }




}
