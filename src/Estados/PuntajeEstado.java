
package Estados;

import Graficos.Assets;
import Math.Vector;
import Ui.Boton;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author carlos
 */
public class PuntajeEstado extends Estado{
private Boton returnButton;
	
	private PriorityQueue<PuntajeEstado> highScores;
	
	private Comparator<PuntajeEstado> scoreComparator;
	
	private PuntajeEstado[] auxArray;
	
	public PuntajeEstado() {
		returnButton = new Boton(
				Assets.greyBtn,
				Assets.blueBtn,
				Assets.greyBtn.getHeight(),
				Constants.HEIGHT - Assets.greyBtn.getHeight() * 2,
				Constants.RETURN,
				new Action() {
					@Override
					public void doAction() {
						Estado.changeEstado(new MenuEstado());
					}
				}
			);
		
		scoreComparator = new Comparator<PuntajeEstado>() {
			@Override
			public int compare(PuntajeEstado e1, PuntajeEstado e2) {
				return e1.getScore() < e2.getScore() ? -1: e1.getScore() > e2.getScore() ? 1: 0;
			}
		};
		
		highScores = new PriorityQueue<PuntajeEstado>(10, scoreComparator);
		
		try {
			ArrayList<PuntajeEstado> dataList = JSONParser.readFile();
			
			for(PuntajeEstado d: dataList) {
				highScores.add(d);
			}
			
			while(highScores.size() > 10) {
				highScores.poll();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update() {
		returnButton.update();
	}

	@Override
	public void draw(Graphics g) {
		returnButton.draw(g);
		
		auxArray = highScores.toArray(new PuntajeEstado()[highScores.size()]);
		
		Arrays.sort(auxArray, scoreComparator);
		
		
		Vector scorePos = new Vector(
				Constants.WIDTH / 2 - 200,
				100
				);
		Vector datePos = new Vector(
				Constants.WIDTH / 2 + 200,
				100
				);
		
		Text.drawText(g, Constants.SCORE, scorePos, true, Color.BLUE, Assets.fontBig);
		Text.drawText(g, Constants.DATE, datePos, true, Color.BLUE, Assets.fontBig);
		
		scorePos.setY(scorePos.getY() + 40);
		datePos.setY(datePos.getY() + 40);
		
		for(int i = auxArray.length - 1; i > -1; i--) {
			
			PuntajeEstado d = auxArray[i];
			
			Text.drawText(g, Integer.toString(d.getScore()), scorePos, true, Color.WHITE, Assets.fontMed);
			Text.drawText(g, d.getDate(), datePos, true, Color.WHITE, Assets.fontMed);
			
			scorePos.setY(scorePos.getY() + 40);
			datePos.setY(datePos.getY() + 40);
			
		}
		
	}
}
