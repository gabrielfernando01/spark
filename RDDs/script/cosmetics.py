# Cargamos los datasets
df = spark.read.options(header='True', inferSchema='True').csv('/home/gabriel/Documentos/scientist/spark/data/cosmetics/csv/*.csv')

# Numero de registros
df.count()

# Estructura del dataFrame
df = df.printSchema()

# Para listar los distintos tipos de eventos
df.select("event_type").distinct().show()

# Proveedores o marcas disponebles
df.select("brand").distinct().show()

# Para listar los productos que han sido metidos al carrito
df.select(["product_id"]).filter("event_type='cart'").show()

# Tomemos el primero de la lista
df.select(["product_id"]).filter("event_type='cart'").first()
:w
