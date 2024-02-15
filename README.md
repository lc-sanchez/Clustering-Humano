# Clustering Humano

## Introducción
El objetivo de este trabajo universitario es implementar una palicación para identificar automáticamente grupos de personas sobre la base de sus características. Tenemos una lista de personas, y para cada persona _i_ tenemos
sus nombres y los siguientes datos:
* _di_= Interés por los deportes
* _mi_= Interés por la música
* _ei_= Interés por las noticias del espectáculo
* _ci_= Interés por la ciencia

Cada uno de estos datos se expresa como un entrero entre 1 y 5, siendo 1 el menor interés y 5 el máximo interés en el tema. Buscamos dividir a esta población en dos grupos con intereses similares. Para esto, utilizamos 
el siguiente algoritmo:
1. Construir un grafo completo G con un vértice por cada persona, una arista entre cada par de personas, y de modo tal que cada arista tiene peso igual al índice de similaridad entre las dos personas.
2. Construir un árbol generador mínimo T de G.
3. Eliminar la arista de mayor peso del árbol T.
4. Las dos componentes conexas del grafo resultanto son los dos grupos que estamos buscando.

El _índice de similaridad_ entre dos personas _i_ y _j_ se define como:
_similaridad(i,j)=|di-dj| + |mi-mj| + |ei-ej| + |ci-cj|_

Este valor es cero cuando _i_ y_j_ tienen exactamente los mismos valores de interés en los cuatro temas, y es más alto para las personas con intereses distintos.

La aplicación implementada cuenta con una interfaz para cargar y visualizar los datos de las personas, y una interfaz para ver los grupos que se formaron luego del algoritmo anterior. Además, se cuenta con un botón para lanzar
la ejecución del algoritmo.

Informe [aquí](https://docs.google.com/document/d/1WLRKWEJa_3ZvKcmxrhayv_CS7G2Juuxm/edit?usp=sharing&rtpof=true&sd=true)
