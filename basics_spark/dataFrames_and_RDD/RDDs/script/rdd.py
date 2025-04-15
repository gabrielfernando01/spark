# =========================================================
# RDDs, Aplicaciones, Broadcast y acumuladores.

# Cargamos los ficheros csv
df = spark.read.options(header='True', inferSchema='True').csv('/home/gabi/Documentos/scientist/spark/data/cosmetics/csv/*.csv')

# Mostrar el número de registros en la data
df.count()

# Mostrar el esquema del df
df.printSchema()

# Mostrar todas las marcas disponibles
df.select("brand").distinct().show()

# Creamos una función para crear un contador con lambda
def myFunc(s):
    if s["brand"]=="riche" and s["event_type"]=="cart":
        return[(s["product_id"], 1)]
    return[]

# Map, reducyByKey y lambda
lines = df.rdd.flatMap(myFunc).reduceByKey(lambda a, b: a+b)

# Usamos collect() para visualizar todo lo realizado por el RDD
for e in lines.collect():
    print(e)

# Si queremos ver los primeros 20 productos de nuestra lista
print(lines.take(20))

# Convertir el RDD en un dataFrame
lines.toDF().show()

# Guardar la lista en un directorio
lines.saveAsTextFile("/home/gabi/Documentos/scientist/spark/data/cosmetics/result2")




