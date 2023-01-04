grammar JavaMini;

// starting point for parsing a java file
compilationUnit
    :   typeDeclaration*
        EOF
    ;

typeDeclaration
    :   modifier* classDeclaration
    |   ';'
    ;

classDeclaration
    :   'class' Identifier ('extends' type)? classBody
    ;

modifier
    :   'public'     // class or interface
    |   'protected'  // class or interface
    |   'private'    // class or interface
    |   'abstract'   // class or interface
    |   'static'     // class or interface
    |   'final'      // class only -- does not apply to interfaces
    |   'strictfp'   // class or interface
    ;

classBody
    :   '{' classBodyDeclaration* '}'
    ;

classBodyDeclaration
    :   ';'
    |   modifier* member
    ;

member
    :   methodDeclaration
    |   fieldDeclaration
    |   constructorDeclaration
    |   classDeclaration
    ;

methodDeclaration
    :   type Identifier formalParameters ('[' ']')* methodDeclarationRest
    |   'void' Identifier formalParameters methodDeclarationRest
    ;

methodDeclarationRest
    :   (   methodBody
        |   ';'
        )
    ;

methodBody
    :   block
    ;

formalParameters
    :   '(' formalParameterDecls? ')'
    ;

formalParameterDecls
    :   formalParameter (',' formalParameter)*
    ;

formalParameter
    : modifier* type variableDeclaratorId
    ;

fieldDeclaration
    :   type variableDeclarator ';'
    ;

/*
variableDeclarators
    :   variableDeclarator (',' variableDeclarator)*
    ;
*/
// TODO aufnehmen variable Initializer für Syntax
variableDeclarator
    :   variableDeclaratorId ('=' variableInitializer)?
    ;


variableDeclaratorId
    :   Identifier ('[' ']')*
    ;

variableInitializer
    :   arrayInitializer
    |   expression
    ;

arrayInitializer
    :   '{' (variableInitializer (',' variableInitializer)* (',')? )? '}'
    ;


constructorDeclaration
    :   Identifier
        constructorBody
    ;

constructorBody
    :   block
    ;


// STATEMENTS / BLOCKS

block
    :   '{' blockStatement* '}'
    ;

blockStatement
    :   localVariableDeclaration
    |   classDeclaration
    |   statement
    ;

localVariableDeclaration
    :   modifier* type variableDeclarator ';'
    ;

statement
    : block
    |   'if' '(' expression ')' statement ('else' statement)?
    |   'for' '(' forControl ')' statement
    |   'while' '(' expression ')' statement
    |   'do' statement 'while' '(' expression ')' ';'
    |   'return' expression? ';'
    |   ';'
    |   statementExpression ';'
    |   Identifier ':' statement
    ;

statementExpression
    :   expression
    ;

forControl
    :   forInit? ';' expression? ';' forUpdate?
    ;

forInit
    :   localVariableDeclaration
    |   expressionList
    ;

forUpdate
    :   expressionList
    ;


expression
    :   primary
    |   expression '.' Identifier
    |   expression '[' expression ']'
    |   expression '(' expressionList? ')'
    |   'new' creator
    |   expression ('*'|'/'|'%') expression
    |   expression ('+'|'-') expression
    |   expression ('<' '=' | '>' '=' | '>' | '<') expression
    |   expression ('==' | '!=') expression
    |   expression '&&' expression
    |   expression '||' expression
    |   expression ('++' | '--')
    |   ('+'|'-'|'++'|'--') expression
    |   ('~'|'!') expression
    ;

expressionList
    :   expression (',' expression)*
    ;

creator
    : type '(' expressionList? ')'
    ;

primary
    :   '(' expression ')'
    |   'this'
    |   'super'
    |   literal
    |   Identifier
    |   type '.' 'class'
    |   'void' '.' 'class'
    ;

// EXPRESSIONS


type:   Identifier ('[' ']')*
    |   primitiveType ('[' ']')*
    ;


primitiveType
    :   'boolean'
    |   'char'
    |   'byte'
    |   'short'
    |   'int'
    |   'long'
    |   'float'
    |   'double'
    ;

literal
    :   'true'
    |   'false'
    |   'null'
    |   FloatingPointLiteral
    |   CharacterLiteral
    |   StringLiteral
    ;

// LEXER

// LEXER


DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) ;

FloatingPointLiteral
    :   ('0'..'9')+ '.' ('0'..'9')*
    ;

CharacterLiteral
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\''|'\\')
    ;

Identifier
    :   Letter (Letter|JavaIDDigit)*
    ;

Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

COMMENT
    :   '/*' .*? '*/'    -> channel(HIDDEN) // match anything between /* and */
    ;
WS  :   [ \r\t\u000C\n]+ -> channel(HIDDEN)
    ;

LINE_COMMENT
    : '//' ~[\r\n]* '\r'? '\n' -> channel(HIDDEN)
    ;
