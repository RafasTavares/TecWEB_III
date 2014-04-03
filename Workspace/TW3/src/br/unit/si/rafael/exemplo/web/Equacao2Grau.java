package br.unit.si.rafael.exemplo.web;

/*
 * Classe para calcular equações do segundo grau
 * @autor Rafael
 * */
public class Equacao2Grau {

	/*
	 * Aributos de coeficiente
	 */
	private double a;
	private double b;
	private double c;

	/*
	 * Criar e iniciar os calores dos coeficientes
	 * 
	 * @param coeficiente A
	 * 
	 * @param coeficiente B
	 * 
	 * @param coeficiente C
	 */
	public Equacao2Grau(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/*
	 * Retorna o valor de a
	 */
	public double getA() {
		return this.a;
	}

	/*
	 * Retorna o valor de B
	 */
	public double getB() {
		return this.b;
	}

	/*
	 * Retorna o valor de C
	 */
	public double getC() {
		return this.c;
	}

	/*
	 * retorna o valor da raiz a equação.
	 */
	public double getX1() {

		return (-b + Math.sqrt(getDelta())) / (2 * a);
	}

	/*
	 * retorna o valor de x2
	 */
	public double getX2() {
		return (-b - Math.sqrt(getDelta())) / (2 * a);
	}

	/*
	 * Retorna o valor de delta
	 */
	public double getDelta() {
		return b * b - 4 * a * a;
	}

	public String ToString() {

		return "";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Equacao2Grau) {
			Equacao2Grau eq = (Equacao2Grau) obj;

			return this.a == eq.a && this.b == eq.b && this.c == eq.c;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (int) (a + b + c);
	}

	@Override
	public String toString() {
		this.a = getA();
		this.b = getB();
		this.c = getC();
		String result = "";

		// Todos > 0
		if (a > 0.0 && b > 0.0 && c > 0.0) {
			result = result + a + "x² + " + b + "x + " + c;
          // B  == 0
		}else if (a > 0.0 && b == 0.0 && c > 0.0) {
			result = result + a + "x² + " + c; 
			// C = 0
		}else if (a > 0.0 && b > 0.0 && c == 0.0) {
			result = result + a + "x² + " + b + "x"; 
			// A = 0
		} else if (a == 0.0 && b > 0.0 && c > 0.0) {
			result = result + b + "x + " + c;
			// A e B = 0
		} else if (a == 0.0 && b == 0.0 && c > 0.0) {
			result = result + c;
			// A e C = 0
		} else if (a == 0.0 && b > 0.0 && c == 0.0) {
			result = result + b + "x";
			// B e C = 0
		} else if (a > 0.0 && b == 0.0 && c == 0.0) {
			result = result + a + "x²";
		}
		return result = result + " = 0";
	}
}
