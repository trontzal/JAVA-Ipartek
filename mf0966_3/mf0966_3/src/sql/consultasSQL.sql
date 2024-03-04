-- 1. Listar los ultimos 5 cursos
SELECT 
    *
FROM
    curso
ORDER BY fInicio DESC
LIMIT 5;

-- 2. Listar los ultimos 5 usuarios creados
SELECT 
    *
FROM
    alumno
ORDER BY codigo DESC
LIMIT 5;

-- 3. Detalle curso mas numero de reseñas
SELECT 
    c.*, COUNT(p.codigo) AS total_puntuaciones
FROM
    curso c
        LEFT JOIN
    puntuacion p ON c.codigo = p.curso_codigo
GROUP BY c.codigo
ORDER BY total_puntuaciones DESC;

-- 4. Listado de usuarios ordenado por numero de reselas
SELECT 
    a.*, COUNT(p.codigo) AS total_resenas
FROM
    alumno a
        LEFT JOIN
    puntuacion p ON a.codigo = p.alumno_codigo
GROUP BY a.codigo
ORDER BY total_resenas DESC;

-- 5. Resumen de numero de cursos de todos los años
SELECT 
    YEAR(fInicio) AS año, COUNT(*) AS numero_cursos
FROM
    curso
GROUP BY YEAR(fInicio)
ORDER BY año;



