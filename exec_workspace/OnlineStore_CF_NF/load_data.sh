cqlsh $1 -k onlinestore_nf < NF_OnlineStore_CF.cql
dsbulk load -h $1 -k onlinestore_nf -t carrier  -url csv_output_dir/carrier.csv
dsbulk load -h $1 -k onlinestore_nf -t category  -url csv_output_dir/category.csv
dsbulk load -h $1 -k onlinestore_nf -t customer  -url csv_output_dir/customer.csv
dsbulk load -h $1 -k onlinestore_nf -t item  -url csv_output_dir/item.csv
dsbulk load -h $1 -k onlinestore_nf -t orders  -url csv_output_dir/orders.csv
dsbulk load -h $1 -k onlinestore_nf -t product  -url csv_output_dir/product.csv
dsbulk load -h $1 -k onlinestore_nf -t supplier  -url csv_output_dir/supplier.csv
