
-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `full_name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role_id` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `full_name`, `email`, `password`, `role_id`) VALUES
(1, 'Ronny Sugianto', '201843502340@kkp.it', 'root2021', 1),
(7, 'Wisnu Wahyudi', '201843500024@kkp.it', 'root2021', 1),
(8, 'Riza Herman', '201843501782@kkp.it', 'root2021', 2),
(9, 'Vernanda Ramadhanti', '201843502476@kkp.it', 'root2021', 3),
(10, 'Ridwan', '201843502092@kkp.it', 'root2021', 4),
(11, 'Yoel Adrian Sihombing', '201843501024@kkp.it', 'root2021', 4);
