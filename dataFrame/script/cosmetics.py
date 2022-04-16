# Cargamos los datasets
df = spark.read.options(header='True', inferSchema='True').csv('/home/gabriel/Documentos/scientist/spark/data/cosmetics/csv/*.csv')

# Numero de registros
df.count()

# Estructura del dataFrame
df.printSchema()

# Para listar los distintos tipos de eventos
df.select("event_type").distinct().show()

# Proveedores o marcas disponebles
df.select("brand").distinct().show()

# Para listar los productos que han sido metidos al carrito
df.select(["product_id"]).filter("event_type='cart'").show()

# Tomemos el primero de la lista
df.select(["product_id"]).filter("event_type='cart'").first()

# Crear el objeto, sesiones en las cuales el producto ha sido elegido
sessions = df.select(["user_session"]).filter("event_type='cart' AND product_id=4958")

# Productos que hayan sido elegidos en el objeto sessions.
products = df.select(["product_id"]).filter("event_type='cart' AND product_id<>4958").filter(df["user_session"].isin(sessions["user_session"]))

# Lista de productos_id que se han escogido junto el producto original
products.select("product_id").show()

# Queremos una lista de productos únicos
products = products.select("product_id").distinct()
products.select("product_id").count()

# Vamos a guardar esta lista, pensando que la reutilizariamos
products.write.mode("overwrite").csv('/home/gabriel/Documentos/scientist/spark/data/cosmetics/result1')

# Crear una lista temporal de nuestro dataFrame, para usar spark.sql
df.createOrReplaceTempView("data")

# Hacemos una consulta de los primeros 3 registros
spark.sql("SELECT * FROM data LIMIT 3").show()

# Query con el tipo de evento 'cart'
spark.sql("SELECT * FROM data WHERE event_type='cart' LIMIT 3").show()

# Contar el número de registros que fueron tomados en carito
spark.sql("SELECT COUNT(*) FROM data WHERE event_type='cart'").show()

