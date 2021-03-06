public class NBody{
	public static double readRadius(String fileName){
		/** read Radius */
		In in = new In(fileName);
		int N = in.readInt();
		double R = in.readDouble();
		return R;
	}

	public static Body[] readBodies(String fileName){
		/** read bodies from file */
		In in = new In(fileName);
		int N = in.readInt();
		double R = in.readDouble();
		double xP;
		double yP;
		double xV;
		double yV;
		double mass;
		String image;
		Body[] bodies= new Body[N];
		for(int i = 0; i < N; i++){
			xP = in.readDouble();
			yP = in.readDouble();
			xV = in.readDouble();
			yV = in.readDouble();
			mass = in.readDouble();
			image = in.readString();
			bodies[i] = new Body(xP, yP, xV, yV, mass, image);
		}
		return bodies;
	}

	public static void main(String[] args) {
		/** read everything from file */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double canvasR = NBody.readRadius(filename);
		Body[] bodies = NBody.readBodies(filename);
		String background = "images/starfield.jpg";

		/** Enables double buffering.
		  * A animation technique where all drawing takes place on the offscreen canvas.
		  * Only when you call show() does your drawing get copied from the
		  * offscreen canvas to the onscreen canvas, where it is displayed
		  * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();
		/** draw background */
		StdDraw.setScale(-canvasR, canvasR);
		StdDraw.picture(0, 0, background);
		/** draw bodies */
		for(Body b : bodies){
			b.draw();
		}
		StdDraw.show();
		/** play audio*/
		StdAudio.play("audio/2001.mid");
		/** loop until time reaches T */
		double tick = 0.0;
		int bodyNr = bodies.length;

		while(tick < T){
			/** calculate net forces */
			double[] xForces = new double[bodyNr];
			double[] yForces = new double[bodyNr];

			for(int i = 0; i < bodyNr; i++){
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
				bodies[i].update(dt, xForces[i], yForces[i]);
			}
			/** draw background and bodies*/
			StdDraw.picture(0, 0, background);
			for(Body b : bodies){
			b.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			tick = dt + tick;
		}
		StdOut.printf("%d\n", bodyNr);
		StdOut.printf("%.2e\n", canvasR);
		for(int j = 0; j < bodyNr; j++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", bodies[j].xxPos, bodies[j].yyPos, bodies[j].xxVel, bodies[j].yyVel, bodies[j].mass, bodies[j].imgFileName);
		}

	}
}