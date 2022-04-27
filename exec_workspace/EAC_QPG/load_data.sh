cqlsh $1 -k eac_qpg < QPG_EAC_CF.cql
dsbulk load -h $1 -k eac_qpg -t cf1  -url csv_output_dir/CF1.csv
dsbulk load -h $1 -k eac_qpg -t cf2  -url csv_output_dir/CF2.csv
dsbulk load -h $1 -k eac_qpg -t cf3  -url csv_output_dir/CF3.csv
dsbulk load -h $1 -k eac_qpg -t cf4  -url csv_output_dir/CF4.csv