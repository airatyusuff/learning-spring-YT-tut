package vanilla;

import components.GameRunner;
import components.SuperContraGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApplicationVanilla {

	public static void main(String[] args) {

//		var marioGame = new MarioGame();
		var scGame = new SuperContraGame();
		var gameRunner = new GameRunner(scGame);

		gameRunner.run();
	}

}
