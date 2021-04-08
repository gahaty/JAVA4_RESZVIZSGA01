-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2021. Ápr 08. 12:22
-- Kiszolgáló verziója: 10.4.14-MariaDB
-- PHP verzió: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `forum`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `user_name_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `post_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `comment`
--

INSERT INTO `comment` (`id`, `user_name_id`, `comment`, `datetime`, `post_id`) VALUES
(1, 3, 'Olyan korán, amint lehet és olyan későn, amennyire kell.', '2021-04-06 12:36:23', 1),
(2, 2, 'Ha a talaj felmelegedett, kellően kiszáradt és teherbíró, valamint a talaj hőmérséklete elérte a 8–10 °C-ot, akkor normál körülmények között a vetés április közepétől május közepéig elvégezhető.', '2021-04-06 12:36:44', 1),
(3, 2, 'Egyáltalán , hallott már valaki ilyesmiről?', '2021-04-07 10:58:57', 2),
(4, 5, '5 évnél idősebb tőkékkel nehezen tudom elképzelni a kivitelezést:\r\n- technikailag (konkrét leirás nélkül) nem tudom elképzelni az \"oda bele 1-2 vesszőt\" (nem fognak megeredni a vesszők)\r\n- idősebb tőkék hajlamosak hasadni\r\n(szerintem) inkább a \'zöldoltást\' próbáld meg (vagy újratelepítés)!', '2021-04-07 11:05:41', 2),
(5, 4, 'Én szeretem Ákos zenéjét. Szerintem naggggyon jó!\r\nÉppen most csinálok egy válogatást magamnak a kedvenc számokból. Ha meg van, akkor leírom ide a címeket.', '2021-04-08 09:55:51', 3),
(6, 5, 'A Depeche Mode topicban már sokat foglalkoztunk Ákossal és a BB-vel, de azért jó, hogy megnyitottad ezt a topicot.\r\nA kedvenc albumom tőle az Ikon. A Karcolatok sajnos nagyon nem tetszik. A Test albumról a kedvenc számom a Csak Te vagy. Megpróbálok összeállítani egy Ákos top-ot, a sorrend nem a tetszés erőőségét fejezi ki.\r\n\r\n1. Csak te vagy\r\n2. Ismerj fel\r\n3. Test\r\n4. Szabadíts fel\r\n5. Örvény\r\n6. Beavatás\r\n7. Minden egyszerű dalban\r\n8. Get down\r\n9. Hello\r\n10. Ikon', '2021-04-08 09:56:45', 3);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `user_name_id` int(11) NOT NULL,
  `title` varchar(20) NOT NULL,
  `post` text NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `topic_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `post`
--

INSERT INTO `post` (`id`, `user_name_id`, `title`, `post`, `datetime`, `topic_id`) VALUES
(1, 1, 'Kukorica vetése', 'Mikor van a vetés megfelelő ideje?\r\nElkezdhetem vetni most, vagy várjak még vele pár hetet?', '2021-04-06 11:49:00', 1),
(2, 4, 'Szőlő oltás', 'Szőlő termesztésben jártas személy segítségét kérném.\r\nVan egy kis szőlőm ( 2-3 hektónyi ) , amiben kb 20 olyan tő van ,amely igen életerős , bőventermő , csak éppen október végére is csak 13-14 must fokra érik be.No , ezeket szeretném leváltani. Valahol olvastam , hogy lehetséges gyökérnyakba átoltani.Próbálta ezt már valaki?\r\nMásik kérdésem igaz-e ,hogy a Bianca fajtát egyszerüen lelehet dugni mert a filoxéra sem bántja?(A szokásos betegségek ellen tényleg elég immunis , volt olyan év , hogy minden más fajtát elvitt a peronoszpóra!)A szőlőm Érd környékén van.\r\nElőre is köszönöm a segítséget!', '2021-04-07 10:53:43', 1),
(3, 3, 'Ákos', 'Szia mindenki, aki szereti vagy nem szereti Ákost, de inkább az előbbi. :) Én például nagyon szeretem amit csinál. A koncertjei nagyszerűek.\r\nKinek mi a kedvence tőle?\r\nAki meg nem szereti, az miért nem (ha egyáltalán meg tudja fogalmazni értelmesen)?', '2021-04-08 09:50:29', 2);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `topic`
--

CREATE TABLE `topic` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `user_name_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `topic`
--

INSERT INTO `topic` (`id`, `name`, `user_name_id`) VALUES
(1, 'Kertészet', 1),
(2, 'Zene', 2),
(3, 'Foci', 3),
(4, 'Gasztronómia', 4),
(5, 'Művészet', 5);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `user_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`id`, `user_name`) VALUES
(1, 'gabi'),
(2, 'misi'),
(3, 'benő'),
(4, 'elza'),
(5, 'lilla');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `commen_cross_post_id` (`post_id`),
  ADD KEY `comment_cross_username` (`user_name_id`);

--
-- A tábla indexei `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `post_cross_username` (`user_name_id`),
  ADD KEY `post_cross_topic_id` (`topic_id`);

--
-- A tábla indexei `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `topic_cross_username` (`user_name_id`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT a táblához `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT a táblához `topic`
--
ALTER TABLE `topic`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `commen_cross_post_id` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  ADD CONSTRAINT `comment_cross_username` FOREIGN KEY (`user_name_id`) REFERENCES `user` (`id`);

--
-- Megkötések a táblához `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_cross_topic_id` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`),
  ADD CONSTRAINT `post_cross_username` FOREIGN KEY (`user_name_id`) REFERENCES `user` (`id`);

--
-- Megkötések a táblához `topic`
--
ALTER TABLE `topic`
  ADD CONSTRAINT `topic_cross_username` FOREIGN KEY (`user_name_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
