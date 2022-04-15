i# cargamos los datasets
df = spark.read.options(header='True', inferSchema='True').csv('/home/gabriel/Documentos/scientist/spark/data/cosmetics/csv/*.csv')

# numero de registros
df.count()
