SELECT DISTINCT 
	CDFICHEROS_CONTRATO.IDFICHERO, 
	CDFICHEROS_CONTRATO.CG_CONTRATO, 
	CDFICHEROS_REGISTRO.MAIL, 
	CDFICHEROS_REGISTRO.ANALIZAR, 
	CDFICHEROS.IDORIGEN, 
	CDFICHEROS.F_DESCARGA_DATOS, 
	CDFICHEROS.TIPO, 
	CDFICHEROS.NOMB_PROCESADO, 
	CDFICHEROS_REGISTRO.NOTIF_URL,
	CDFICHEROS_REGISTRO.ISMOVIL,
	nvl2(CDFICHEROS_CONTRATO.F_PROCESADO,'S','N') as PROCESADO
FROM 
	CDFICHEROS_CONTRATO, 
	CDFICHEROS_REGISTRO, 
	CDFICHEROS
WHERE 
	CDFICHEROS_CONTRATO.IDFICHERO     = CDFICHEROS_REGISTRO.IDFICHERO
	AND CDFICHEROS_CONTRATO.CG_CONTRATO = CDFICHEROS_REGISTRO.CG_CONTRATO
	AND CDFICHEROS.IDFICHERO            = CDFICHEROS_CONTRATO.IDFICHERO
	AND CDFICHEROS_REGISTRO.PROCESADA = 'N' 
	AND CDFICHEROS_REGISTRO.TIPO = 'UP'
    AND CDFICHEROS_REGISTRO.F_ALTA > SYSDATE -10
ORDER BY
	CDFICHEROS_CONTRATO.IDFICHERO
