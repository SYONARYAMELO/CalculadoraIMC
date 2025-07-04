import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class ProjetoCalculadoraIMC extends Application{
    @Override
    public void start(Stage palco){

        //Etiquetas para campos de entrada
        Label etiquetaPeso = new Label("Peso");
        Label etiquetaAltura = new Label("Altura");

        //Campos de texto para entrada de dados
        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em Kg");
        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em metros");

        //Label para mostrar o resultado do IMC
        Label etiquetaResultado = new Label();

        //Botao para calcular IMC
        Button botaoCalcular = new Button("Calcular IMC");
        botaoCalcular.setOnAction(e -> {
            try {
                double peso = Double.parseDouble(campoPeso.getText().replace(',' , '.'));
                double altura = Double.parseDouble(campoAltura.getText().replace(',' , '.'));

                double imc = peso / (altura * altura);
                String classificacao = classificarIMC(imc);
                etiquetaResultado.setText(String.format("Seu imc é: %.2f\n Classificacao: %s", imc, classificacao));
            }catch (NumberFormatException ex) {
                etiquetaResultado.setText("Por favor, insira numeros válidos para peso e altura.");
            }
        });

        //Layout vertical
        VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        //CENA E PALCO
        Scene cena = new Scene(layout, 350,350);
        palco.setTitle("Calculadora de IMC");
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Método que retorna a classificação do IMC
    private String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau 1";
        } else if (imc < 40) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3 (mórbida)";
        }
    }
}


