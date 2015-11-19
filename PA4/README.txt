PA4 README

Features implemented:
- Extension of your parser spec to correctly scan all tokens and parse for the PA4 grammar demonstrated with test cases.
- Creates a symbol table that accurately represents the static scoping of the MeggyJava programs of PA4.
- Check for undefined symbols.
- Performs correct type checking for the PA4 grammar rules according to the MJ.jar reference compiler type errors.
  - LT node
  - Meggy.toneStart
- Continues to perform code generation to AVR assembly code for the PA3 AST nodes using a visitor.
- Performs correct code generation to AVR assembly code for the added features in PA4 grammar.
  - Meggy.toneStart
- Test cases for PA4 features.
- README file
- Follows instructions for submission correctly.

Features not implemented (so far):
- Check for doubly defined and incorrectly typed symbols.
- User-defined methods (AVR)
- Method calls (AVR)

Test Cases provided:
- PA4doubleDef.java
- PA4incorrectType.java
- PA4noDef.java
- PA4ExampleRef.java
- PA4Example1.java
- PA4Example2.java
- PA4Example3.java
- PA4Example4.java
- PA4Example5.java
- PA4bluedot.java
- PA4MazeSolver.java

Notes:
- Our PA3 TypeChecking specification was provided by Taghreed Bagies.
- To demonstrate AVR code generation on .java files that might be getting unneccessary errors from the type checker, comment out the following line from MJDriver.java:
  ast_root.accept(new CheckTypes(symTable));

Report and Evaluation of Partner Work (joint):

- Who is going to do what?  The plan:
    - We will work equally on the extension of mjcup, the symbol table, AVRgen and type checking.
    
- Who is going to do what?  The reality:
    - Both of us: Extension of your parser spec to correctly scan all tokens and parse for the PA4 grammar demonstrated with test cases
    - Ajith: Creates a symbol table that accurately represents the static scoping of the MeggyJava programs of PA4
    - Joe: Check for undefined, doubly defined, and incorrectly typed symbols
    - Joe: Performs correct type checking for the PA4 grammar rules according to the MJ.jar reference compiler type errors
    - Ajith: Continues to perform code generation to AVR assembly code for the PA3 AST nodes using a visitor
    - Performs correct code geneation to AVR assembly code for the added features in PA4 grammar:
        Ajith: Meggy.toneStart
        Ajith: less than operator
        Ajith: user-defined methods
        Ajith: method calls
    - Joe: Test cases for PA4 features
    - Joe: README file explaining the file structure (your test files) and other comments you want your TA to know (e.g. features not implemented)
    
- How is the testing going to be done? What actually happened:
    - Whoever adds features to the compiler will test those features.  This is what happened.
    
- Timeline for finishing portions of assignment:
    - We didn't make a timeline, we just worked on it whenever we had time and let each other know when we pushed to the repo.
    
- Meeting schedule:
    - We used Slack to message each other, talked about the project after classes, and sometimes met to work on it in Smith.
