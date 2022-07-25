mongo --host $1 --port 20000 NF_Rubis_Index.js


for((i=0; i < 10; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=users --file=csv_output_dir/Users_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=users --file=csv_output_dir/Users_$i.json
done

for((i=0; i < 10; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=items --file=csv_output_dir/Items_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=items --file=csv_output_dir/Items_$i.json
done


for((i=0; i < 10; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=regions --file=csv_output_dir/Regions_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=regions --file=csv_output_dir/Regions_$i.json
done


for((i=0; i < 10; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=categories --file=csv_output_dir/Categories_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=categories --file=csv_output_dir/Categories_$i.json
done


for((i=0; i < 10; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=bids --file=csv_output_dir/Bids_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=bids --file=csv_output_dir/Bids_$i.json
done


for((i=0; i < 10; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=buynow --file=csv_output_dir/Buynow_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=buynow --file=csv_output_dir/Buynow_$i.json
done

for((i=0; i < 10; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=comments --file=csv_output_dir/Comments_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_nf --collection=comments --file=csv_output_dir/Comments_$i.json
done

