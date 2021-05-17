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

