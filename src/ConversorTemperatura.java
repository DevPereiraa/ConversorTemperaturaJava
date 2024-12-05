import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean NovaMedida = true;

        while (NovaMedida){
        System.out.println("Digite o valor da temperatura: ");
        double temperatura = sc.nextDouble();

        System.out.println("Digite a unidade atual (C/F/K/R): ");
        char unidadeAtual = sc.next().toUpperCase().charAt(0);

        System.out.println("Diigite a unidade para conversão (C/F/K/R): ");
        char unidadeParaConversao = sc.next().toUpperCase().charAt(0);

        double resultado = conversorTemperatura(temperatura, unidadeAtual, unidadeParaConversao);

        if (Double.isNaN(resultado)) {
            System.out.println("Conversão inválida. Verifique as unidades inseridas.");
        } else {
            System.out.printf("A temperatura convertida é: %.2f %c\n", resultado, unidadeParaConversao);
        }
            System.out.println("Deseja calcular outra temperatura? (S/N): ");
            char resposta = sc.next().toUpperCase().charAt(0);

            if (resposta != 'S') {
                NovaMedida = false;
            }
        }

        System.out.println("Programa encerrado.");
        sc.close();
    }

    public static double conversorTemperatura(double temp, char atual, char conversao) {
        if (atual == conversao) return temp;

        switch (atual){
            case 'C':
                if (conversao == 'F') return celsiusParaFahrenheit(temp);
                if (conversao == 'K') return celsiusParaKelvin(temp);
                if (conversao == 'R') return celsiusParaRankine(temp);
                break;

            case 'F':
                if (conversao == 'C') return fahrenheitParaCelsius(temp);
                if (conversao == 'K') return fahrenheitParaKelvin(temp);
                if (conversao == 'R') return fahrenheitParaRankine(temp);
                break;

            case 'K':
                if (conversao == 'C') return kelvinParaCelsius(temp);
                if (conversao == 'F') return kelvinParaFahrenheit(temp);
                if (conversao == 'R') return kelvinParaRankine(temp);
                break;

            case 'R':
                if (conversao == 'C') return rankineParaCelsius(temp);
                if (conversao == 'F') return rankineParaFahrenheit(temp);
                if (conversao == 'K') return rankineParaKelvin(temp);
                break;

            default:
                return Double.NaN;
        }
        return Double.NaN;
        }
    public static double celsiusParaFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double celsiusParaKelvin(double c) {
        return c + 273.15;
    }

    public static double celsiusParaRankine(double c) {
        return (c + 273.15) * 9 / 5;
    }

    public static double fahrenheitParaCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double fahrenheitParaKelvin(double f) {
        return (f - 32) * 5 / 9 + 273.15;
    }

    public static double fahrenheitParaRankine(double f) {
        return f + 459.67;
    }

    public static double kelvinParaCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinParaFahrenheit(double k) {
        return (k - 273.15) * 9 / 5 + 32;
    }

    public static double kelvinParaRankine(double k) {
        return k * 9 / 5;
    }

    public static double rankineParaCelsius(double r) {
        return (r - 491.67) * 5 / 9;
    }

    public static double rankineParaFahrenheit(double r) {
        return r - 459.67;
    }

    public static double rankineParaKelvin(double r) {
        return r * 5 / 9;
    }
}
