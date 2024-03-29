ALTER TABLE CDVEHICULOS_EMP ADD MARCA VARCHAR2(50)
/
ALTER TABLE CDVEHICULOS_EMP ADD MODELO VARCHAR2(50)
/
ALTER TABLE CDVEHICULOS_EMP ADD ANYO VARCHAR2(4)
/
ALTER TABLE CDVEHICULOS_EMP ADD DESCARGA_REMOTA VARCHAR2(50)
/
ALTER TABLE CDVEHICULOS_EMP ADD PROVEEDOR_DESC_REMOTA VARCHAR2(50)
/
ALTER TABLE CDVEHICULOS_EMP ADD LOCALIZACION VARCHAR2(50)
/
ALTER TABLE CDVEHICULOS_EMP ADD PROVEEDOR_LOCALIZACION VARCHAR2(50)
/
ALTER TABLE CDVEHICULOS_EMP ADD DIAGNOSIS VARCHAR2(50)
/
ALTER TABLE CDVEHICULOS_EMP ADD PROVEEDOR_DIAGNOSIS VARCHAR2(50)
/
CREATE OR REPLACE VIEW CDVVEHICULOS_EMP AS 
  SELECT CDVEHICULOS_EMP.CIF,
    EMPRE_REQ.NOMB,
    CDVEHICULOS_EMP.MATRICULA,
    CDVEHICULOS_EMP.DSCR,
    CDVEHICULOS_EMP.F_ALTA,
    CDVEHICULOS_EMP.USUARIO_ALTA,
    CDVEHICULOS_EMP.OBSR,
    CDVEHICULOS_EMP.IDDELEGACION,
    CDVEHICULOS_EMP.DURMIENTE,
    CDVEHICULO_CONT.F_BAJA,
    CDVEHICULOS_EMP.IDVEHICLETYPE,
	CDVEHICULOS_EMP.MARCA,
	CDVEHICULOS_EMP.MODELO,
	CDVEHICULOS_EMP.ANYO,
	CDVEHICULOS_EMP.DESCARGA_REMOTA,
	CDVEHICULOS_EMP.PROVEEDOR_DESC_REMOTA,
	CDVEHICULOS_EMP.LOCALIZACION,
	CDVEHICULOS_EMP.PROVEEDOR_LOCALIZACION,
	CDVEHICULOS_EMP.DIAGNOSIS,
	CDVEHICULOS_EMP.PROVEEDOR_DIAGNOSIS,
	PROVINCIAS.CG_PROV,
	PROVINCIAS.NOMB AS PROVINCIA
  FROM CDVEHICULOS_EMP,
    CDVEHICULO_CONT,
     (SELECT
      CDEMPRE_REQ.CIF,
      CDEMPRE_REQ.NUMREQ,
      DFEMP.NOMB,
	  DFEMP.CG_PROV
      FROM CDEMPRE_REQ, DFEMP
      WHERE CDEMPRE_REQ.CIF = DFEMP.CIF AND  FICTICIO!='S' 
      UNION ALL
      SELECT
      DFEMP.CIF,
      EMP.NUMREQ,
      DFEMP.NOMB,
	  DFEMP.CG_PROV
      FROM CDEMPRE_REQ REQ ,DFEMP, CDEMPRE_REQ EMP, DFEMP DF2
      WHERE 
      REQ.CIF = DFEMP.CIF AND REQ.FICTICIO='S' AND DFEMP.CIF_COOPERATIVA = EMP.CIF AND DF2.CIF = REQ.CIF) EMPRE_REQ, PROVINCIAS
  WHERE CDVEHICULOS_EMP.CIF       = EMPRE_REQ.CIF
  AND CDVEHICULO_CONT.CG_CONTRATO =EMPRE_REQ.NUMREQ
  AND CDVEHICULOS_EMP.MATRICULA   = CDVEHICULO_CONT.MATRICULA
 AND PROVINCIAS.CG_PROV(+) = EMPRE_REQ.CG_PROV
/
---------------------------------
 --------------agreements---------------------
 --------------------------------------
 CREATE TABLE LAB_AGREEMENT 
   (	AGR_ID NUMBER NOT NULL ENABLE, 
	AGR_NAME VARCHAR2(300 BYTE) NOT NULL ENABLE, 
	AGR_MODALITY VARCHAR2(50 BYTE), 
	AGR_DAILY_MINUTES NUMBER, 
	AGR_WEEKLY_MINUTES NUMBER, 
	AGR_ANNUAL_MINUTES NUMBER, 
	AGR_ALGORITHM VARCHAR2(800 BYTE), 
	AGR_MONTHLY_MINUTES NUMBER, 
	AGR_BIWEEKLY_MINUTES NUMBER, 
	AGR_F_BAJA DATE, 
	AGR_LIMIT_ALGORITHM VARCHAR2(800 BYTE), 
	 CONSTRAINT LAB_AGREEMENT_PK PRIMARY KEY (AGR_ID))
/     
ALTER TABLE CDCONDUCTORES_EMP ADD AGR_ID NUMBER
/
ALTER TABLE CDCONDUCTORES_EMP ADD CONTRACT_TYPE VARCHAR2(20)
/
ALTER TABLE CDCONDUCTORES_EMP ADD CONSTRAINT LAB_AGREEMENT_FK FOREIGN KEY (AGR_ID)  REFERENCES LAB_AGREEMENT(AGR_ID) ENABLE
/  
CREATE OR REPLACE VIEW CDVCONDUCTORES_EMP AS 
  SELECT
	CDCONDUCTORES_EMP.CIF,
	CDCONDUCTORES_EMP.IDCONDUCTOR,
	CDCONDUCTORES_EMP.DNI,
	CDCONDUCTORES_EMP.NOMBRE,
	CDCONDUCTORES_EMP.APELLIDOS,
	CDCONDUCTORES_EMP.APELLIDOS||', '||CDCONDUCTORES_EMP.NOMBRE AS NOMBRECOMPLETO,
	CDCONDUCTORES_EMP.MOVIL,
	CDCONDUCTORES_EMP.EMAIL,
	CDCONDUCTORES_EMP.OBSR,
	CDCONDUCTORES_EMP.PHOTO,
	CDCONDUCTORES_EMP.F_ALTA,
	CDCONDUCTORES_EMP.USUARIO_ALTA,
	CDCONDUCTORES_EMP.IDDELEGACION,
	CDCONDUCTORES_EMP.DURMIENTE,
	CDCONDUCTORES_EMP.F_NAC,
	CDCONDUCTORES_EMP.EXPIRED_DATE_TRJCONDU,
	CDCONDUCTORES_EMP.enviar_a,
    CDCONDUCTORES_EMP.AGR_ID,
    CDCONDUCTORES_EMP.CONTRACT_TYPE,
	EMPRE_REQ.F_BAJA,
	EMPRE_REQ.NOMB AS NOMBRE_EMPRESA
FROM 
	CDCONDUCTORES_EMP,
	(
		SELECT 
			CDCONDUCTOR_CONT.CG_CONTRATO,
			CDCONDUCTOR_CONT.F_BAJA,			
			CIF,
			IDCONDUCTOR,
			cdVempre_req_REALES.NOMB
		FROM 
			CDCONDUCTOR_CONT, 
			cdVempre_req_REALES
	WHERE 
		CDCONDUCTOR_CONT.CG_CONTRATO = cdVempre_req_REALES.CG_CONTRATO		
	) EMPRE_REQ
WHERE 
	CDCONDUCTORES_EMP.IDCONDUCTOR = EMPRE_REQ.IDCONDUCTOR (+) AND
	CDCONDUCTORES_EMP.CIF = EMPRE_REQ.CIF (+)
/
insert into CDPREFSERVIDOR (NOMBRE,DESCRIPCION,VALOR) 
VALUES ('Mail.Starttls','Indica si el servidor de env�o de mails tiene disponible TLS. Posibles valores: "true" o "false"', 'true');
/ 