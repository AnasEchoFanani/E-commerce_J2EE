-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 26 août 2023 à 01:58
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `miniproject2`
--

-- --------------------------------------------------------

--
-- Structure de la table `catego`
--

CREATE TABLE `catego` (
  `id` int(11) NOT NULL,
  `nomCategori` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `catego`
--

INSERT INTO `catego` (`id`, `nomCategori`) VALUES
(1, 'chi');

-- --------------------------------------------------------

--
-- Structure de la table `command`
--

CREATE TABLE `command` (
  `id` int(11) NOT NULL,
  `idusers` int(11) DEFAULT NULL,
  `idproduit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `linecommand`
--

CREATE TABLE `linecommand` (
  `id` int(11) NOT NULL,
  `qnt` int(11) DEFAULT NULL,
  `idPoduit` int(11) DEFAULT NULL,
  `idCommand` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nomProduit` varchar(40) DEFAULT NULL,
  `qnt` int(11) DEFAULT NULL,
  `idCategor` int(11) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `image` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nomProduit`, `qnt`, `idCategor`, `prix`, `image`) VALUES
(2, 'anas', 1, 1, 1, '0b179504-412d-4af7-9e00-3e3d92633577_8.jpg'),
(3, 'ana', 1, 1, 1, 'butterfly-insect-animal-abstract-digital-art-hd-wallpaper-uhdpaper.com-99@0@i.jpg'),
(4, 'anassf', 1, 1, 1, 'Capture d��cran 2023-08-13 020700.png'),
(5, 'anassf', 1, 1, 1, '0b179504-412d-4af7-9e00-3e3d92633577.jpg'),
(6, 'anas', 1, 1, 1, '0b179504-412d-4af7-9e00-3e3d92633577.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nomRoles` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `nomRoles`) VALUES
(1, 'Admin'),
(2, 'User'),
(3, 'Secreter'),
(4, 'Partenaire'),
(5, 'lol'),
(6, 'lal'),
(7, 'lopl'),
(8, 'sas'),
(9, 'hahah'),
(10, 'kakaka'),
(11, 'sasasa');

-- --------------------------------------------------------

--
-- Structure de la table `userss`
--

CREATE TABLE `userss` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `idRoles` int(11) DEFAULT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `userss`
--

INSERT INTO `userss` (`id`, `nom`, `prenom`, `email`, `age`, `idRoles`, `password`) VALUES
(1, 'anas', 'fanani', 'anassfanani123@gmail.com', 21, 2, '$2a$10$AlL9X0AsRqZPsK25Xp2jQuu28niEniB2M54iI3sX8ds1p06pIXwWG');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `catego`
--
ALTER TABLE `catego`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `command`
--
ALTER TABLE `command`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idusers` (`idusers`),
  ADD KEY `idproduit` (`idproduit`);

--
-- Index pour la table `linecommand`
--
ALTER TABLE `linecommand`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPoduit` (`idPoduit`),
  ADD KEY `idCommand` (`idCommand`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCategor` (`idCategor`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `userss`
--
ALTER TABLE `userss`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idRoles` (`idRoles`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `catego`
--
ALTER TABLE `catego`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `command`
--
ALTER TABLE `command`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `linecommand`
--
ALTER TABLE `linecommand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `userss`
--
ALTER TABLE `userss`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `command`
--
ALTER TABLE `command`
  ADD CONSTRAINT `command_ibfk_1` FOREIGN KEY (`idusers`) REFERENCES `userss` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `command_ibfk_2` FOREIGN KEY (`idproduit`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `linecommand`
--
ALTER TABLE `linecommand`
  ADD CONSTRAINT `linecommand_ibfk_1` FOREIGN KEY (`idPoduit`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `linecommand_ibfk_2` FOREIGN KEY (`idCommand`) REFERENCES `command` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`idCategor`) REFERENCES `catego` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `userss`
--
ALTER TABLE `userss`
  ADD CONSTRAINT `userss_ibfk_1` FOREIGN KEY (`idRoles`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
