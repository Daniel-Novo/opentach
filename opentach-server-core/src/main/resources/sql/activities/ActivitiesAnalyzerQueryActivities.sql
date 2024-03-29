SELECT
	TPACTIVIDAD,
	FEC_COMIENZO,
	FEC_FIN,
	RANURA,
	ESTADO_TRJ_RANURA,
	FUERA_AMBITO,
	TRANS_TREN,
	PROCEDENCIA,
	ORIGEN,
	REGIMEN,
	MATRICULA, 
	NUM_TARJ
FROM 
	(SELECT 
			TPACTIVIDAD,
			FEC_COMIENZO,
			FEC_FIN,RANURA,
			ESTADO_TRJ_RANURA,
			FUERA_AMBITO,
			TRANS_TREN,
			PROCEDENCIA,
			ORIGEN,
			REGIMEN,
			MATRICULA, 
			NUM_TARJ,
			DECODE ( LEAD(FEC_COMIENZO,1,SYSDATE) OVER (ORDER BY FEC_COMIENZO,PROCEDENCIA DESC),FEC_COMIENZO,1,0) AS CONTROL
		FROM 
			CDACTIVIDADES
		WHERE 
			NUMREQ=? 
			AND IDCONDUCTOR=? 
			AND FEC_COMIENZO<=? 
			AND FEC_FIN>=?
			%NUMTRJ% 
	)	
WHERE
	CONTROL <> 1
ORDER BY 
	FEC_COMIENZO,
	PROCEDENCIA desc