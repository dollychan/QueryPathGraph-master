cqlsh $1 -k eac_nose < NoSE_EAC_CF.cql
dsbulk load -h $1 -k eac_nose -t cf1  -url csv_output_dir/CF1.csv
dsbulk load -h $1 -k eac_nose -t cf2  -url csv_output_dir/CF2.csv
dsbulk load -h $1 -k eac_nose -t cf3  -url csv_output_dir/CF3.csv
dsbulk load -h $1 -k eac_nose -t cf4  -url csv_output_dir/CF4.csv
dsbulk load -h $1 -k eac_nose -t cf5  -url csv_output_dir/CF5.csv