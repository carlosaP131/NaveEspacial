package Estados;

import java.awt.Graphics;

public abstract class Estado {

    private static Estado estadoActual = null;

    public static Estado getCurrentState() {
        return estadoActual;
    }

    public static void changeState(Estado newState) {
        estadoActual = newState;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

}
