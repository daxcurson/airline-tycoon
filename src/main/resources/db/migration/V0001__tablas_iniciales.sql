CREATE TABLE `avion` (
  `id` int(11) NOT NULL,
  `nombre` int(11) NOT NULL,
  `modelo_id` int(11) NOT NULL,
  `antiguedad` int(11) NOT NULL,
  `kilometros_recorridos` int(11) NOT NULL,
  `ubicacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `latitud` float NOT NULL,
  `longitud` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id`, `codigo`, `nombre`, `latitud`, `longitud`) VALUES
(1, 'LGW', 'London', 51.8075, -0.465),
(2, 'GIG', 'Rio de Janeiro', -22.9092, -43.215),
(3, 'LIM', 'Lima', -12.0697, -77.05),
(4, 'ULC', 'Santiago', -33.4597, -70.64),
(5, 'BOG', 'Bogota', 4.63, -74.09),
(6, 'MIA', 'Miami', 25.7739, -80.1936),
(7, 'ATL', 'Atlanta', 33.7489, -84.3878),
(8, 'JFK', 'New York', 40.7142, -74.0061),
(9, 'DEN', 'Denver', 39.7392, -104.984),
(10, 'LAX', 'Los Angeles', 34.0522, -118.243),
(11, 'SFA', 'San Francisco', 37.775, -122.418),
(12, 'SIN', 'Singapore', 1.3, 103.85),
(13, 'SEL', 'Seoul', 37.56, 126.99),
(14, 'NRT', 'Tokio', 35.67, 139.77),
(15, 'MNL', 'Manila', 14.62, 120.97),
(16, 'BOM', 'Bombay', 18.96, 72.8197),
(17, 'CCU', 'Calcuta', 22.57, 88.3597),
(18, 'BKK', 'Bangkok', 13.73, 100.5),
(19, 'IST', 'Instanbul', 41.1, 29),
(20, 'PRG', 'Praga', 50.0797, 14.43),
(21, 'CDG', 'Paris', 48.8564, 2.35083),
(22, 'ORD', 'Chicago', 41.85, -87.6497),
(23, 'ZRH', 'Zurich', 47.3797, 8.54),
(24, 'FRA', 'Frankfurt', 50.1122, 8.68417),
(25, 'SVO', 'Moscu', 55.75, 37.6197),
(26, 'MSQ', 'Minsk', 53.91, 27.55),
(27, 'SYD', 'Sydney', -33.8697, 151.21),
(28, 'EZE', 'Buenos Aires', -34.6097, -58.37),
(29, 'JNB', 'Johannesburg', -26.1897, 28.0397),
(30, 'NBO', 'Nairobi', -1.28972, 36.8197),
(31, 'DKR', 'Dakar', 14.72, -17.48),
(32, 'CPT', 'Cape Town', -33.9297, 18.4597);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modeloavion`
--

CREATE TABLE `modeloavion` (
  `id` int(11) NOT NULL,
  `modelo` varchar(200) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `velocidad` int(11) NOT NULL,
  `autonomia` int(11) NOT NULL,
  `tanque` int(11) NOT NULL,
  `consumo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `modeloavion`
--

INSERT INTO `modeloavion` (`id`, `modelo`, `capacidad`, `velocidad`, `autonomia`, `tanque`, `consumo`) VALUES
(1, 'Airbus A300', 375, 875, 8000, 29700, 2983),
(2, 'Boeing 767-300ER', 290, 1012, 9940, 20000, 2800),
(3, 'Airbus A310', 250, 900, 7350, 24210, 2850),
(4, 'Boeing 707-320C', 189, 975, 5840, 92250, 15345),
(5, 'Airbus A320', 149, 853, 3717, 23870, 3025),
(6, 'Boeing 720', 165, 965, 6835, 79925, 11000),
(7, 'BAC Concorde', 100, 2150, 6230, 119500, 25629),
(8, 'Boeing 727-200', 189, 1000, 4700, 25000, 15000),
(9, 'Boeing 737-400', 168, 815, 3870, 20800, 3050),
(10, 'Boeing 757-300', 240, 890, 6455, 43490, 4194),
(11, 'Boeing 737-800', 189, 815, 5420, 26020, 3050),
(12, 'Boeing 777-300', 550, 911, 10370, 171170, 8290),
(13, 'Boeing 747-100', 370, 917, 7163, 178700, 13862),
(14, 'Boeing 747-400', 420, 927, 13490, 216840, 12788),
(15, 'Boeing 747-400 Domestic', 568, 927, 3185, 204350, 12788),
(16, 'Ilyushin IL-62', 198, 880, 9200, 110000, 10500),
(17, 'Ilyushin IL-86', 380, 950, 4950, 53000, 9800),
(18, 'McDonnel Douglas DC-10', 380, 965, 9250, 138730, 9376),
(19, 'Lockheed Tristar 500', 300, 800, 7000, 80000, 9100),
(20, 'McDonnel Douglas MD-81', 172, 950, 2900, 10000, 3000),
(21, 'Lockheed C5A Galaxy', 345, 919, 6000, 9000, 14000),
(22, 'McDonnel Douglas DC-8', 259, 932, 12600, 115000, 14000),
(23, 'Tupolev Tu154', 180, 900, 3000, 32500, 9600),
(24, 'Airbus A380', 555, 903, 15100, 310000, 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `id` int(11) NOT NULL,
  `origen_id` int(11) NOT NULL,
  `destino_id` int(11) NOT NULL,
  `pasajeros` int(11) NOT NULL,
  `pago` float NOT NULL,
  `deadline` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- ├ìndices para tablas volcadas
--

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `modeloavion`
--
ALTER TABLE `modeloavion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `avion`
--
ALTER TABLE `avion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `modeloavion`
--
ALTER TABLE `modeloavion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;
