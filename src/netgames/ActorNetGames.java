package netgames;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import game.Control;

public class ActorNetGames implements OuvidorProxy {

	protected Proxy proxy_;
	protected Control control_;

	public ActorNetGames(Control control) {
	}

	@Override
	public void iniciarNovaPartida(Integer posicao) {
		

	}

	@Override
	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receberJogada(Jogada jogada) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub

	}
	
	public void startGame() {
		try {
			this.proxy_.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			e.printStackTrace();
		}
	}

	public void connect(String ip, String name) {
		try {
			this.proxy_.conectar(ip, name);
		} catch (JahConectadoException e) {
			e.printStackTrace();
		} catch (NaoPossivelConectarException e) {
			e.printStackTrace();
		} catch (ArquivoMultiplayerException e) {
			e.printStackTrace();
		}
	}

}
