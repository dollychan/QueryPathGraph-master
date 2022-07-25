parser grammar SQLtoNoSQLMapper;
options{
    tokenVocab = MapperLexer;
}

@header { package com.qpg.dataTransformer.parser; }

input: TARGET_ COLON (CF_ | DOC_ | KV_)
        (tree)*;

tree: tree_node;

tree_node: node_name ISLIST_? (SQL_ COLON STRING_LITERAL) bound_attrs? children_node?;
node_name: ID;

children_node:
     LBRACE tree_node  (COMMA tree_node)* RBRACE;

bound_attrs: LPAR ID (COMMA ID)* RPAR;