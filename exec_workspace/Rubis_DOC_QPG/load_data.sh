mongo --host $1 --port 20000 QPG_Rubis_Bidding_Index.js


for((i=0; i < 20; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=users --file=csv_output_dir/Users_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=users --file=csv_output_dir/Users_$i.json
done

for((i=0; i < 20; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=categories --file=csv_output_dir/Categories_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=categories --file=csv_output_dir/Categories_$i.json
done

for((i=0; i < 20; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=items --file=csv_output_dir/Items_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=items --file=csv_output_dir/Items_$i.json
done

for((i=0; i < 20; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=comments --file=csv_output_dir/Comments_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=comments --file=csv_output_dir/Comments_$i.json
done

for((i=0; i < 20; i++))
do
  echo "mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=regions --file=csv_output_dir/Regions_$i.json"
  mongoimport --host=$1 --port=20000 --db=rubis_bidding_qpg --collection=regions --file=csv_output_dir/Regions_$i.json
done

