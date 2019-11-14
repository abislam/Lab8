import java.util.Scanner;

 public class Lab8{
 	public static void main(String[] args){

 		Scanner scan = new Scanner(System.in);
 		double height, base;
 		int count = 0;
 		int id = 0;
 		int userChoice, rtIndex, xLoc, yLoc;
 		char exitChoice;

 		RightTriangle rt1[] = new RightTriangle[10];

 		boolean programRunner = true;
 		boolean programDebug = true;

 		while(programRunner){
 			System.out.println("\n1 - Enter a new right triangle \n");
 			System.out.println("2 - Delete a right triangle \n");
 			System.out.println("3 - Delete all right triangles \n");
 			System.out.println("4 - Display all right triangle \n");
 			System.out.println("5 - Move a triangle \n");
 			System.out.println("6 - Resize a triangle \n");
 			System.out.println("7 - Enter a scale factor \n");
 			System.out.println("8 - Scale all triangles \n");
 			System.out.println("9 - Exit program \n\n");
 			System.out.println("Please choose an option: ");

 			userChoice = scan.nextInt();

 			switch(userChoice){

 				case 1: 
 					if(count<10){
	 					System.out.println("Enter right triangle height: ");
	 					height = scan.nextDouble();
	 					System.out.println("Enter right triangle base: ");
	 					base = scan.nextDouble();
	 					System.out.println("Enter the X coordinate: ");
	 					xLoc = scan.nextInt();
	 					System.out.println("Enter the Y coordinate: ");
	 					yLoc = scan.nextInt();

	 					rt1[count++] = new RightTriangle(height, base, id, xLoc, yLoc);
	 					id +=1;
	 				}else{
	 					System.out.println("\nThe program has reached the max number of right triangles allowed.\n");
	 				}
	 				break;

	 			case 2:
 					System.out.println("Enter the Right Triangle ID: ");
 					rtIndex = scan.nextInt();
 					for(int i=0; i<count; i++){
 						if(rt1[i].id == rtIndex){
 							rt1[i] = rt1[count-1];
 							rt1[count-1] = null;
 							count--;
 							System.out.println("\nRight Triangle with ID " + rtIndex + " has been deleted\n");
 							programDebug = false;
 						}
 					}
 					if(programDebug){
 						System.out.println("\nInvalid Right Triangle ID\n");
 					}
 					break;

 				case 3: 
 					for(int i=0; i<count; i++){
 						rt1[i] = null;
 					}
 					count = 0;
 					System.out.println("\nAll right triangles have been deleted.\n");
 					break;

 				case 4:
 					for(int i=0; i<count; i++){

 						System.out.println("\nRight Triangle ID: " + rt1[i].id);
 						System.out.println("Right Triangle Height: " + rt1[i].getHeight());
 						System.out.println("Right Triangle Base: " + rt1[i].getBase());
 						System.out.println("Right Triangle Hypotenuse: " + rt1[i].getHypotenuse());
 						System.out.println("Right Triangle X coordinate: " + rt1[i].xLoc);
 						System.out.println("Right Triangle Y coordinate: " + rt1[i].yLoc + "\n");
 					}
 					break;

 				case 5:
 					System.out.println("Enter the Right Triangle ID: ");
 					rtIndex = scan.nextInt();
 					for(int i=0; i<count; i++){
 						if(rt1[i].id == rtIndex){
 							System.out.println("Enter the Right Triangle X coordinate: ");
 							xLoc = scan.nextInt();
 							rt1[i].setX(xLoc);
 							System.out.println("Enter the Right Triangle Y coordinate: ");
 							yLoc = scan.nextInt();
 							rt1[i].setY(yLoc);
 							programDebug = false;
 						}
 					}
 					if(programDebug){
 							System.out.println("\nInvalid Right Triangle ID\n");
 					}
 					break;

 				case 6:
 					System.out.println("Enter the Right Triangle ID: ");
 					rtIndex = scan.nextInt();
 					for(int i=0; i<count; i++){
 						if(rt1[i].id == rtIndex){
 							System.out.println("Enter the New Height for the Right Triangle: ");
 							height = scan.nextInt();
 							System.out.println("Enter the New Base for the Right Triangle: ");
 							base = scan.nextInt();
 							rt1[i].setValues(base, height);
 							programDebug = false;
 						}
 					}
 					if(programDebug){
 						System.out.println("\nInvalid Right Triangle ID\n");
 					}
 					break;

 				case 7:
 					System.out.println("Enter a new Scaling Factor value: ");
 					RightTriangle.scaleFactor = scan.nextDouble();
 					System.out.println("\nNew Scale Factor Value: " + RightTriangle.scaleFactor + "\n");
 					break;

 				case 8:
 					for(int i=0; i<count; i++){
 						rt1[i].ScaleShape();
 						System.out.println("Scaled Right Triangle " + rt1[i].id + "\n");
 					}
 					break;

 				case 9:
 					System.out.println("Please confirm that you want to exit the program with (y/n): ");
 					exitChoice = scan.next().charAt(0);
 					if(exitChoice == 'y' || exitChoice == 'Y'){
 						programRunner = false;
 					}else if(exitChoice == 'n' || exitChoice == 'N'){
 						programRunner = true;
 					}else{
 						programRunner = true;
 						System.out.println("\nInvalid input\n");
 					}


 			}//end of switch
 			System.out.println("\n----------------------------------------------------------------------\n");


 		}

 	}
 }
 

 /*
Create an abstract base class called Shape and move the static variable scaleFactor and the three instance variables id, xLoc and yLoc from RightTriangle 
to Shape along with the get and set methods for those variables.  
Implement a Shape constructor and update the RightTriangle constructor to call the Shape constructor for the variables moved to Shape. 
Then add three abstract methods to Shape called getArea(), getPerimeter() and scaleShape(). 
 */

abstract class Shape{
	static double scaleFactor;
	int id, xLoc, yLoc;

	//setID
	public void setID(int id){
		this.id = id;
	}

	//setX
 	public void setX(int x){
 		this.xLoc = x;
 	}

 	//setY
 	public void setY(int y){
 		this.yLoc = y;
 	}

 	//setScaleFactor
 	public static void setScaleFactor(double scaleFactor){
 		Shape.scaleFactor = scaleFactor;
 	}

 	//getID
 	public int getID(){
 		return id;
 	}

 	//getX
 	public int getX(){
 		return xLoc;
 	}

 	//getY
 	public int getY(){
 		return yLoc;
 	}

 	//getScaleFactor
 	public double getScaleFactor(){
 		return scaleFactor;
 	}

}

 class RightTriangle extends Shape{
 	private double base, height, hypotenuse, area, perimeter;


 	//getBase
 	public double getBase(){
 		return base;
 	}

 	//getHeight
 	public double getHeight(){
 		return height;
 	}

 	//getHypotenuse
 	public double getHypotenuse(){
 		hypotenuse = Math.sqrt(Math.pow(getBase(), 2) + Math.pow(getHeight(), 2));
 		return hypotenuse;
 	}

 	//getArea
 	public double getArea(){
 		area = (getBase()*getHeight())/2;
 		return area;
 	}

 	//getPerimeter
 	public double getPerimeter(){
 		perimeter = getBase() + getHeight() + getHypotenuse();
 		return perimeter;
 	}

 	//setScale
 	public void ScaleShape(){
 		this.height = this.height*scaleFactor;
 		this.base = this.base*scaleFactor;
 		this.hypotenuse = this.hypotenuse*scaleFactor;
 	}

 	//setValues for base,height and calculate hypotenuse
 	public void setValues(double newBase, double newHeight){
 		this.base = newBase;
 		this.height = newHeight;
 		this.hypotenuse = getHypotenuse();
 	}



 	//constructor
 	public RightTriangle(double base, double height, int id, int xLoc, int yLoc){
 		this.base = base;
 		this.height = height;
 		this.id = id;
 		this.xLoc = xLoc;
 		this.yLoc = yLoc;		
 	}



 }

 class Circle extends Shape{
 	private double radius, area, perimeter;


 	//radius getter
 	public double getRadius(){
 		return radius;
 	}
 	//radius setter
 	public void setRadius(double newRadius){
 		this.radius = newRadius;
 	}

 	//getArea method
 	public double getArea(){
 		area = 3.14*Math.pow(getRadius(), 2);
 		return area;
 	}

 	//getPerimeter method
 	public double getPerimeter(){
 		perimeter = 2*3.14*getRadius();
 		return perimeter;
 	}

 	//constructor
 	public Circle(double radius){
 		this.radius = radius;
 	}

 	

 }
