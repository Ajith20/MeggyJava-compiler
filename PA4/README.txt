PA4 README

Features implemented:
- Extension of your parser spec to correctly scan all tokens and parse for the PA4 grammar demonstrated with test cases.
- Creates a symbol table that accurately represents the static scoping of the MeggyJava programs of PA4.
- Check for undefined symbols.
- Performs correct type checking for the PA4 grammar rules according to the MJ.jar reference compiler type errors.
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
    
Report and Evaluation of Partner Work (individual):

- What are some organizational strategies that you and your partner are using that are working well?
    - We use Slack to message each other about the project, and write detailed commit messages.  
    
- Specifically how did you and your partner divide the work? (e.g., I wrote the type checker for the following set   of grammar rules...)
    - We both worked on the extension of mjcup.
    - I worked on type checking and the test cases.
    - Ajith worked on AVRgen and the symbol table classes.
    
- How could the division of work between the partners be improved?
    - I think it would be helpful if we collaborated on parts like the symbol table classes, because of how interconnected it is with all of the other parts of the project (type checking, AVRgen, etc.)
    
- How could the interaction between the partners be improved?
    - We could meet in person more often, for pair programming.
