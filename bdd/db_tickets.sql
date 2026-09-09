/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50744
Source Host           : localhost:3306
Source Database       : db_tickets

Target Server Type    : MYSQL
Target Server Version : 50744
File Encoding         : 65001

Date: 2026-09-08 22:12:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_adscrip
-- ----------------------------
DROP TABLE IF EXISTS `c_adscrip`;
CREATE TABLE `c_adscrip` (
  `c_i_adscrip` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la adscripción',
  `d_v_adscrip` varchar(100) NOT NULL COMMENT 'Nombre o descripción de la adscripción',
  `d_v_siglas` varchar(20) DEFAULT NULL COMMENT 'Siglas de la adscripción',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`c_i_adscrip`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_adscrip
-- ----------------------------
INSERT INTO `c_adscrip` VALUES ('1', 'Dirección', 'DIR', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('2', 'Subdirección Académica', 'SA', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('3', 'Subdirección Administrativa', 'SAD', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('4', 'Departamento de Soporte Técnico', 'DST', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('5', 'Servicios Escolares', 'SE', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('6', 'Recursos Materiales y Servicios', 'RMS', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('7', 'Centro de Cómputo', 'CC', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('8', 'Biblioteca', 'BIB', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('9', 'Coordinación de Titulación', 'CT', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('10', 'Coordinación de Servicio Social', 'CSS', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('11', 'Coordinación de Becas', 'CB', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('12', 'Departamento de Redes y Telecomunicaciones', 'DRT', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('13', 'Departamento de Desarrollo de Software', 'DDS', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('14', 'Departamento de Seguridad Informática', 'DSI', '1', '2026-05-11 10:13:50', 'A');
INSERT INTO `c_adscrip` VALUES ('15', 'Unidad de Tecnologías de la Información', 'UTI', '1', '2026-05-11 10:13:50', 'A');

-- ----------------------------
-- Table structure for c_asunto
-- ----------------------------
DROP TABLE IF EXISTS `c_asunto`;
CREATE TABLE `c_asunto` (
  `pk_i_asunto` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del asunto',
  `c_i_adscrip` int(11) DEFAULT NULL COMMENT 'Adscripción asociada al asunto',
  `d_v_asunto` varchar(200) NOT NULL COMMENT 'Descripción del asunto',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_asunto`) USING BTREE,
  KEY `idx_c_asunto_c_i_adscrip` (`c_i_adscrip`) USING BTREE,
  CONSTRAINT `fk_c_asunto_c_adscrip` FOREIGN KEY (`c_i_adscrip`) REFERENCES `c_adscrip` (`c_i_adscrip`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of c_asunto
-- ----------------------------

-- ----------------------------
-- Table structure for c_clasedoc
-- ----------------------------
DROP TABLE IF EXISTS `c_clasedoc`;
CREATE TABLE `c_clasedoc` (
  `pk_i_clase` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Clave de Clase de Documento',
  `d_v_clase` varchar(25) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL COMMENT 'Descripción de Clase',
  `d_b_estado` tinyint(1) DEFAULT '0' COMMENT '<0>  Activo  <1> Inactivo',
  `c_n_usucap` int(11) DEFAULT NULL COMMENT 'Usuario que registra',
  `f_d_fechcap` datetime DEFAULT NULL COMMENT 'Fecha y hora de registro',
  `w_v_status` varchar(1) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_clase`) USING BTREE,
  UNIQUE KEY `uk_c_clasedoc_c_clasedoc_1` (`pk_i_clase`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of c_clasedoc
-- ----------------------------

-- ----------------------------
-- Table structure for c_documento
-- ----------------------------
DROP TABLE IF EXISTS `c_documento`;
CREATE TABLE `c_documento` (
  `pk_i_tipodoc` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del tipo de documento',
  `d_v_tipodoc` varchar(20) NOT NULL COMMENT 'Descripción del tipo de documento',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_tipodoc`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_documento
-- ----------------------------
INSERT INTO `c_documento` VALUES ('1', 'ASUNTO', '1', '2026-05-16 00:36:35', 'A');
INSERT INTO `c_documento` VALUES ('2', 'RESPUESTA', '1', '2026-05-16 00:36:53', 'A');

-- ----------------------------
-- Table structure for c_estado
-- ----------------------------
DROP TABLE IF EXISTS `c_estado`;
CREATE TABLE `c_estado` (
  `pk_i_estado` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del estado',
  `d_v_estado` varchar(20) NOT NULL COMMENT 'Descripción del estado del ticket',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_estado`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_estado
-- ----------------------------
INSERT INTO `c_estado` VALUES ('1', 'ABIERTO', '1', '2026-05-11 10:38:57', 'A');
INSERT INTO `c_estado` VALUES ('2', 'CERRADO', '1', '2026-05-11 10:39:09', 'A');
INSERT INTO `c_estado` VALUES ('3', 'VENCIDO', '1', '2026-05-11 10:39:31', 'A');

-- ----------------------------
-- Table structure for c_fuente
-- ----------------------------
DROP TABLE IF EXISTS `c_fuente`;
CREATE TABLE `c_fuente` (
  `pk_i_fuente` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la fuente',
  `d_v_fuente` varchar(100) NOT NULL COMMENT 'Descripción de la fuente del ticket',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_fuente`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_fuente
-- ----------------------------
INSERT INTO `c_fuente` VALUES ('1', 'MEMORANDUM', '1', '2026-05-11 11:03:49', 'A');
INSERT INTO `c_fuente` VALUES ('2', 'TELÉFONO', '1', '2026-05-11 11:04:05', 'A');
INSERT INTO `c_fuente` VALUES ('3', 'SOLICITUD DIRECTA', '1', '2026-05-11 11:04:22', 'A');

-- ----------------------------
-- Table structure for c_perfil
-- ----------------------------
DROP TABLE IF EXISTS `c_perfil`;
CREATE TABLE `c_perfil` (
  `pk_i_perfil` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del perfil',
  `d_v_perfil` varchar(100) NOT NULL COMMENT 'Nombre o descripción del perfil',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_perfil`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_perfil
-- ----------------------------
INSERT INTO `c_perfil` VALUES ('1', 'ADMIN', '1', '2026-03-17 10:18:36', 'A');
INSERT INTO `c_perfil` VALUES ('2', 'STAFF', '1', '2026-03-17 10:18:52', 'A');

-- ----------------------------
-- Table structure for c_respuesta
-- ----------------------------
DROP TABLE IF EXISTS `c_respuesta`;
CREATE TABLE `c_respuesta` (
  `pk_i_respuesta` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del tipo de respuesta',
  `d_v_respuesta` varchar(20) NOT NULL COMMENT 'Descripción del tipo de respuesta',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_respuesta`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_respuesta
-- ----------------------------
INSERT INTO `c_respuesta` VALUES ('1', 'RESPUESTA', '1', '2026-05-19 11:31:20', 'A');
INSERT INTO `c_respuesta` VALUES ('2', 'TURNADO', '1', '2026-05-19 11:31:32', 'A');
INSERT INTO `c_respuesta` VALUES ('3', 'NOTA INTERNA', '1', '2026-05-19 12:26:21', 'A');

-- ----------------------------
-- Table structure for c_usuario
-- ----------------------------
DROP TABLE IF EXISTS `c_usuario`;
CREATE TABLE `c_usuario` (
  `c_i_usuario` int(11) NOT NULL COMMENT 'Identificador único del usuario',
  `d_v_email` varchar(45) NOT NULL,
  `d_v_nombre` varchar(45) NOT NULL COMMENT 'Nombre del usuario',
  `d_v_password` varchar(100) NOT NULL COMMENT 'Contraseña del usuario',
  `pk_i_perfil` int(11) NOT NULL COMMENT 'Perfil asignado al usuario',
  `c_i_adscri` int(11) DEFAULT NULL COMMENT 'Adscripcion a la que pertenece el usuario',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`c_i_usuario`,`d_v_email`),
  KEY `idx_c_usuario_pk_i_perfil` (`pk_i_perfil`) USING BTREE,
  CONSTRAINT `fk_c_usuario_c_perfil` FOREIGN KEY (`pk_i_perfil`) REFERENCES `c_perfil` (`pk_i_perfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_usuario
-- ----------------------------
INSERT INTO `c_usuario` VALUES ('1', 'jalvaradog1800@alumno.ipn.mx', 'Administrador del sistema', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '1', '1', '1', '2026-03-17 10:18:07', 'A');
INSERT INTO `c_usuario` VALUES ('2', 'coordinacion.academica@escom.ipn.mx', 'Coordinación Académica', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '2', '2', '1', '2026-05-15 23:32:15', 'A');
INSERT INTO `c_usuario` VALUES ('3', 'servicios.escolares@escom.ipn.mx', 'Servicios Escolares', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '2', '5', '1', '2026-05-15 23:32:23', 'A');
INSERT INTO `c_usuario` VALUES ('4', 'subdireccion.academica@escom.ipn.mx', 'Subdirección Académica', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '2', '2', '1', '2026-05-15 23:32:31', 'A');
INSERT INTO `c_usuario` VALUES ('5', 'soporte@escom.ipn.mx', 'Departamento de Cómputo', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '2', '4', '1', '2026-05-15 23:32:41', 'A');
INSERT INTO `c_usuario` VALUES ('6', 'titulacion@escom.ipn.mx', 'Coordinación de Titulación', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '2', '9', '1', '2026-05-15 23:32:49', 'A');
INSERT INTO `c_usuario` VALUES ('7', 'biblioteca@escom.ipn.mx', 'Biblioteca ESCOM', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '2', '8', '1', '2026-05-15 23:32:56', 'A');
INSERT INTO `c_usuario` VALUES ('8', 'recursos.materiales@escom.ipn.mx', 'Recursos Materiales', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '2', '6', '1', '2026-05-15 23:33:06', 'A');
INSERT INTO `c_usuario` VALUES ('9', 'informatica@escom.ipn.mx', 'Unidad de Informática', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '2', '15', '1', '2026-05-15 23:33:14', 'A');
INSERT INTO `c_usuario` VALUES ('10', 'direccion@escom.ipn.mx', 'Dirección ESCOM', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '1', '1', '1', '2026-05-11 13:29:21', 'A');
INSERT INTO `c_usuario` VALUES ('11', 'alumno@alumno.ipn.mx', 'Luis Ángel Aparicio Borjas', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '1', '5', '1', '2026-05-11 13:29:21', 'A');
INSERT INTO `c_usuario` VALUES ('12', 'jcarlosagutierrezipn@gmail.com', 'Jose Carlos Alvarado Gutierrez', '$2a$12$H18UYshCoNxtOB7fu4wSZ.mfwf.ScqANDZFqy8ASuc/qzkROAtXPu', '1', '1', '1', '2026-05-15 22:49:52', 'A');

-- ----------------------------
-- Table structure for c_vigencia
-- ----------------------------
DROP TABLE IF EXISTS `c_vigencia`;
CREATE TABLE `c_vigencia` (
  `pk_i_vigencia` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la vigencia',
  `c_i_adscrip` int(11) NOT NULL COMMENT 'Identificador de la adscripción asociada',
  `d_i_horas` int(11) NOT NULL COMMENT 'Número de horas de vigencia asignadas',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL DEFAULT 'A' COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_vigencia`) USING BTREE,
  KEY `idx_c_vigencia_c_i_adscrip` (`c_i_adscrip`) USING BTREE,
  CONSTRAINT `fk_c_vigencia_c_adscrip` FOREIGN KEY (`c_i_adscrip`) REFERENCES `c_adscrip` (`c_i_adscrip`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_vigencia
-- ----------------------------
INSERT INTO `c_vigencia` VALUES ('1', '1', '72', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('2', '2', '48', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('3', '3', '48', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('4', '4', '8', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('5', '5', '24', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('6', '6', '72', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('7', '7', '12', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('8', '8', '24', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('9', '9', '48', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('10', '10', '48', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('11', '11', '48', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('12', '12', '6', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('13', '13', '24', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('14', '14', '4', '1', '2026-05-11 10:20:34', 'A');
INSERT INTO `c_vigencia` VALUES ('15', '15', '8', '1', '2026-05-11 10:20:34', 'A');

-- ----------------------------
-- Table structure for d_doctos
-- ----------------------------
DROP TABLE IF EXISTS `d_doctos`;
CREATE TABLE `d_doctos` (
  `pk_i_folio` int(11) NOT NULL COMMENT 'No. de Identificación del Registro de Gestiones',
  `d_v_nomdocto` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL DEFAULT '' COMMENT 'Nombre del documento',
  `d_b_documento` longblob,
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que registra',
  `f_d_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de registro',
  `w_v_status` varchar(1) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_folio`) USING BTREE,
  KEY `uk_pk_i_folio` (`pk_i_folio`) USING BTREE,
  CONSTRAINT `d_emision_ibfk_5` FOREIGN KEY (`pk_i_folio`) REFERENCES `m_cgestion` (`pk_i_folio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of d_doctos
-- ----------------------------

-- ----------------------------
-- Table structure for d_documento
-- ----------------------------
DROP TABLE IF EXISTS `d_documento`;
CREATE TABLE `d_documento` (
  `pk_i_ticket` int(11) NOT NULL COMMENT 'Número de ticket',
  `pk_i_anio` int(11) NOT NULL COMMENT 'Año de ticket',
  `d_n_consec` int(11) NOT NULL COMMENT 'Consecutivo del documento asociado al ticket',
  `d_v_nomdocto` varchar(255) NOT NULL COMMENT 'Nombre del documento',
  `d_b_documento` longblob COMMENT 'Documento almacenado en formato BLOB',
  `pk_i_tipodoc` int(11) NOT NULL COMMENT 'Tipo de documento',
  `c_n_usucap` int(11) NOT NULL DEFAULT '0' COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_ticket`,`pk_i_anio`,`d_n_consec`) USING BTREE,
  KEY `idx_d_documento_pk_i_tipodoc` (`pk_i_tipodoc`) USING BTREE,
  CONSTRAINT `fk_d_documento_c_documento` FOREIGN KEY (`pk_i_tipodoc`) REFERENCES `c_documento` (`pk_i_tipodoc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_d_documento_m_ticket` FOREIGN KEY (`pk_i_ticket`, `pk_i_anio`) REFERENCES `m_ticket` (`pk_i_ticket`, `pk_i_anio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of d_documento
-- ----------------------------

-- ----------------------------
-- Table structure for d_emision
-- ----------------------------
DROP TABLE IF EXISTS `d_emision`;
CREATE TABLE `d_emision` (
  `pk_i_folio` int(11) NOT NULL,
  `d_v_asunto` text CHARACTER SET utf8mb4 NOT NULL COMMENT 'Asunto del Documento',
  `d_b_urgente` tinyint(1) NOT NULL COMMENT 'Si el trámite es Urgente',
  `f_d_fechresolver` date DEFAULT NULL COMMENT 'Fecha límite para resolver',
  `d_v_doctos` varchar(500) DEFAULT NULL,
  `d_v_referencia` varchar(255) DEFAULT NULL,
  `d_v_acuerdo` varchar(255) DEFAULT NULL,
  `d_v_obser` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `pk_i_dispdoc` int(11) DEFAULT NULL,
  `pk_i_situacion` int(11) DEFAULT NULL COMMENT 'Clave de Situación del Documento',
  `c_n_usucap` int(11) DEFAULT NULL,
  `f_d_fechcap` datetime DEFAULT NULL,
  `w_v_status` varchar(1) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`pk_i_folio`) USING BTREE,
  UNIQUE KEY `pk_i_folio_index` (`pk_i_folio`) USING BTREE,
  KEY `uk_pk_i_dispdoc` (`pk_i_dispdoc`) USING BTREE,
  KEY `uk_pk_i_situacion` (`pk_i_situacion`) USING BTREE,
  CONSTRAINT `d_emision_ibfk_1` FOREIGN KEY (`pk_i_folio`) REFERENCES `m_cgestion` (`pk_i_folio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of d_emision
-- ----------------------------

-- ----------------------------
-- Table structure for d_recepcion
-- ----------------------------
DROP TABLE IF EXISTS `d_recepcion`;
CREATE TABLE `d_recepcion` (
  `pk_i_folio` int(11) NOT NULL COMMENT 'No. de Identificación del Registro de Gestiones',
  `c_i_adsc_recibe` int(11) NOT NULL COMMENT 'Clave de Adscripción que recibe el documento',
  `d_n_folio_arearec` int(11) DEFAULT '0' COMMENT 'Folio consecutivo de  documentos recibidos por el Area',
  `d_f_fech_recibio` date DEFAULT NULL COMMENT 'Fecha de recepción del Documento',
  `d_f_hora_recibio` time DEFAULT NULL COMMENT 'Hora de recepción del Documento',
  `c_n_usu_recibio` int(11) DEFAULT '0' COMMENT 'Número de Empleado que recibió el Documento',
  `c_i_tipo_turnado` int(1) DEFAULT '0' COMMENT 'Tipo de area  a que se turna el Documento:   <1> Interno     <2> Externo   <3> Grupo',
  `c_i_adsc_turnado` int(11) DEFAULT '0' COMMENT 'Clave de Adscripción a  donde se turna',
  `d_n_usu_turnado` int(11) DEFAULT '0' COMMENT 'Número de Empleado a quien se turna el Documento',
  `c_i_area_turnado` int(11) DEFAULT '0' COMMENT 'Clave de Area Externa a  donde se turna',
  `c_i_externo_turnado` int(11) DEFAULT '0' COMMENT 'Clave de Persona Externa  a quien se turna el Documento',
  `c_i_grupo_turnado` int(11) DEFAULT '0' COMMENT 'Clave de Grupo a donde se turna',
  `d_v_numdocto_turnado` varchar(50) DEFAULT NULL COMMENT 'Referencia del Documento con que se turna',
  `d_v_instrucciones` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Descripción de las Instrucciones a atender',
  `d_v_seguimiento` varchar(10) DEFAULT NULL COMMENT 'Descripción del Seguimiento',
  `pk_i_situacion` int(11) DEFAULT NULL COMMENT 'Clave de Situación del Documento',
  `d_n_edoreg` int(11) DEFAULT '0' COMMENT 'Estado del registro <0>  Activo  <1> Inactivo',
  `f_d_fech_turnado` date DEFAULT NULL COMMENT 'Fecha en que se turna el Documento',
  `f_d_hora_turnado` time DEFAULT NULL COMMENT 'Hora en que se turna el Documento',
  `c_i_adsc_turna` int(11) DEFAULT '0' COMMENT 'Clave de Adscripción que turnó el documento',
  `d_f_fech_resolver` date DEFAULT NULL COMMENT 'Fecha límite para resolver el documento recibido',
  `pk_i_dispdoc` int(11) DEFAULT NULL COMMENT 'No. de Identificación de Disposición Documental',
  `d_fec_leido` date DEFAULT NULL COMMENT 'Fecha y Hora en que se marcó como documento leído',
  `d_b_urgente` tinyint(1) DEFAULT '0' COMMENT 'Si el trámite del documento Recibido es Urgente u Ordinario',
  `d_v_asunto` text CHARACTER SET utf8mb4 COMMENT 'Descripción del asunto',
  `c_n_usucap` int(11) DEFAULT NULL COMMENT 'Usuario que registra',
  `f_d_fechcap` datetime DEFAULT NULL COMMENT 'Fecha y hora de registro',
  `w_v_status` varchar(1) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_folio`,`c_i_adsc_recibe`) USING BTREE,
  KEY `uk_c_i_adsc_recibe` (`c_i_adsc_recibe`) USING BTREE,
  KEY `uk_f_d_fech_turnado` (`f_d_fech_turnado`) USING BTREE,
  KEY `uk_c_i_adsc_turna` (`c_i_adsc_turna`) USING BTREE,
  KEY `uk_d_f_fech_recibido` (`d_f_fech_recibio`) USING BTREE,
  KEY `uk_pk_i_situacion` (`pk_i_situacion`) USING BTREE,
  KEY `pk_i_folio_index` (`pk_i_folio`) USING BTREE,
  CONSTRAINT `fk_pk_i_folio2` FOREIGN KEY (`pk_i_folio`) REFERENCES `m_cgestion` (`pk_i_folio`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of d_recepcion
-- ----------------------------

-- ----------------------------
-- Table structure for d_ticket
-- ----------------------------
DROP TABLE IF EXISTS `d_ticket`;
CREATE TABLE `d_ticket` (
  `pk_i_ticket` int(11) NOT NULL COMMENT 'Número de ticket',
  `pk_i_anio` int(11) NOT NULL COMMENT 'Año de ticket',
  `d_n_consec` int(11) NOT NULL COMMENT 'Consecutivo del detalle o respuesta',
  `pk_i_respuesta` int(11) NOT NULL COMMENT 'Tipo de respuesta',
  `c_i_numemp` int(11) NOT NULL COMMENT 'Placa o número de empleado del elemento',
  `d_v_comentario` text NOT NULL COMMENT 'Comentario de respuesta',
  `c_n_usucap` int(11) NOT NULL DEFAULT '0' COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_ticket`,`pk_i_anio`,`d_n_consec`) USING BTREE,
  KEY `idx_d_ticket_pk_i_respuesta` (`pk_i_respuesta`) USING BTREE,
  CONSTRAINT `fk_d_ticket_c_respuesta` FOREIGN KEY (`pk_i_respuesta`) REFERENCES `c_respuesta` (`pk_i_respuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_d_ticket_m_ticket` FOREIGN KEY (`pk_i_ticket`, `pk_i_anio`) REFERENCES `m_ticket` (`pk_i_ticket`, `pk_i_anio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of d_ticket
-- ----------------------------

-- ----------------------------
-- Table structure for d_usuarioadscrip
-- ----------------------------
DROP TABLE IF EXISTS `d_usuarioadscrip`;
CREATE TABLE `d_usuarioadscrip` (
  `c_i_usuario` int(11) NOT NULL COMMENT 'Identificador del usuario',
  `c_i_adscrip` int(11) NOT NULL COMMENT 'Identificador de la adscripción',
  `c_n_usucap` int(11) NOT NULL COMMENT 'Usuario que capturó el registro',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`c_i_usuario`,`c_i_adscrip`) USING BTREE,
  KEY `idx_d_usuarioadscrip_c_i_usuario` (`c_i_usuario`) USING BTREE,
  KEY `idx_d_usuarioadscrip_c_i_adscrip` (`c_i_adscrip`) USING BTREE,
  CONSTRAINT `fk_d_usuarioadscrip_c_adscrip` FOREIGN KEY (`c_i_adscrip`) REFERENCES `c_adscrip` (`c_i_adscrip`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_d_usuarioadscrip_c_usuario` FOREIGN KEY (`c_i_usuario`) REFERENCES `c_usuario` (`c_i_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of d_usuarioadscrip
-- ----------------------------

-- ----------------------------
-- Table structure for m_cgestion
-- ----------------------------
DROP TABLE IF EXISTS `m_cgestion`;
CREATE TABLE `m_cgestion` (
  `pk_i_folio` int(11) NOT NULL AUTO_INCREMENT COMMENT 'No. de Identificación del Registro de Gestiones',
  `pk_i_clase` int(11) NOT NULL DEFAULT '0' COMMENT 'Clave de Clase de Documento',
  `d_v_numdocto` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL COMMENT 'Número de Documento',
  `d_f_fechdocto` date NOT NULL COMMENT 'Fecha del Documento',
  `c_i_adsc_rem` int(11) DEFAULT '0' COMMENT 'Clave de Adscripción que remite',
  `c_n_usu_rem` int(11) DEFAULT '0' COMMENT 'Empleado que remite',
  `c_i_adsc_dest` int(11) DEFAULT '0' COMMENT 'Clave de Adscripción destinataria',
  `c_n_usu_dest` int(11) DEFAULT '0' COMMENT 'Empleado destinatario',
  `c_n_usu_elabo` int(11) NOT NULL DEFAULT '0' COMMENT 'Número de Empleado de quien elaboró el documento',
  `c_i_adsc_elabo` int(11) NOT NULL DEFAULT '0' COMMENT 'Clave de Adscripción de quien elaboró el documento',
  `c_n_usucap` int(11) NOT NULL DEFAULT '0' COMMENT 'Usuario que registra',
  `f_d_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de registro',
  `w_v_status` varchar(1) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_folio`) USING BTREE,
  UNIQUE KEY `uk_pk_i_folio` (`pk_i_folio`) USING BTREE,
  KEY `uk_c_i_adsc_rem` (`c_i_adsc_rem`) USING BTREE,
  KEY `uk_c_i_adsc_dest` (`c_i_adsc_dest`) USING BTREE,
  KEY `uk_pk_i_clase` (`pk_i_clase`) USING BTREE,
  KEY `uk_d_v_numdoc` (`d_v_numdocto`) USING BTREE,
  KEY `uk_``d_f_fechdocto` (`d_f_fechdocto`) USING BTREE,
  CONSTRAINT `fk_clasedoc` FOREIGN KEY (`pk_i_clase`) REFERENCES `c_clasedoc` (`pk_i_clase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_cgestion
-- ----------------------------

-- ----------------------------
-- Table structure for m_ticket
-- ----------------------------
DROP TABLE IF EXISTS `m_ticket`;
CREATE TABLE `m_ticket` (
  `pk_i_ticket` int(11) NOT NULL COMMENT 'Número de ticket',
  `pk_i_anio` int(11) NOT NULL COMMENT 'Año de ticket',
  `d_f_fecha` date NOT NULL COMMENT 'Fecha de ticket',
  `c_i_adscrip` int(11) NOT NULL COMMENT 'Adscripción del solicitante',
  `c_i_numemp` int(11) NOT NULL COMMENT 'Número de empleado del solicitante',
  `c_i_adscripasigna` int(11) NOT NULL COMMENT 'Adscripción del staff asignado',
  `c_i_numempasigna` int(11) NOT NULL COMMENT 'Número de empleado del staff asignado',
  `pk_i_asunto` int(11) DEFAULT NULL COMMENT 'Tipo de área de ayuda',
  `d_v_asunto` text NOT NULL COMMENT 'Asunto del ticket',
  `pk_i_estado` int(11) NOT NULL COMMENT 'Estado del ticket',
  `pk_i_vigencia` int(11) NOT NULL COMMENT 'Vigencia del ticket',
  `pk_i_folio` int(11) NOT NULL COMMENT 'Número de identificación del control de gestión',
  `pk_i_fuente` int(11) DEFAULT NULL COMMENT 'Fuente asociada al ticket',
  `c_n_usucap` int(11) NOT NULL DEFAULT '0' COMMENT 'Usuario que capturó el registro',
  `c_n_usucierre` int(11) DEFAULT NULL,
  `d_f_fechcierre` datetime DEFAULT NULL COMMENT 'Fecha y hora de cierre del ticket',
  `d_f_fechcap` datetime NOT NULL COMMENT 'Fecha y hora de captura',
  `w_v_status` varchar(1) NOT NULL COMMENT 'Estado del registro',
  PRIMARY KEY (`pk_i_ticket`,`pk_i_anio`) USING BTREE,
  KEY `idx_m_ticket_c_i_adscrip` (`c_i_adscrip`) USING BTREE,
  KEY `idx_m_ticket_c_i_adscripasigna` (`c_i_adscripasigna`) USING BTREE,
  KEY `idx_m_ticket_pk_i_asunto` (`pk_i_asunto`) USING BTREE,
  KEY `idx_m_ticket_pk_i_estado` (`pk_i_estado`) USING BTREE,
  KEY `idx_m_ticket_pk_i_vigencia` (`pk_i_vigencia`) USING BTREE,
  KEY `idx_m_ticket_pk_i_fuente` (`pk_i_fuente`) USING BTREE,
  CONSTRAINT `fk_m_ticket_c_adscrip_asigna` FOREIGN KEY (`c_i_adscripasigna`) REFERENCES `c_adscrip` (`c_i_adscrip`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_m_ticket_c_adscrip_solicita` FOREIGN KEY (`c_i_adscrip`) REFERENCES `c_adscrip` (`c_i_adscrip`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_m_ticket_c_asunto` FOREIGN KEY (`pk_i_asunto`) REFERENCES `c_asunto` (`pk_i_asunto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_m_ticket_c_estado` FOREIGN KEY (`pk_i_estado`) REFERENCES `c_estado` (`pk_i_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_m_ticket_c_fuente` FOREIGN KEY (`pk_i_fuente`) REFERENCES `c_fuente` (`pk_i_fuente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_m_ticket_c_vigencia` FOREIGN KEY (`pk_i_vigencia`) REFERENCES `c_vigencia` (`pk_i_vigencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of m_ticket
-- ----------------------------
