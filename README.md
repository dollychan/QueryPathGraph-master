# QueryPathGraph-master
A Workload-driven Method for Designing NoSQL Database Schemas

To generate NoSQL schema:

> qpg-core/src/main/java/com/qpg/QPGRunner.java

The conceptual models and workloads of case studies are provided under directory:

> qpg-core/src/main/resources/casestudy/*.info

For example, in exec_workspace/Rubis_QPG:

  > *.cql -- for Cassandra
  
  > *.EXECPLAN -- execution plans 
  
 > workload.config -- parameter to run workload-expr/src/main/java/com/qpg/expr/WorkloadMain.java
  
For example, in exec_workspace/Test_Rubis:

 > *.config -- for test multiple databases by the same workload instance
