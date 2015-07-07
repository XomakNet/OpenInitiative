-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Июл 07 2015 г., 15:23
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- База данных: `openinitiative`
--

--
-- Дамп данных таблицы `initiativecategory`
--

INSERT INTO `initiativecategory` (`id`, `name`, `description`, `isActive`) VALUES (1, 'Тестовая 1', 'Самае первая тестовая категория', b'1'), (2, 'Тестовая 2', '', b'1'), (3, 'Тестовая 3', '', b'1');

--
-- Дамп данных таблицы `status`
--

INSERT INTO `status` (`id`, `description`, `isCommentable`, `isFinal`, `isVotingActive`, `name`, `isSearchable`) VALUES (1, 'Инициаитива открыта', b'1', b'0', b'1', 'Открыт', b'0');

--
-- Дамп данных таблицы `userrole`
--

INSERT INTO `userrole` (`id`, `isAdministrator`, `isResponser`, `name`) VALUES (1, b'0', b'0', 'Пользователь');

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `email`, `login`, `role_id`, `passwordHash`) VALUES (1, 'register@xomak.net', 'Xomak', 1, 'ffa96067ba10857ce973448dea0715e6');

--
-- Дамп данных таблицы `commentable`
--

INSERT INTO `commentable` (`id`) VALUES (1);

--
-- Дамп данных таблицы `complextext`
--

INSERT INTO `complextext` (`id`, `text`) VALUES (1, '<p>Полное описание Полное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описанием</p>');

--
-- Дамп данных таблицы `initiative`
--

INSERT INTO `initiative` (`description`, `name`, `votesAgainst`, `votesFor`, `id`, `owner_id`, `status_id`, `complextext_id`) VALUES ('Краткое описание описание Краткое описание описание Краткое описание описание Краткое описание описание Краткое описание описание Краткое описание описание ', 'Тестовая инициатива 2', 0, 0, 1, 1, 1, 1);

INSERT INTO  `openinitiative`.`statushistoryitem` (`id` ,`dateTime` ,`comment_id` ,`newStatus_id`) VALUES (NULL ,  '2015-07-07 17:00:00', NULL ,  '1');
--
-- Дамп данных таблицы `initiative_statushistoryitem`
--

INSERT INTO `initiative_statushistoryitem` (`Initiative_id`, `statusHistory_id`) VALUES (1, 1);


