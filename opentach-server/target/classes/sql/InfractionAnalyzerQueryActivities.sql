SELECT 
	ACT.TPACTIVIDAD,
	ACT.FEC_COMIENZO,
	ACT.MINUTOS,
	ACT.FEC_FIN,
	ACT.ORIGEN,
	ACT.REGIMEN,
	ACT.TRANS_TREN
FROM 
	CDACTIVIDADES ACT 
WHERE	 
	ACT.NUMREQ = ?
	AND ACT.IDCONDUCTOR = ?
	AND FEC_COMIENZO>=?
	AND FEC_COMIENZO<=?
ORDER BY 
	ACT.FEC_COMIENZO,
	PROCEDENCIA