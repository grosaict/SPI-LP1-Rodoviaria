
import java.text.DecimalFormat;

public class BancoDados {

	private byte aTot = 56;
	private boolean ocupado[] = new boolean [aTot];
	private String passageiro[][] = new String [aTot][2];
	private double preco[] = new double [aTot];
	private double precoBase;
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	public BancoDados(char tpBus, byte aTot) {
		if (tpBus == 'C'){
			this.precoBase = 120.75;
		}else{
			this.precoBase = 180.25;
		}
		this.aTot = aTot;
	}
	
	public void InicializaBD(){
		for (byte i=0;i<this.aTot;i++){
			this.ocupado[i] = false;
			this.passageiro[i][0] = "";
			this.passageiro[i][1] = "";
			this.preco[i] = 0;
		}
	}
	
	public void ListaBD(){
		byte qtdVendida = 0;
		double valorVendido = 0;
		System.out.println("  Assento -   R$   - Nome Passageiro (Documento)");
		for (byte i=0; i<aTot; i++){
			if (this.ocupado[i]){
				System.out.println("    "+String.format("%02d",(i+1))+"    - "+df.format(this.preco[i])+" - "+this.passageiro[i][0]+" ("+this.passageiro[i][1]+")");
				qtdVendida++;
				valorVendido = valorVendido + this.preco[i];
			}
		}
		if (qtdVendida == 0){
			System.err.println("\n      >>> Nenhuma passagem vendida!!! <<<");
		}else{
			System.out.println("\nTotal de passagens vendidas:      "+String.format("%02d",qtdVendida));
			System.out.println("Receita com passagens vendidas: R$"+df.format(valorVendido));
		}
	}

	public boolean[] getOcupado() {
		return this.ocupado;
	}
	
	public void setDisponibilidade(boolean ocupado, byte assento) {
		this.ocupado[assento-1] = ocupado;
	}
	
	public boolean getDisponibilidade(byte assento) {
		return this.ocupado[assento-1];
	}

	public void setPassageiro(String nomePassageiro, String docPassageiro, byte assento) {
		this.passageiro[assento-1][0] = nomePassageiro;
		this.passageiro[assento-1][1] = docPassageiro;
	}
	
	public String getNomePassageiro(byte assento) {
		return this.passageiro[assento-1][0];
	}
	
	public String getDocPassageiro(byte assento) {
		return this.passageiro[assento-1][1];
	}

	public void setPreco(byte assento, double preco) {
		this.preco[assento-1] = preco;
	}
	
	public double getPreco(byte assento) {
		return this.preco[assento-1];
	}

	public double getPrecoBase() {
		return this.precoBase;
	}	
}
