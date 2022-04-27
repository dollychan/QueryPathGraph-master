lexer grammar WorkloadLexer;
@header { package com.qpg.parser.antlr; }

DOT: '.';
COMMA: ',';
COLON: ':';
SEMICOLON: ';';
OPEN_PAR:  '(';
CLOSE_PAR: ')';
ASSIGN:    '=';
STAR:      '*';
PLUS:      '+';
MINUS:     '-';
TILDE:     '~';
PIPE2:     '||';
DIV:       '/';
MOD:       '%';
LT2:       '<<';
GT2:       '>>';
AMP:       '&';
PIPE:      '|';
LT:        '<';
LT_EQ:     '<=';
GT:        '>';
GT_EQ:     '>=';
EQ:        '==';
NOT_EQ1:   '!=';
NOT_EQ2:   '<>';

QUESTION_MARK: '?';
LBRACE: '{';
RBRACE: '}';
LBRACKET: '[';
RBRACKET: ']';

SELECT: S  E  L  E  C  T;
FROM : F  R  O  M;
WHERE : W  H  E  R  E;
REL : R  E  L;
ORDER: O  R  D  E  R;
BY: B  Y;
AND: A  N  D;
CLASS: C L A S S ;
DESC_: D E S C;
ASC_ : A S C;
INT_: I N T;
STRING_: S T R I N G;
DATE_: D A T E;
FLOAT_: F L O A T;
K_:  K ;
HW_: H W;

ID:    ( 'A'..'Z' | 'a'..'z' | '_' | '$') ( 'A'..'Z' | 'a'..'z' | '_' | '$' | '0'..'9' )*;
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



