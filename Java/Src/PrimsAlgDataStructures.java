//-----------------------------------------------------
// Author: Olivia Anastassov
// Date: 16/4/21
// Class:
// Description: data structures for Prims Algorithm 
//-----------------------------------------------------
import java.util.*;
import java.io.*;
public class PrimsAlgDataStructures{
    private int nrV;
    private int nrE;

    public int [] previous;
    public int [] distance;
    public ArrayList <DEdge> edges;

//Local var
    final static boolean DEBUG = false;

//------------------------------------- 
//Utilities
//-------------------------------------
    public static int toMathId(int n){
        return n+1;
    }
    public static void printDebug(String message){
        if(DEBUG){
            System.out.println(message);
        }
    }
    public static void printArrayInt(int [] array){
        for(int i = 0; i<array.length; i++){
            printDebug(""+ toMathId(i)+ ": " + array[i]);
        }
    }
    public static void printArrayBoolean(boolean [] array){
        for(int i = 0; i<array.length; i++){
            printDebug("" + toMathId(i) + ": " + array[i]);
        }
    }
//------------------------------------- 
//Setters
//-------------------------------------
    public void setEdges(ArrayList <DEdge> edges){
        this.edges = edges;
    }
//------------------------------------- 
// Constructors 
//-------------------------------------
    public PrimsAlgDataStructures(int nrV){
        this.nrV = nrV;
        this.previous = new int [nrV];
        this.distance = new int [nrV];
        this.edges = new ArrayList <DEdge> ();
    }
//-------------------------------------
//Serialization and Print
//-------------------------------------
    public String PrimsAlgToString(){
        String output = "";
        output = output + "{";
        for(int i= 0; i<distance.length ; i++){
            output = output + distance[i];
            output = output + ", ";
        }
        output = output + "}\n";
        return output.replaceAll(", }", "}").replaceAll("2147483647", "INF");
    }
    public void printPrimsAlg(){
        System.out.print(PrimsAlgToString());
    }
    public String PrimsAlgTreeToString(){
        String output = "";
        output = output + "{\n";
         for(int i= 0; i<previous.length; i++){
            if(previous[i] != -1){
                output = output + "{{" + (previous[i]+1) + ",";
                output = output + (i + 1) + "}," + distance[i] + "},";
            }
        }
        output = output + "\n}";
        return output.replaceAll(",\n}", "\n}");
    }
    public void printPrimsAlgTree(){
        System.out.print(PrimsAlgTreeToString());
    }
//-------------------------------------
// WriteToFile
//------------------------------------- 
  public void writeToMathematicaFile(String filename){
    try {
        FileWriter myWriter = new FileWriter(filename); 
        myWriter.write(PrimsAlgToString());
        myWriter.close();
    } 
    catch (IOException e) { 
        System.out.println("An error occurred."); 
        e.printStackTrace();
    } 
    }
    public void writeMSTToMathematicaFile(String filename){
    try {
        FileWriter myWriter = new FileWriter(filename); 
        myWriter.write(PrimsAlgTreeToString());
        myWriter.close();
    } 
    catch (IOException e) { 
        System.out.println("An error occurred."); 
        e.printStackTrace();
    } 
    }
}