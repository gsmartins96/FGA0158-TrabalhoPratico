[20:43] Vitor Moraes Dellamora
package oo_estacionamento; public class Veiculo{​​​​

    private String marca;

    private String modelo;

    private String placa;     private Proprietario proprietario;     public String getMarca() {​​​​

        return marca;

    }​​​​

    public void setMarca(String marca) {​​​​

        this.marca = marca;

    }​​​​     public String getModelo() {​​​​

        return modelo;

    }​​​​

    public void setModelo(String modelo) {​​​​

        this.modelo = modelo;

    }​​​​     public String getPlaca() {​​​​

        return placa;

    }​​​​

    public void setPlaca(String placa) {​​​​

        this.placa = placa;

    }​​​​     public Proprietario getProprietario() {​​​​

        return proprietario;

    }​​​​

    public void setProprietario(Proprietario p) {​​​​

        this.proprietario = proprietario;

    }​​​​     //This is constructor of Veiculo Class

    Veiculo(String marca, String modelo, String placa){​​​​

        this.marca = marca;

        this.modelo = modelo;

        this.placa = placa;

    }​​​​     public String Trace(){​​​​

        return marca + modelo + placa;

    }​​​​

}​​​​

[20:43] Vitor Moraes Dellamora
package oo_estacionamento; public class Estacionamento{​​​​

    private String data_acesso;

    private String hora_entrada;

    private String hora_saida;

    private float faturamento;

    private float valorEstacionamento;     private Proprietario proprietario;     public String getData_acesso() {​​​​

        return data_acesso;

    }​​​​

    public void setData_acesso(String data_acesso) {​​​​

        this.data_acesso = data_acesso;

    }​​​​     public String getHora_entrada() {​​​​

        return hora_entrada;

    }​​​​

    public void setHora_entrada(String hora_entrada) {​​​​

        this.hora_entrada = hora_entrada;

    }​​​​     public String getHora_saida() {​​​​

        return hora_saida;

    }​​​​

    public void setHora_saida(String hora_saida) {​​​​

        this.hora_saida = hora_saida;

    }​​​​     public float getFaturamento() {​​​​

        return faturamento;

    }​​​​

    public void setFaturamento(float faturamento) {​​​​

        this.faturamento = faturamento;

    }​​​​     public float getValorEstacionamento() {​​​​

        return valorEstacionamento;

    }​​​​

    public void setValorEstacionamento(float valorEstacionamento) {​​​​

        this.valorEstacionamento = valorEstacionamento;

    }​​​​     //This is constructor of Estacionamento Class

    Estacionamento(String data_acesso, String hora_entrada, String hora_saida){​​​​

        this.data_acesso = data_acesso;

        this.hora_entrada = hora_entrada;

        this.hora_saida = hora_saida;

    }​​​​

    public void calcularPreco(){​​​​

        // fazer o calculo baseado no tempo de estacionamento

    }​​​​     public void zerarFaturamento(){​​​​

        this.faturamento = 0;

    }​​​​

    public String Trace(){​​​​

        return data_acesso + hora_entrada + hora_saida;

    }​​​​

}​​​​

[20:43] Vitor Moraes Dellamora
package oo_estacionamento; import java.util.ArrayList; public class Proprietario{​​​​

    private String nome;

    private String endereco;

    private int celular;

    private int telefone;

    private int cnh;     static ArrayList<Veiculo> veiculos = new ArrayList();     public String getNome() {​​​​

        return nome;

    }​​​​

    public void setNome(String nome) {​​​​

        this.nome = nome;

    }​​​​     public String getEndereco() {​​​​

        return endereco;

    }​​​​

    public void setEndereco(String endereco) {​​​​

        this.endereco = endereco;

    }​​​​     public int getCelular() {​​​​

        return celular;

    }​​​​

    public void setCelular(int celular) {​​​​

        this.celular = nome;

    }​​​​     public int getTelefone() {​​​​

        return telefone;

    }​​​​

    public void setTelefone(int telefone) {​​​​

        this.telefone = telefone;

    }​​​​     public int getCNH() {​​​​

        return cnh;

    }​​​​

    public void setCNH(int cnh) {​​​​

        this.cnh = cnh;

    }​​​​     public Veiculo getVeiculo(int index) {​​​​

        return veiculos.get(index);

    }​​​​

    public void addVeiculo(Veiculo v) {​​​​

        veiculos.add(v);

    }​​​​ 

    //This is constructor of Proprietario Class

    Proprietario(String nome, String endereco, int celular, int telefone, int cnh){​​​​

        this.nome = nome;

        this.endereco = endereco;

        this.celular = celular;

        this.telefone = telefone;

        this.cnh = cnh;

    }​​​​     public Proprietario(String nome2, String endereco2, String celular2, String telefone2, String cnh2) {​​​​

        // TODO Auto-generated constructor stub

    }​​​​

    public String Trace(){​​​​

        return nome;

    }​​​​

}​​​​

