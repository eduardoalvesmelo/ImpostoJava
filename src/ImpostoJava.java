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
        double ttlDeducao = getMaximoDeducao(getImpostoSalario(rendaAnual),getImpostoPrestacao(rendaAnualPrestacaoServico),getImpostoCapital(rendaAnualCapital));

        System.out.print("Gastos educacionais: ");
        double gastoEdu = sc.nextDouble();
        double gastoDedutivel = gastoMedico + gastoEdu;

        double impostoBrutoTotal = getImpostoSalario(rendaAnual) + getImpostoPrestacao(rendaAnualPrestacaoServico) + getImpostoCapital(rendaAnualCapital);
        double abatimento = 0.0;

        if ((gastoMedico + gastoEdu) >= ttlDeducao) {
            abatimento = ttlDeducao;
        } else {
            abatimento = (gastoMedico + gastoEdu);
        }

        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA\n");
        System.out.print("CONSOLIDADO DE RENDA:\n");
        System.out.printf("Imposto sobre salário: %.2f\n", getImpostoSalario(rendaAnual));
        System.out.printf("Imposto sobre serviços: %.2f\n",getImpostoPrestacao(rendaAnualPrestacaoServico));
        System.out.printf("Imposto sobre ganho de capital: %.2f\n",getImpostoCapital(rendaAnualCapital));
        System.out.println();
        System.out.println("DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f\n",ttlDeducao);
        System.out.printf("Gastos dedutíveis: %.2f:\n",gastoDedutivel);
        System.out.println();
        System.out.println("RESUMO:");
        System.out.printf("Imposto bruto total: %.2f\n",impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f:\n",abatimento);
        System.out.printf("Imposto devido: %.2f:\n",impostoBrutoTotal-abatimento);
    }

    public static double getImpostoSalario(double salario){
        double salMensal = salario / 12;
        if (salMensal <= 3000.0) {
            return salario * 0;
        } else if (salMensal > 3000.0 && salMensal <= 5000.0) {
            return salario * 0.1;
        } else {
            return salario * 0.2;
        }
    }

    public static double getImpostoPrestacao(double salPrestacao){
        if (salPrestacao > 0) {
            return salPrestacao * 0.15;
        }
        return 0;
    }

    public static double getImpostoCapital(double salCapital){
        if (salCapital > 0) {
            return salCapital * 0.2;
        }
        return 0;
    }

    public static double getMaximoDeducao(double impostoSalario, double impostoServico, double impostoCapital) {
        double impostoTotal = impostoSalario + impostoServico + impostoCapital;
        return impostoTotal * 0.3;
    }

}
