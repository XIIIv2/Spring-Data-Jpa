CREATE DATABASE IF NOT EXISTS `spring_data_jpa`
    /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */
    /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE IF NOT EXISTS `users` (
     `id` bigint unsigned NOT NULL AUTO_INCREMENT,
     `name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
     `email` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
     PRIMARY KEY (`id`),
     UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `posts` (
     `id` bigint unsigned NOT NULL AUTO_INCREMENT,
     `content` varchar(4096) COLLATE utf8mb4_general_ci NOT NULL,
     `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
     `author_id` bigint unsigned NOT NULL,
     PRIMARY KEY (`id`),
     KEY `FK6xvn0811tkyo3nfjk2xvqx6ns` (`author_id`),
     CONSTRAINT `FK6xvn0811tkyo3nfjk2xvqx6ns` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
