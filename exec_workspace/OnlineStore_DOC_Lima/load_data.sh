mongo --host $1 --port 20000 Lima_OnlineStore_Index.js

for((i=0; i < 10; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=onlinestore_lima --collection=customer --file=csv_output_dir/Customer_$i.json"
  mongoimport --host=$1 --port=20000 --db=onlinestore_lima --collection=customer --file=csv_output_dir/Customer_$i.json
done

echo "supplier"
mongoimport --host=$1 --port=20000 --db=onlinestore_lima --collection=supplier --file=csv_output_dir/Supplier_0.json

echo "product"
mongoimport --host=$1 --port=20000 --db=onlinestore_lima --collection=product --file=csv_output_dir/Product_0.json

echo "category"
mongoimport --host=$1 --port=20000 --db=onlinestore_lima --collection=category --file=csv_output_dir/Category_0.json

echo "carrier"
mongoimport --host=$1 --port=20000 --db=onlinestore_lima --collection=carrier --file=csv_output_dir/Carrier_0.json