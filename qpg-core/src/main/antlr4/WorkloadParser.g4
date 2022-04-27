parser grammar WorkloadParser;
options{
    tokenVocab = WorkloadLexer;
}

@header { package com.qpg.parser.antlr; }
input:
    (stmt)*  EOF
    ;


card_ratio: LBRACKET (NUMERIC_LITERAL | STAR) RBRACKET;
class_attr : class_name DOT attr_name;
attr_type: INT_|STRING_|FLOAT_|DATE_;
any_name:
    ID
    | keyword
    | STRING_LITERAL
    | OPEN_PAR any_name CLOSE_PAR
;
keyword: SELECT|FROM | WHERE| REL | ORDER | BY | AND | CLASS | INT_ | STRING_ | DATE_ | FLOAT_ | HW_;
class_name : any_name;
attr_name: any_name ;
rel_name: any_name;

stmt:
    classStmt
    | rel_stmt
    | queryStmt
;

freq: NUMERIC_LITERAL;

classStmt: CLASS class_name NUMERIC_LITERAL? LBRACE (attr_stmt)(COMMA attr_stmt)* RBRACE freq?
;
attr_stmt: attr_type (STAR)? attr_name (attr_pk)?
;
attr_pk : LBRACKET K_ RBRACKET
;

rel_stmt: REL rel_name COLON class_name card_ratio COMMA class_name card_ratio
     (LBRACKET attr_stmt (COMMA attr_stmt)* RBRACKET)? SEMICOLON freq?
;

queryStmt:
       SELECT class_attr (COMMA class_attr)*
       FROM tablePath (COMMA tablePath)*
       ( whereClause )?
       ( orderByClause )?
       SEMICOLON freq?
;

tablePath : table_name (DOT rel_name DOT table_name)*
 ;

table_name : any_name ( ASSIGN class_name)?
;

whereClause
    : WHERE (expr)  (AND expr)*
    ;
expr:
    class_attr (ASSIGN | LT | GT | LT_EQ | GT_EQ | NOT_EQ1 | NOT_EQ2) QUESTION_MARK
;

orderByClause
    : ORDER BY orderEle (COMMA orderEle)*
 ;
orderEle: class_attr asc_desc? ;
asc_desc: ASC_ | DESC_;

