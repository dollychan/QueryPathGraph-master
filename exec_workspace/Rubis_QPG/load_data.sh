cqlsh $1 -k rubis_qpg < QPG_Rubis_CF_all.cql
dsbulk load -h $1  -k rubis_qpg -t q5_12  -url csv_output_dir/Q5_12.csv
dsbulk load -h $1  -k rubis_qpg -t q15  -url csv_output_dir/Q15.csv
dsbulk load -h $1  -k rubis_qpg -t q16  -url csv_output_dir/Q16.csv
dsbulk load -h $1  -k rubis_qpg -t q1_7_9_14  -url csv_output_dir/Q1_7_9_14.csv
dsbulk load -h $1  -k rubis_qpg -t q17  -url csv_output_dir/Q17.csv
dsbulk load -h $1  -k rubis_qpg -t q18  -url csv_output_dir/Q18.csv
dsbulk load -h $1  -k rubis_qpg -t q19  -url csv_output_dir/Q19.csv
dsbulk load -h $1  -k rubis_qpg -t q20  -url csv_output_dir/Q20.csv
dsbulk load -h $1  -k rubis_qpg -t q2  -url csv_output_dir/Q2.csv
dsbulk load -h $1  -k rubis_qpg -t q3_10_11_13  -url csv_output_dir/Q3_10_11_13.csv
dsbulk load -h $1  -k rubis_qpg -t q3_10_11_13_18_1 -url csv_output_dir/Q3_10_11_13.csv
dsbulk load -h $1  -k rubis_qpg -t q4  -url csv_output_dir/Q4.csv
dsbulk load -h $1  -k rubis_qpg -t q6  -url csv_output_dir/Q6.csv
dsbulk load -h $1  -k rubis_qpg -t q8  -url csv_output_dir/Q8.csv
dsbulk load -h $1  -k rubis_qpg -t q4_2  -url csv_output_dir/Q4_2.csv
dsbulk load -h $1  -k rubis_qpg -t q15_2  -url csv_output_dir/Q15_2.csv
dsbulk load -h $1  -k rubis_qpg -t q18_2  -url csv_output_dir/Q18_2.csv
dsbulk load -h $1  -k rubis_qpg -t q16_2  -url csv_output_dir/Q16_2.csv