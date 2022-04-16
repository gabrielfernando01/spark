# =========================================================
# RDDs, Aplicaciones, Broadcast y acumuladores.

# Cargamos los ficheros csv
df = spark.read.options(header='True', inferSchema='True').csv('/home/gabriel/Documentos/scientist/spark/data/cosmetics/csv/*.csv')








