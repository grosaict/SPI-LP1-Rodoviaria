
public class MapaBus {
	private char tpBus;
	private byte aTot;
	private byte aInf;

	public char getTipoBus() {
		return this.tpBus;
	}

	public void setTipoBus(char tpBus) {
		this.tpBus = tpBus;
	}
	
	public byte getQtdTot() {
		return this.aTot;
	}

	public void DefineMapa (){
		char tpBus = this.tpBus;
		byte qtdAssentoTot;
		byte qtdAssentoInf;
		
		switch (tpBus){
		case 'C':
			qtdAssentoTot = 46;
			qtdAssentoInf = 0;
			break;
		case 'E':
			qtdAssentoTot = 56;
			qtdAssentoInf = 16;
			break;
		default:
			qtdAssentoTot = 0;
			qtdAssentoInf = 0;
			break;
		}
		this.aTot = qtdAssentoTot;
		this.aInf = qtdAssentoInf;
	}
	
	public void ApresentaMapa(boolean ocupado[]){
		byte fila = 1;
		byte linha = 1;
		int poltrona = 0;
		String separador = "";
		
		System.out.println("  >>> MAPA DE LOTAÇÃO ATUAL <<<\n");
		
		switch (this.tpBus){
		case 'C':
			for (byte i=0; i<this.aTot;i++){
				switch (fila){
				case 1:
					poltrona = i + 1;
					separador = " ";
					fila++;
					break;
				case 2:
					poltrona = i + 1;
					separador = "    ";
					fila++;
					break;
				case 3:
					poltrona = i + 2;
					separador = " ";
					fila++;
					break;
				case 4:
					poltrona = i;
					switch (linha){
					case 1: separador = "          >> LEGENDA <<\n";
					break;
					case 2: separador = "      00  = ASSENTO LIVRE\n";
					break;
					case 3: separador = "     [00] = ASSENTO OCUPADO\n";
					break;
					default: separador = "\n";
					}
					linha++;
					fila = 1;
					break;
				}
				if (ocupado[poltrona-1]){
					System.out.print("["+String.format("%02d", poltrona)+"]"+separador);
				}else{
					System.out.print(" "+String.format("%02d", poltrona)+" "+separador);
				}
			}
			break;
		case 'E':
			for (byte i=0; i<(this.aTot-this.aInf);i++){
				switch (fila){
				case 1:
					poltrona = i + 1;
					separador = " ";
					fila++;
					break;
				case 2:
					poltrona = i + 1;
					separador = "    ";
					if (linha == 4 || linha ==5){
						fila = 1;
						linha++;
						separador = "\n";
					}else{
						fila++;
					}
					break;
				case 3:
					poltrona = i + 2;
					separador = " ";
					fila++;
					break;
				case 4:
					poltrona = i;
					if (linha <= 5 || linha >= 10){
						switch (linha){
						case 1: separador = "          >> LEGENDA <<\n";
						break;
						case 2: separador = "      00  = ASSENTO LIVRE\n";
						break;
						case 3: separador = "     [00] = ASSENTO OCUPADO\n";
						break;
						default: separador = "\n";
						}
						fila = 1;
						linha++;
					}else{
						fila++;
						separador = "       ";
					}
					break;
				case 5:
					poltrona = i + 21;
					separador = " ";
					i--;
					fila++;
				break;
				case 6:
					poltrona = i + 22;
					separador = "    ";
					i--;
					fila++;
				break;
				case 7:
					poltrona = i + 24;
					separador = " ";
					i--;
					fila++;
				break;
				case 8:
					poltrona = i + 23;
					separador = "\n";
					i--;
					fila = 1;
					linha++;
				break;
				}
				if (ocupado[poltrona-1]){
					System.out.print("["+String.format("%02d", poltrona)+"]"+separador);
				}else{
					System.out.print(" "+String.format("%02d", poltrona)+" "+separador);
				}

			}
			break;
		}
		System.out.println("\n");
	}
}
