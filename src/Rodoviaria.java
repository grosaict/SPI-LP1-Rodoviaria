
import java.text.DecimalFormat;

public class Rodoviaria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char itemMenu, itemSN;
		byte assento;
		double preco;
		String nomePassageiro, docPassageiro, msg;
		
		Entradas leia = new Entradas();
		MapaBus mBus = new MapaBus();
		DecimalFormat df = new DecimalFormat("0.00");

		mBus.setTipoBus(leia.leiaBus());
		
		if (mBus.getTipoBus() == 'C' || mBus.getTipoBus() == 'E'){
			mBus.DefineMapa();
			BancoDados BD = new BancoDados(mBus.getTipoBus(), mBus.getQtdTot());
			BD.InicializaBD();
			mBus.ApresentaMapa(BD.getOcupado());
			
			do{
				itemMenu = leia.leiaMenu();
				switch (itemMenu){
				case 'V':
					assento = leia.leiaAssento(mBus.getQtdTot());
					if (assento != 0){
						if (BD.getDisponibilidade(assento)){
							System.err.println("Assento ocupado!!!");
						}else{
							msg = ">>> COMPRA NÃO EFETUADA <<<";
							nomePassageiro = leia.leiaNome();
							if (nomePassageiro.charAt(0) != '*'){
								docPassageiro = leia.leiaDocumento();
								if (docPassageiro.charAt(0) != '*'){
									if (mBus.getTipoBus() == 'C' || (mBus.getTipoBus() == 'E' && assento <= 40)){
										preco = BD.getPrecoBase();
									}else{
										preco = BD.getPrecoBase() * 1.2;
									}
									System.out.println("\nAssento: "+String.format("%02d",assento)+"       - Nome Passageiro:      "+nomePassageiro);
									System.out.println("Preço:   R$"+df.format(preco)+" - Documento Passageiro: "+docPassageiro);
									itemSN = leia.leiaConfirmacao("\nConfirma a compra da passagem acima?");
									if (itemSN == 'S'){
										BD.setPassageiro(nomePassageiro, docPassageiro, assento);
										BD.setPreco(assento, preco);
										BD.setDisponibilidade(true, assento);
										msg = ">>> COMPRA EFETUADA COM SUCESSO <<<";
									}
								}
							}
							System.out.println("\n"+msg+"\n");
							mBus.ApresentaMapa(BD.getOcupado());
						}
					}
				break;
				case 'C':
					assento = leia.leiaAssento(mBus.getQtdTot());
					msg = ">>> CANCELAMENTO NÃO EFETUADO <<<\n";
					if (assento != 0){
						if (!BD.getDisponibilidade(assento)){
							msg = ">>> ASSENTO NÃO VENDIDO <<<";
						}else{
							System.out.println("\nAssento: "+String.format("%02d",assento)+"       - Nome Passageiro:      "+BD.getNomePassageiro(assento));
							System.out.println("Preço:   R$"+df.format(BD.getPreco(assento))+" - Documento Passageiro: "+BD.getDocPassageiro(assento));
							itemSN = leia.leiaConfirmacao("\nConfirma o cancelamento da passagem acima?");
							if (itemSN == 'S'){
								BD.setPassageiro("", "", assento);
								BD.setPreco(assento, 0);
								BD.setDisponibilidade(false, assento);
								mBus.ApresentaMapa(BD.getOcupado());
								msg = ">>> CANCELAMENTO EFETUADO COM SUCESSO <<<";
							}
						}
						System.out.println("\n"+msg+"\n");
						mBus.ApresentaMapa(BD.getOcupado());
					}
					break;
				}
			}while(itemMenu == 'V' || itemMenu == 'C');
			mBus.ApresentaMapa(BD.getOcupado());
			BD.ListaBD();
			
		}else{
			System.err.println("Aplicação encerrada pelo usuário!!");
		}
		
	}

}
