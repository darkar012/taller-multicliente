package main;
import java.util.ArrayList;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet implements OnMessageListener{

	private TcpConnection tcp;
	private ArrayList<Bullet> bullets;
	private boolean gaming;
	private int lastX;

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	public void settings() {
		size(800, 600);
	}


	public void setup() {
		tcp = TcpConnection.getInstance();
		tcp.setObserver(this);

		gaming = true;
		bullets = new ArrayList<Bullet>();
	}

	public void draw() {
		background(0);
		
		if (gaming) {

		for (int i = 0; i < tcp.getSessions().size(); i++) {

			Session session =  tcp.getSessions().get(i);
			fill (session.getAvatar().getR(),session.getAvatar().getG(), session.getAvatar().getB());
			ellipse(session.getAvatar().getX(), session.getAvatar().getY(), 50, 50);
			session.getAvatar().move();
			
			for (int j = 0; j < bullets.size(); j++) {
				Bullet b = bullets.get(j);
				b.pintar();
				if(bullets.size() > 2 && b.getX()<0 || b.getX()>800) {
					bullets.remove(i);
				}
				
				if (dist(b.getX(), b.getY(), session.getAvatar().getX(), session.getAvatar().getY()) < 30 ) {
					lastX = session.getAvatar().getX();
					gaming = false;
				}
			}
			

		}	
		} else {
			
			if (lastX == tcp.getSessions().get(0).getAvatar().getX()) {
				
				String win = "Jugador Derecho";
				msgFinal(win);
				
			} else {
				String win = "Jugador Izquierdo";
				msgFinal(win);
			}
		}

	}

	@Override
	public void OnMessage(Session s, String msg) {
		System.out.println("mensaje recibido de " + s.getID() + ": "+ msg);
		Gson gson = new Gson();
		String Id = tcp.getSessions().get(0).getID();
		Message message = gson.fromJson(msg, Message.class);
		s.setMsg(message.getAccion());


		if (message.getAccion().equals("FIRE")) {
			if (Id.equals(s.getID())) {
				System.out.println("left");
				Bullet b = new Bullet(this, s.getAvatar().getX(), s.getAvatar().getY(), false);
				if (b.isMoveToRight() == false) {
					b.setX(s.getAvatar().getX() - 35);
					bullets.add(b);
				}
				
			} else {
				System.out.println("right");
				Bullet b = new Bullet(this, s.getAvatar().getX(), s.getAvatar().getY(), true);
				if (b.isMoveToRight()) {
					b.setX(s.getAvatar().getX() + 35);
					bullets.add(b);
				}
			}

		}
	}
	public void mouseClicked() {
		if (!gaming && mouseX > 350 && mouseX < 350 + 100
				&& mouseY > 550 && mouseY < 550+40) // 	Contacts Button
			exit();
	}
	
	public void msgFinal(String winner) {
		fill(255);
		rect(800/2-200, 600/2, 400, 100);
		fill(255,0,0);
		rect(350, 550, 100, 40);
		fill(0);
		textSize(24);
		text("ganador: " + winner, 240, 360);
		fill(255);
		text("Salir", 350+25, 550+30);
	}

}



