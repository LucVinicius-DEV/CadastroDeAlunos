public class Cadastro {

    private String name;
    private int matricula;
    private double nota1;
    private double nota2;

    public Cadastro() {
    }

    public Cadastro(String name, int matricula, double nota1, double nota2) {
        this.name = name;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Cadastro(String name, int matricula) {
        this.name = name;
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public int getMatricula() {
        return matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double media() {
        return (nota1 + nota2) / 2.0;
    }

    public String situacao() {
        if (media() >= 6.0) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    public String toString() {
        return "Aluno: " + name +
               ", Matrícula: " + matricula +
               ", Média: " + String.format("%.2f", media()) +
               ", Situação: " + situacao();
    }
}
