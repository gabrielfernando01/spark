# =========================================================
# RDDs, Aplicaciones, Broadcast y acumuladores.

# Cargamos los ficheros csv
df = spark.read.options(header='True', inferSchema='True').csv('/home/gabriel/Documentos/scientist/spark/data/cosmetics/csv/*.csv')

# Mostrar el número de registros en la data
df.count()

# Mostrar el esquema del df
df.printSchema()

# Mostrar todas las marcas disponibles
df.select("brand").distinct().show()






