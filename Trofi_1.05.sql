CREATE DATABASE IF NOT EXISTS `Trofi`;
USE `Trofi`;

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE `administrador` (
  `correo_e` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `a_paterno` varchar(50) NOT NULL,
  `a_materno` varchar(50) NOT NULL,
  `contrasenia` varchar(40) NOT NULL,
  PRIMARY KEY (`correo_e`),
  UNIQUE(`correo_e`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente`(
  `correo_e` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `a_paterno` varchar(50) NOT NULL,
  `a_materno` varchar(50) NOT NULL,
  `contrasenia` varchar(40) NOT NULL,
  `telefono` char(10) NOT NULL,
  PRIMARY KEY (`correo_e`),
  UNIQUE(`correo_e`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `repartidor`;
CREATE TABLE `repartidor`(
  `correo_e` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL ,
  `a_paterno` varchar(50) NOT NULL,
  `a_materno` varchar(50) NOT NULL,
  `contrasenia` varchar(40) NOT NULL,
  PRIMARY KEY (`correo_e`),
  UNIQUE(`correo_e`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `direccion_cliente`;
CREATE TABLE `direccion_cliente`(
  `correo_e` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`correo_e`, `direccion`),
  FOREIGN KEY (`correo_e`) REFERENCES cliente(`correo_e`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `orden`;
CREATE TABLE `orden`(
  `correo_e` varchar(50) NOT NULL,
  `id_orden` int(11) auto_increment,
  `estado_orden` enum('PREPARANDO', 'LISTA', 'EN CAMINO', 'ENTREGADA', 'NO ENTREGADA') NOT NULL,
  `direccion_cliente` tinytext NOT NULL,
  `repartidor` varchar(50),
  PRIMARY KEY (`correo_e`, `id_orden`),
  FOREIGN KEY (`correo_e`) REFERENCES cliente(`correo_e`),
  FOREIGN KEY (`repartidor`) REFERENCES repartidor(`correo_e`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria`(
  `id_categoria` int(11) auto_increment,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `alimento`;
CREATE TABLE `alimento`(
  `id_categoria` int(11) NOT NULL,
  `id_alimento` int(11)  auto_increment,
  `nombre` varchar(50) NOT NULL,
  `descripcion` tinytext NOT NULL,
  `costo` decimal(6, 2) NOT NULL,
  `foto` longblob NOT NULL,
  PRIMARY KEY (`id_categoria`, `id_alimento`),
  FOREIGN KEY (`id_categoria`) REFERENCES categoria(`id_categoria`) ON DELETE CASCADE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `tener`;
CREATE TABLE `tener`(
  `correo_e` varchar(50) NOT NULL,
  `id_orden` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_alimento` int(11) NOT NULL,
  PRIMARY KEY (`correo_e`, `id_orden`, `id_categoria`, `id_alimento`),
  FOREIGN KEY (`correo_e`) REFERENCES orden(`correo_e`),
  FOREIGN KEY (`id_orden`) REFERENCES orden(`id_orden`),
  FOREIGN KEY (`id_categoria`) REFERENCES alimento(`id_categoria`),
  FOREIGN KEY (`id_alimento`) REFERENCES alimento(`id_alimento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;

