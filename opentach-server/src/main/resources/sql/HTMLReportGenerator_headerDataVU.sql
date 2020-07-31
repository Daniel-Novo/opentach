SELECT 
	DFEMP.CIF, 
	DFEMP.NOMB, 
	CDVEHICULOS_EMP.MATRICULA
FROM 
	CDFICHEROS, 
	CDFICHEROS_CONTRATO, 
	CDVEMPRE_REQ_REALES, DFEMP, 
	CDVEHICULOS_EMP
WHERE 
	CDFICHEROS.IDFICHERO = CDFICHEROS_CONTRATO.IDFICHERO 
	AND CDFICHEROS_CONTRATO.CG_CONTRATO = CDVEMPRE_REQ_REALES.NUMREQ
	AND CDVEMPRE_REQ_REALES.CIF 		= DFEMP.CIF 
	AND CDVEMPRE_REQ_REALES.CIF 		= CDVEHICULOS_EMP.CIF
	AND CDFICHEROS.IDORIGEN = CDVEHICULOS_EMP.MATRICULA
	AND CDFICHEROS.IDFICHERO = ?