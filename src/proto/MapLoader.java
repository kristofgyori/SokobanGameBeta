package proto;

import game.*;
import view.*;

import java.util.List;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * pálya betöltésért felelős osztály
 *
 */



//TODO új változat, vagy átalakítások szükségesek.
public class MapLoader {
	/**
	 * Scanner amivel a bemenetről olvasunk
	 */
	private Scanner sc;	
	/**
	 * a pálya méretei
	 */
	private int x, y;
	
	private List<Drawable> drawables = new LinkedList<>();
	/**
	 * a pályaelemek listája
	 */
	private List<Field> fields = new LinkedList<Field>();
	/**
	 * a Switchek listája
	 */
	private List<Switch> switches = new LinkedList<Switch>();
	/**
	 * a TrapDoorok sorszámainak listája
	 */
	private List<Integer> trapdoorIdx = new LinkedList<Integer>();
	/**
	 * a Playerek listája
	 */
	private List<Player> players = new LinkedList<Player>();
		/**
		 * visszaadja a Playerek listáját
		 * @return Playerek listája
		 */
	public List<Player> getPlayers() {
		return players;
	}
	
	
	/**
	 * Előállítja a rajzolható objektumok listáját
	 * @return
	 */
	public List<Drawable> getDrawables(){
		return drawables; //A drawables lista feltötlése még nem teljes		
	}
	
	/**
	 * Visszaadja a Fieldeket egy 2D-s tömbben
	 * @return a Fieldek egy 2D-s tömbben
	 */
	public List<Field> getFields() {
		Field[][] f = new Field[y][x];
		// y*x grid
		for(int i=0; i<y; ++i) {
			for(int j=0; j<x; ++j) {
				f[i][j] = fields.get(i*x+j);
			}
		}
		
		for(int i=0; i< y; i++) {				//fieldek összekötése egy sorban
			for(int j =0; j< x-1; j++) {
				Field.ConnectHorizontal(f[i][j], f[i][j+1]);				
			}		
		}										//fieldek összekötése egy oszlopban
		
		for(int i=0; i< y-1; i++) {
			for(int j =0; j< x; j++) {
				Field.ConnectVertical(f[i][j], f[i+1][j]);				
			}		
		}
				
		List<Field> fields = new LinkedList<>();
		for(int i=0; i<y; ++i) {
			for(int j=0; j<x; ++j) {
				fields.add(f[i][j]); 
			}
		}
		return fields;
	}

	/**
	 * ez a függvény olvassa be és hozza létre a pályát a megadott Streamről
	 * @param is a Stream ahonnan a pályát beolvassuk
	 */
	public void Load(InputStream is){
		sc = new Scanner(is);
		x = Integer.parseInt(sc.nextLine()); // a pálya méretei
		y = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<x*y; ++i) {			//a fieldek létrehozása
			CreateField(sc.nextLine(), i%x, i/x);
		}
		
		for(int i=0; i<switches.size(); ++i) {	//a TrapDoorok Switchekhez kötése
			switches.get(i).setTd( (TrapDoor) fields.get(trapdoorIdx.get(i)));
		}
		
		while(sc.hasNext()) {				//a dolgok létrehozása
			CreateThing(sc.nextLine());
		}
	}
		/**
		 * egy a pályán szereplő dolog létrehozása a megadott String alapján
		 * @param line az szükséges adatok String formátumban
		 */
	private void CreateThing(String line) {
		String[] parts = line.split(" "); //String feldarabolása
		
		switch(parts[0]) {
			case "p": //Player
				Player p = new Player();
				p.setField(fields.get(Integer.parseInt(parts[1])));
				p.setStrength(Integer.parseInt(parts[2]));
				p.getCurrentField().set(p);
				players.add(p);
				
				GPlayer gp = new GPlayer();
				gp.setPlayer(p);
				gp.setZ(0);
				drawables.add(gp);				
				break;
				
			case "b"://Box
				Box b = new Box();
				b.setField(fields.get(Integer.parseInt(parts[1])));
				b.getCurrentField().set(b);
				
				GBox gb = new GBox();
				gb.setBox(b);
				gb.setZ(0);
				drawables.add(gb);
				break;
		}
	}
	/**
	 * Egy Field létrehozása a praméterben kapott adatokból
	 * @param line az adatok String formában
	 */
	private void CreateField(String line,  int x, int y) {
		Field f;
		String[] parts = line.split(" ");
		
		switch(parts[1]) {
			//floor
			case "f":
				f = new Floor();
				friction(f, parts[2]);
				
				GFloor gf = new GFloor();
				gf.setZ(1);
				gf.setFloor((Floor)f);				
				drawables.add(gf);
				break;
		
			//hole
			case "h":
				f = new Hole(); 
				GHole gh = new GHole();
				gh.setZ(1);
				gh.setHole((Hole)f);				
				drawables.add(gh);
				break;
			
			//storage area
			case "a":
				f = new StoreageArea();
				friction(f, parts[2]);
				
				GStoreageArea gsa = new GStoreageArea();
				gsa.setZ(1);
				gsa.setStorageArea((StoreageArea) f);				
				drawables.add(gsa);
				break;
				
			//switch
			case "s":
				Switch s = new Switch();
				friction(s, parts[2]);
				switches.add(s);
				trapdoorIdx.add(Integer.parseInt(parts[3]));
				f = s;
				
				GSwitch gs = new GSwitch();
				gs.setZ(1);
				gs.setSwitch((Switch) f);				
				drawables.add(gs);
				break;
				
			//trapdoor
			case "t":
				f = new TrapDoor();
				friction(f, parts[2]);
				
				GTrapDoor gt = new GTrapDoor();
				gt.setZ(1);
				gt.setTrapDoor((TrapDoor) f);				
				drawables.add(gt);
				break;
			
			//wall
			case "w":
				f = new Wall();	
				
				GWall gw = new GWall();
				gw.setZ(1);
				gw.setFloor((Wall)f);				
				drawables.add(gw);
				break;
				
			default:
				f = null;
		}
		
		f.setPos(new Coordinate(x, y));
		fields.add(f);
	}
	/**
	 * Egy Field súrlódásának beállítása
	 * @param f a Field aminek a súrlódását be kell állítani
	 * @param s a súrlódás String formában
	 */
	private void friction(Field f, String s) {
		switch (s) {
		case "O":
			f.setFriction(Friction.OIL);
			break;
		case "N":
			f.setFriction(Friction.NORMAL);
			break;
		case "H":
			f.setFriction(Friction.HONEY);
			break;
		}
	}
	/**
	 * a felszabadítás során szükséges műveletek végrehajtása
	 */
	@Override
	protected void finalize(){
		sc.close();
	}
	
}
