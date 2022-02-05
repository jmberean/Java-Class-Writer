package com.pkg; 

/* 
    iput.txt format

    first element: NAME OF CLASS
    all other elements: ATTRIBUTES TYPE + " " + ATTRIBUTE NAME

    Format...

    ClassName
    VarType VarName
    VarType VarName
    VarType VarName

    Example...

    classNameApple
    String color
    int id
    double weight

*/
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;

public class settersGetters{
    public static void main(String[] args) throws Exception{
        String[] s = {"input1.txt","input2.txt","input3.txt"};
        File out = new File("output.txt"); //create and write to this file
        PrintWriter pw = new PrintWriter(out);
        Scanner reader = new Scanner(new File(s[0]));
        List<String> attributeNames = new ArrayList<String>();
        List<String> attributesTypes = new ArrayList<String>();
        List<String> attributeNamesCap = new ArrayList<String>();
        // Find name of class
        String className = reader.next();
        pw.println("// class name");
        pw.println("public class " + className + "{");
        // absoarb the attribute type and name
        while (reader.hasNext()){
            attributesTypes.add(reader.next());
            attributeNames.add(reader.next());
        }
        // print attribute declrations
        pw.println("    // class attributes");
        for(int i = 0; i < attributeNames.size(); i++){
            pw.println("    " + attributesTypes.get(i) + " " + attributeNames.get(i) +";");
        }        

        // print default construcor 
        pw.println("    // default class construcor");
        pw.print("    public " + className + "(){");
        pw.println("");
        pw.println("    }");
        // print constructior
        pw.println("    // class constructor");
        pw.print("    public " + className + "(");
        for(int i = 0; i < attributeNames.size()-1; i++){
            pw.print(" "+ attributesTypes.get(i) + " " + attributeNames.get(i) +",");
        }        
        pw.println(" " + attributesTypes.get(attributesTypes.size()-1) + " " + attributeNames.get(attributeNames.size()-1) +"){");
        // print attribute intitliazation
        for(int i = 0; i < attributeNames.size(); i++){
            pw.println("        this."+ attributeNames.get(i) + " = " + attributeNames.get(i) +";");
        }        
        pw.println("    }");
        // write setters 
        pw.println("    // class setters");
        for(int i = 0; i < attributeNames.size(); i++){
        String str = attributeNames.get(i);
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        attributeNamesCap.add(cap);
        }
        for(int i = 0; i < attributeNames.size(); i++){
            pw.println("    public void set" + attributeNamesCap.get(i) +"(" + attributesTypes.get(i) + " " + attributeNames.get(i) +"){" );
            pw.println("        this." + attributeNames.get(i) + " = " + attributeNames.get(i) + ";\n    }" );
        }       
        // write getters
        pw.println("    // class getters");
        for(int i = 0; i < attributeNames.size(); i++){
            pw.println("    public " + attributesTypes.get(i) + " get" + attributeNamesCap.get(i) +"(){" );
            pw.println("        return this." + attributeNames.get(i) + ";\n    }" );
        }   
        // write toString()
        pw.println("    // toString()");
        pw.println("    public String toString(){");
        pw.print("        return (\""+attributeNames.get(0)+ " = \" + this." + attributeNames.get(0) + " ");
        for(int i = 1; i < attributeNames.size() - 1; i++){

            pw.print(" + \" "+attributeNames.get(i)+ " = \" + this." + attributeNames.get(i) + " ");
        }   
        pw.print(" + \" "+attributeNames.get(attributesTypes.size()-1)+ " = \" + this." + attributeNames.get(attributesTypes.size()-1));

        pw.println(");");
        pw.println("    }");

        // write equals()

        pw.println("    // equals()");
        pw.println("    public boolean equals(" + className + " obj){");
        pw.print("        return (this."+attributeNames.get(0)+ " == obj." + attributeNames.get(0) + " && ");
        for(int i = 1; i < attributeNames.size() - 1; i++){
            pw.print("this."+attributeNames.get(i)+ " == obj." + attributeNames.get(i) + " && ");
        }
        pw.print("this."+attributeNames.get(attributesTypes.size()-1)+ " == obj." + attributeNames.get(attributesTypes.size()-1) + ");");
        pw.println("");   
        pw.println("    }");

        pw.println("}");
        pw.close();
        reader.close();
    }
}
