-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 04/12/2018 às 11:34
-- Versão do servidor: 10.2.18-MariaDB
-- Versão do PHP: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `u613749268_invsc`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `bem`
--

CREATE TABLE `bem` (
  `id` int(11) NOT NULL,
  `cat_depre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_aquis` date DEFAULT NULL,
  `data_da_baixa` date DEFAULT NULL,
  `denominacao` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `especificacao` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `garantia` date DEFAULT NULL,
  `grupo_material` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_sala` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `marca` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `motivo_da_baixa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `num_nota_fiscal` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `num_tombamento` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `obsr_baixa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `situacao` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `valor_atual` float DEFAULT NULL,
  `valor_compra` float DEFAULT NULL,
  `vida_util` date DEFAULT NULL,
  `sala_atual` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `departamento`
--

CREATE TABLE `departamento` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_predio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `departamento`
--

INSERT INTO `departamento` (`id`, `nome`, `id_predio`) VALUES
(11, 'Departamento de Patrimônio', 6);

-- --------------------------------------------------------

--
-- Estrutura para tabela `local`
--

CREATE TABLE `local` (
  `id` int(11) NOT NULL,
  `cidade` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `unidade_adminstra` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `local`
--

INSERT INTO `local` (`id`, `cidade`, `estado`, `nome`, `unidade_adminstra`) VALUES
(7, 'Sede', 'Sede', 'Localização do Patrimônio', 'CAMPUS_SAMAMBAIA');

-- --------------------------------------------------------

--
-- Estrutura para tabela `movimentacao`
--

CREATE TABLE `movimentacao` (
  `id` int(11) NOT NULL,
  `data_cancelamento` date DEFAULT NULL,
  `data_entrada` date DEFAULT NULL,
  `data_saida` date DEFAULT NULL,
  `etapa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `motivo_cancelamento` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `aprovador_entrada` int(11) DEFAULT NULL,
  `aprovador_saida` int(11) DEFAULT NULL,
  `bem_patrimonial` int(11) DEFAULT NULL,
  `sala_destino` int(11) DEFAULT NULL,
  `sala_origem` int(11) DEFAULT NULL,
  `solicitante` int(11) DEFAULT NULL,
  `user_cancelamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `ordem_de_servico`
--

CREATE TABLE `ordem_de_servico` (
  `id` int(11) NOT NULL,
  `data_abertura` date DEFAULT NULL,
  `data_fechamento` date DEFAULT NULL,
  `motivo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prestadora_de_servico` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `situacao` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `valor` float NOT NULL,
  `bem_patrimonial` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `predio`
--

CREATE TABLE `predio` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_local` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `predio`
--

INSERT INTO `predio` (`id`, `nome`, `id_local`) VALUES
(6, 'Prédio do Patrimônio', 7);

-- --------------------------------------------------------

--
-- Estrutura para tabela `sala`
--

CREATE TABLE `sala` (
  `id` int(11) NOT NULL,
  `num` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_departamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `sala`
--

INSERT INTO `sala` (`id`, `num`, `id_departamento`) VALUES
(17, 'Depósito', 11);

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `profile` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_departamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `user`
--

INSERT INTO `user` (`id`, `email`, `nome`, `profile`, `senha`, `id_departamento`) VALUES
(22, 'pedro@gmail.com', 'Pedro', 'CHEFE_DEPART', '123', 11);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `bem`
--
ALTER TABLE `bem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdi6x6vxteltdc0xipp4wa8a8e` (`sala_atual`);

--
-- Índices de tabela `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm99dcvppmw2k9eepob16g71r7` (`id_predio`);

--
-- Índices de tabela `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `movimentacao`
--
ALTER TABLE `movimentacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrb9efu08mymcn74i7rmxk9joi` (`aprovador_entrada`),
  ADD KEY `FK5075u8dp1qwtqxof1x8drn2ie` (`aprovador_saida`),
  ADD KEY `FKkmcl6thvcfj3jx0yp8mjw67pj` (`bem_patrimonial`),
  ADD KEY `FKmhhs7pvgqnjpwcofudqb3fviy` (`sala_destino`),
  ADD KEY `FK6h6d61snoaq8chg58sh55h6ja` (`sala_origem`),
  ADD KEY `FKk0su2ov65o63g2uoffkmoplnr` (`solicitante`),
  ADD KEY `FKrib5r34sai86tffvhyut8t0pa` (`user_cancelamento`);

--
-- Índices de tabela `ordem_de_servico`
--
ALTER TABLE `ordem_de_servico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2sltu7crh0gqfsjmbqfcsbbom` (`bem_patrimonial`);

--
-- Índices de tabela `predio`
--
ALTER TABLE `predio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmyob0byxohg1wcsic45lca4s3` (`id_local`);

--
-- Índices de tabela `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKma46tu2o9bup6vleq2d7jn642` (`id_departamento`);

--
-- Índices de tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8uvqmi1nhnho62sosukk78b9i` (`id_departamento`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `bem`
--
ALTER TABLE `bem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de tabela `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `local`
--
ALTER TABLE `local`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `movimentacao`
--
ALTER TABLE `movimentacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `ordem_de_servico`
--
ALTER TABLE `ordem_de_servico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `predio`
--
ALTER TABLE `predio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `sala`
--
ALTER TABLE `sala`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `bem`
--
ALTER TABLE `bem`
  ADD CONSTRAINT `FKdi6x6vxteltdc0xipp4wa8a8e` FOREIGN KEY (`sala_atual`) REFERENCES `sala` (`id`);

--
-- Restrições para tabelas `departamento`
--
ALTER TABLE `departamento`
  ADD CONSTRAINT `FKm99dcvppmw2k9eepob16g71r7` FOREIGN KEY (`id_predio`) REFERENCES `predio` (`id`);

--
-- Restrições para tabelas `movimentacao`
--
ALTER TABLE `movimentacao`
  ADD CONSTRAINT `FK5075u8dp1qwtqxof1x8drn2ie` FOREIGN KEY (`aprovador_saida`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK6h6d61snoaq8chg58sh55h6ja` FOREIGN KEY (`sala_origem`) REFERENCES `sala` (`id`),
  ADD CONSTRAINT `FKk0su2ov65o63g2uoffkmoplnr` FOREIGN KEY (`solicitante`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKkmcl6thvcfj3jx0yp8mjw67pj` FOREIGN KEY (`bem_patrimonial`) REFERENCES `bem` (`id`),
  ADD CONSTRAINT `FKmhhs7pvgqnjpwcofudqb3fviy` FOREIGN KEY (`sala_destino`) REFERENCES `sala` (`id`),
  ADD CONSTRAINT `FKrb9efu08mymcn74i7rmxk9joi` FOREIGN KEY (`aprovador_entrada`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKrib5r34sai86tffvhyut8t0pa` FOREIGN KEY (`user_cancelamento`) REFERENCES `user` (`id`);

--
-- Restrições para tabelas `ordem_de_servico`
--
ALTER TABLE `ordem_de_servico`
  ADD CONSTRAINT `FK2sltu7crh0gqfsjmbqfcsbbom` FOREIGN KEY (`bem_patrimonial`) REFERENCES `bem` (`id`);

--
-- Restrições para tabelas `predio`
--
ALTER TABLE `predio`
  ADD CONSTRAINT `FKmyob0byxohg1wcsic45lca4s3` FOREIGN KEY (`id_local`) REFERENCES `local` (`id`);

--
-- Restrições para tabelas `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `FKma46tu2o9bup6vleq2d7jn642` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`);

--
-- Restrições para tabelas `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK8uvqmi1nhnho62sosukk78b9i` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
