/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Enum para los tamaños de los objetos 
 *
 * ****************************************************************************/
package Objetos;

import Graficos.Assets;
import java.awt.image.BufferedImage;

/**
 *
 * @author labdessw09
 */
public enum Size {
    BIG(2, Assets.meds), MED(2, Assets.smalls), 
    SMALL(2, Assets.tinies), TINY(0, null);
	
	public int quantity;
	
	public BufferedImage[] textures;
	
	private Size(int quantity, BufferedImage[] textures){
		this.quantity = quantity;
		this.textures = textures;
	}
}
