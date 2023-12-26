import java.util.Locale;
import java.util.Scanner;

public class ImpostoJava {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        double rendaAnual = sc.nextDouble();

        System.out.print("Renda anual com prestação de serviço: ");
        double rendaAnualPrestacaoServico = sc.nextDouble();

        System.out.print("Renda anual com ganho de capital: ");
        double rendaAnualCapital = sc.nextDouble();

        System.out.print("Gastos médicos: ");
        double gastoMedico = sc.nextDouble();

        System.out.print("Gastos educacionais: ");
        double gastoEdu = sc.nextDouble();

        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA\n");
        System.out.print("CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f",getImpostoSalario(rendaAnual));
        System.out.print("CONSOLIDADO DE RENDA:");
        System.out.print("CONSOLIDADO DE RENDA:");
    }

    public static double getImpostoSalario(double salario){
        double imposto = 0;
        if (salario <= 3000.0) {
            return imposto = 0;
        } else if (salario > 3000.0 && salario <= 5000.0) {
            return imposto = 1.1;
        } else {
            return imposto = 1.2;
        }
    }

    public double getImpostoPrestacao(double salPrestacao){
        if (salPrestacao > 0) {
            return 1.15;
        }
        return 0;
    }

    public double getImpostoCapital(double salCapital){
        if (salCapital > 0) {
            return 1.20;
        }
        return 0;
    }

}
