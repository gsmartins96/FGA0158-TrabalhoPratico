
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
