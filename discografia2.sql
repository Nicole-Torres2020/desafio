

--
-- Base de datos: `discografia2`
--
CREATE DATABASE IF NOT EXISTS `discografia2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `discografia2`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

CREATE TABLE IF NOT EXISTS `artistas` (
  `id_artista` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_artista` varchar(40) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_artista`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `artistas`
--

INSERT INTO `artistas` (`id_artista`, `nombre_artista`, `descripcion`) VALUES
(4, 'Adele', 'Artista britanica'),
(5, 'King Flip', 'De Morazán'),
(6, 'Tongo', 'Le Tengue'),
(7, 'Amy', 'Britanica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `discos`
--

CREATE TABLE IF NOT EXISTS `discos` (
  `id_disco` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_disco` varchar(40) NOT NULL,
  `id_artista` int(11) NOT NULL,
  `numero_canciones` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_disco`),
  KEY `artistas_discos` (`id_artista`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `discos`
--

INSERT INTO `discos` (`id_disco`, `nombre_disco`, `id_artista`, `numero_canciones`, `precio`) VALUES
(2, '19', 7, 12, '12.00'),
(3, '21', 4, 12, '15.00');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `discos`
--
ALTER TABLE `discos`
  ADD CONSTRAINT `artistas_discos` FOREIGN KEY (`id_artista`) REFERENCES `artistas` (`id_artista`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
