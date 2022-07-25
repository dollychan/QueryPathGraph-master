parser grammar ExecPlanParser;
options{
    tokenVocab = ExecPlanLexer;
}

@header { package com.qpg.expr.execplan.parser; }

input:
    (stmt)*  EOF
    ;

stmt: data_type_stmt
    | data_range_stmt
    | exec_query_stmt
    | exec_update_stmt
    ;

data_range_stmt: DATA_ RANGE_ LBRACE data_range (COMMA data_range)* RBRACE
;
data_range: attr_name COLON LBRACKET min_num COMMA max_num RBRACKET;

data_type_stmt: DATA_ TYPE_ LBRACE attr_name type (COMMA attr_name type)* RBRACE
;

exec_query_stmt: EXEC_ QUERY_ query_name LBRACE query_stmt (COMMA query_stmt )*  RBRACE;
query_stmt:  query_table | (FILTER_ ia_attrs);
query_table: table_name ea_attrs ia_attrs oa_attrs pa_attrs (attr_name COLON attr_name (COMMA attr_name COLON attr_name)*)?;
attr_lists: LBRACKET (attr_name (COMMA attr_name)*)? RBRACKET;
ea_attrs: attr_lists;
ia_attrs: LBRACKET (attr_name OP (COMMA attr_name OP)*)? RBRACKET;
oa_attrs: attr_lists;
pa_attrs: attr_lists;

exec_update_stmt: EXEC_ UPDATE_ update_name LBRACE update_stmt (COMMA update_stmt)* RBRACE;

update_stmt: update_stmt1 | update_stmt2;

update_stmt1: table_name (QUERY_ ea_attrs)? (UPDATE_|INSERT_) attr_lists;

update_stmt2: QUERY_ table_name ea_attrs attr_lists (UPDATE_|INSERT_) table_name ea_attrs attr_lists ;

type: INT_ | DATE_ | STRING_ | FLOAT_;

keyword: DATA_ | RANGE_ | EXEC_ | QUERY_ | UPDATE_ | INSERT_;
any_name: ID | keyword | STRING_LITERAL;
update_name: any_name;
query_name: any_name;
table_name: any_name;
attr_name: any_name;
min_num:NUMERIC_LITERAL;
max_num:NUMERIC_LITERAL;
