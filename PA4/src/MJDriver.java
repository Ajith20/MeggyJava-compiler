/*
 * MJDriver.java
 *
 * usage: 
 *   java MJ [ --two-pass-interpret | --two-pass-mips ] infile
 *
 * This driver either calls a MiniJava interpreter or generates MIPS
 * code to execute the MiniJava program.
 * The default is the interpreter.
 *
 */
import java.io.FileReader;
import java.io.PrintWriter;

import mjparser.*;
import ast_visitors.*;
import ast.node.*;
import ast.visitor.*;
import java.io.PrintStream;
import symtable.*;
public class MJDriver {

      private static void usage() {
          System.err.println(
            "MJ: Specify input file in program arguments");
      }
     
      public static void main(String args[]) 
      {
        
        if(args.length < 1)
        {         
            usage();
            System.exit(1);
        }

        // filename should be the last command line option
        String filename = args[args.length-1];

        try {
          // construct the lexer, 
          // the lexer will be the same for all of the parsers
          Yylex lexer = new Yylex(new FileReader(filename));

          // create the parser
          mj parser = new mj(lexer);
          int lastInPath = filename.lastIndexOf('/');
          parser.programName = filename.substring(lastInPath+1);
          System.out.println("Driver finds input filename: " + parser.programName);

          // print ast to file
          Node ast_root = (Node)parser.parse().value;
          java.io.PrintStream astout =new java.io.PrintStream(new java.io.FileOutputStream(filename + ".ast.dot"));
          ast_root.accept(new DotVisitor(new PrintWriter(astout)));
          System.out.println("Printing AST to " + filename + ".ast.dot");

	        BuildSymbolTable buildSymTable = new BuildSymbolTable();
          ast_root.accept((Visitor)buildSymTable);
          SymTable symTable = buildSymTable.getSymTable(); 
	        java.io.PrintStream stout = new java.io.PrintStream(new java.io.FileOutputStream(filename + ".ST.dot"));
          System.out.println("Printing symbol table to " + filename + ".ST.dot");
          symTable.outputDot((PrintStream)stout); 
          // create Type-Checker and an AVRgenVisitor instances
          symtable.SymTable globalST = new symtable.SymTable();
          //ast_root.accept(new CheckTypes(globalST));
          /*java.io.PrintStream avrsout = new java.io.PrintStream(new java.io.FileOutputStream(filename + ".s"));
          ast_root.accept(new AVRgenVisitor(new PrintWriter(avrsout),globalST));
          System.out.println("Printing Atmel assembly to " + filename + ".s");*/

        } catch(exceptions.SemanticException e) {
            System.err.println(e.getMessage());
            System.exit(1);
       
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }  
      }

}
