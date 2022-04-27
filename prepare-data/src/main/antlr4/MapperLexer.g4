lexer grammar MapperLexer;
@header { package com.qpg.dataTransformer.parser; }

COLON : ':';
COMMA: ',';
LBRACE: '{';
RBRACE: '}';
LPAR:'(';
RPAR:')';

ASSIGN: '=' ;
QUESTION_MARK: '?';

TARGET_: T A R G E T ;
CF_ : C F ;
DOC_ : D O C ;
KV_ : K V ;
SQL_ : S Q L ;
ISLIST_ : I S L I S T ;

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