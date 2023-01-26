/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 
 *Fecha de actualización:4-01-2023
 *Descripción: Clase para cargar los sonidos 
 **
 * ****************************************************************************/
package Graficos;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sonidos {

    private Clip clip;
    private FloatControl volume;

    public Sonidos(Clip clip) {
        this.clip = clip;
        volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop() {
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

    public int getFramePosition() {
        return clip.getFramePosition();
    }

    public void changeVolume(float value) {
        volume.setValue(value);
    }

}
