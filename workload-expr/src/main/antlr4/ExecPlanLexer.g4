lexer grammar ExecPlanLexer;
@header { package com.qpg.expr.execplan.parser; }

COLON : ':';
COMMA: ',';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';
LPAR:'(';
RPAR:')';

OP: '<'| '<=' | '>' | '>=' | '!=' | '<>' | '=' ;

DATA_: D A T A ;
TYPE_: T Y P E ;
RANGE_: R A N G E ;
EXEC_: E X E C ;
QUERY_: Q U E R Y ;
UPDATE_: U P D A T E ;
FILTER_: F I L T E R ;
INSERT_: I N S E R T;
INT_: I N T;
STRING_: S T R I N G;
DATE_: D A T E;
FLOAT_: F L O A T;


ID:    ( 'A'..'Z' | 'a'..'z' | '_' | '$' | '.') ( 'A'..'Z' | 'a'..'z' | '_' | '$' | '0'..'9' | '.' )*;
NUMERIC_LITERAL: ((DIGIT+ ('.' DIGIT*)?) | ('.' DIGIT+)) (E [-+]? DIGIT+)? | '0x' HEX_DIGIT+;
STRING_LITERAL: '\'' ( ~'\'' | '\'\'')* '\'';

SINGLE_LINE_COMMENT: '--' ~[\r\n]* (('\r'? '\n') | EOF) -> channel(HIDDEN);
MULTILINE_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);

fragment A      : [aA];
fragment B      : [bB];
fragment C      : [cC];
fragment D      : [dD];
fragment E      : [eE];
fragment F      : [fF];
fragment G      : [gG];
fragment H      : [hH];
fragment I      : [iI];
fragment J      : [jJ];
fragment K      : [kK];
fragment L      : [lL];
fragment M      : [mM];
fragment N      : [nN];
fragment O      : [oO];
fragment P      : [pP];
fragment Q      : [qQ];
fragment R      : [rR];
fragment S      : [sS];
fragment T      : [tT];
fragment U      : [uU];
fragment V      : [vV];
fragment W      : [wW];
fragment X      : [xX];
fragment Y      : [yY];
fragment Z      : [zZ];
fragment HEX_DIGIT:                  [0-9A-F];
fragment DIGIT:                  [0-9];
fragment LETTER:                         [a-zA-Z];

WS  :   [ \t\r\n]+ -> skip ;