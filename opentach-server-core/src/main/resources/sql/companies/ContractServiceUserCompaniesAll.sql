SELECT 
	DFEMP.CIF, 
	DFEMP.NOMB 
FROM 
	CDUSU_DFEMP, 
	DFEMP, 
	CDUSU
WHERE 
	CDUSU_DFEMP.CIF = DFEMP.CIF
	AND CDUSU_DFEMP.USUARIO = CDUSU.USUARIO
	AND CDUSU.NIVEL_CD !='5'		
	AND CDUSU.USUARIO = ?
UNION ALL
SELECT 
   DFEMP.CIF,
   DFEMP.NOMB
FROM  
	CDUSU_DFEMP, 
	CDUSU, 
	DFEMP
WHERE 
	CDUSU_DFEMP.CIF = DFEMP.CIF_COOPERATIVA
	AND CDUSU_DFEMP.USUARIO = CDUSU.USUARIO
	AND CDUSU.NIVEL_CD !='5'		
	AND CDUSU.USUARIO = ?