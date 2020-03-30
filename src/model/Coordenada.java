package model;

public class Coordenada {
	//clases de apoyo
	private int posX,posY;

	public Coordenada(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean retorno=false;
		if(obj!=null) {
			retorno=this.equals(obj);
			if(!retorno && obj instanceof Coordenada) {
				Coordenada coordenada=(Coordenada)obj;
				retorno=this.getPosX()==coordenada.getPosX()&&this.getPosY()==coordenada.getPosY();
			}
		}
		return retorno;
	}

	public Coordenada creaNuevaAlrededor(int i) {
		Coordenada nueva = new Coordenada(this.posX, this.posY);
		if (i<=3 && i!=0) {
			setPosY(posY+1);
		}
		if (i==0 || i==1 || i==7) {
			setPosX(posX+1);
		}
		if (i>4 && i<8) {
			setPosY(posY-1);
		}
		if (i>2 && i<6) {
			setPosX(posX-1);
		}
		return nueva;
	}

}
