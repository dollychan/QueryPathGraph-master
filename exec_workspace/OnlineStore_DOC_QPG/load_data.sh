mongo --host $1 --port 20000 QPG_OnlineStore_Index.js

:"
for((i=0; i < 30; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=customer --file=csv_output_dir_1/Customer_$i.json"
  mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=customer --file=csv_output_dir/Customer_$i.json
done

for((i=0; i < 30; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=order --file=csv_output_dir/Order_$i.json"
  mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=order --file=csv_output_dir/Order_$i.json
done

for((i=0; i < 30; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=product --file=Product_$i.json"
  mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=product --file=csv_output_dir/Product_$i.json
done

echo "mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=category --file=csv_output_dir/Category_0.json"
mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=category --file=csv_output_dir/Category_0.json

echo "mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=supplier --file=csv_output_dir/Supplier_0.json"
mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=supplier --file=csv_output_dir/Supplier_0.json

echo "mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=carrier --file=csv_output_dir/Carrier_0.json"
mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=carrier --file=csv_output_dir/Carrier_0.json
"

for((i=0; i < 30; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=product --file=Product2_$i.json"
  mongoimport --host=$1 --port=20000 --db=onlinestore_qpg --collection=product2 --file=csv_output_dir/Product2_$i.json
done
