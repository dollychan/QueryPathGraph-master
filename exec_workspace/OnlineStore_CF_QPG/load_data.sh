cqlsh $1 -k onlinestore_qpg < QPG_OnlineStore_CF.cql
dsbulk load -h $1 -k onlinestore_qpg -t q1_2_5  -url csv_output_dir/q1_2_5.csv
dsbulk load -h $1 -k onlinestore_qpg -t q2_1_1  -url csv_output_dir/q2_1_1.csv
dsbulk load -h $1 -k onlinestore_qpg -t q3_1_4_1  -url csv_output_dir/q3_1_4_1.csv
dsbulk load -h $1 -k onlinestore_qpg -t q3_2_1_4_1_3  -url csv_output_dir/q3_2_1_4_1_3.csv
dsbulk load -h $1 -k onlinestore_qpg -t q5_1  -url csv_output_dir/q5_1.csv
dsbulk load -h $1 -k onlinestore_qpg -t q3_2  -url csv_output_dir/q3_2.csv
dsbulk load -h $1 -k onlinestore_qpg -t q6_1  -url csv_output_dir/q6_1.csv
dsbulk load -h $1 -k onlinestore_qpg -t q6_2  -url csv_output_dir/q6_2.csv
dsbulk load -h $1 -k onlinestore_qpg -t q6  -url csv_output_dir/q6.csv
dsbulk load -h $1 -k onlinestore_qpg -t q1  -url csv_output_dir/q5_1.csv
