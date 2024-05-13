CREATE TABLE `archivos_adjuntos` (
  `id_archivo` int(11) NOT NULL AUTO_INCREMENT,
  `id_expediente` int(11) NOT NULL,
  `nombre_archivo` varchar(255) NOT NULL,
  `tipo_archivo` varchar(50) NOT NULL,
  `ruta_archivo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_archivo`),
  FOREIGN KEY (`id_expediente`) REFERENCES `expedientes`(`id_expediente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;