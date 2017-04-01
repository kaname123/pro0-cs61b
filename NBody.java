public class NBody {
	static int n=0;

	
	
	public static void main(String[] args){
		
		double T=Double.parseDouble(args[0]);
		double dt=Double.parseDouble(args[1]);
		String filename=args[2];
		double r=readRadius(filename);
		Planet[] p=readPlanets(filename);
		StdDraw.setScale(-r,r);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for(Planet e:p){
			e.draw();
		}
		double t=0;
		double[] xForces=new double[n];
		double[] yForces=new double[n];
		StdAudio.play("audio/2001.mid");
		while(t<T){
			StdDraw.setScale(-r,r);
			StdDraw.clear();

			StdDraw.picture(0, 0, "images/starfield.jpg");
for(int i=0;i<n;i++){
	xForces[i]=p[i].calcNetForceExertedByX(p);
	yForces[i]=p[i].calcNetForceExertedByY(p);
	p[i].update(dt, xForces[i], yForces[i]);
	
	p[i].draw();

}
StdDraw.show(2);		

t+=dt;

		}
System.out.println(n);
System.out.println(r);
for(int j=0;j<5;j++){
	System.out.println(p[j].xxPos+" "+p[j].yyPos+" "+p[j].xxVel+" "+p[j].yyVel+" "+p[j].mass+" "+p[j].imgFileName);
	 
}
StdAudio.close();

	}
public static double readRadius(String name){
	In in=new In(name);
	 n=in.readInt();
	double r=in.readDouble();
	return r;
}

public static Planet[] readPlanets(String name){
	In in=new In(name);
      n=in.readInt();
     Planet[] p=new Planet[n];
     double r=in.readDouble();
    	 for(int i=0;i<n;i++){
    		double x1=in.readDouble();
    		double x2=in.readDouble();
    		double x3=in.readDouble();
    		double x4=in.readDouble();
    		double x5=in.readDouble();
    		String x6=in.readString();
    		p[i]=new Planet(x1,x2,x3,x4,x5,x6);

    		 
    	 }
     
     return p;
}






}
