import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {
        private Screen screen;
        private Arena arena;
        private int processKey(KeyStroke key) throws IOException {
            return arena.processKey(key);
        }
        private void moveHero(Position position) {
            arena.moveHero(position);}
        public Game() throws IOException {
                TerminalSize terminalSize = new TerminalSize(40, 20);
                DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
                Terminal terminal = terminalFactory.createTerminal();
                screen = new TerminalScreen(terminal);
                screen.setCursorPosition(null); // we don't need a cursor
                screen.startScreen(); // screens must be started
                screen.doResizeIfNecessary(); // resize screen if necessary
                arena = new Arena(40, 20);
        }
        public void run() throws IOException {
            while(true) {
                draw();
                KeyStroke key = screen.readInput();
                int game_continues = processKey(key);
                if (game_continues == 0) {
                    screen.close();
                    break;
                }
            }

        }
        private void draw() throws IOException {
            screen.clear();
            arena.draw(screen.newTextGraphics());
            screen.refresh();
        }
    }
