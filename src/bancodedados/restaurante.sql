/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 100128
Source Host           : localhost:3306
Source Database       : restaurante

Target Server Type    : MYSQL
Target Server Version : 100128
File Encoding         : 65001

Date: 2017-12-07 22:56:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clientes
-- ----------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `cpf_cliente` varchar(11) NOT NULL,
  `nome_cliente` varchar(255) NOT NULL,
  `telefone_cliente` varchar(11) NOT NULL,
  `email_cliente` varchar(255) NOT NULL,
  `sexo_cliente` varchar(20) NOT NULL,
  `estadocivil_cliente` varchar(20) NOT NULL,
  `opcaopromocao_cliente` varchar(3) NOT NULL,
  PRIMARY KEY (`cpf_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of clientes
-- ----------------------------
INSERT INTO `clientes` VALUES ('03105096108', 'Bruno Gomes Rodrigues', '64992351572', 'brunnorodrigues@hotmail.com', 'Masculino', 'Casado(a)', 'Sim');
INSERT INTO `clientes` VALUES ('30944287402', 'Dienne Aparecida Pereira', '64993131873', 'dienneapereira11@gmail.com', 'Feminino', 'Solteiro(a)', 'Não');
INSERT INTO `clientes` VALUES ('44599823400', 'Kênia de Oliveira Barbosa', '64992651108', 'keniadeoliveirabarbosa@gmail.com', 'Feminino', 'Casado(a)', 'Não');
INSERT INTO `clientes` VALUES ('77593487500', 'Walter Martins Rodrigues', '64992741911', 'waltermartinsrodrigues@gmail.com', 'Masculino', 'Casado(a)', 'Não');
INSERT INTO `clientes` VALUES ('98740133900', 'Noemia de Oliveira Gomes Barbosa', '64992187597', 'noemiadeoliveirabarbosa@gmail.com', 'Feminino', 'Casado(a)', 'Sim');

-- ----------------------------
-- Table structure for comandas
-- ----------------------------
DROP TABLE IF EXISTS `comandas`;
CREATE TABLE `comandas` (
  `codigo_comanda` int(11) NOT NULL AUTO_INCREMENT,
  `mesa_comanda` int(100) NOT NULL,
  `descricao_comanda` varchar(500) NOT NULL,
  `garcom_comanda` varchar(100) NOT NULL,
  `data_comanda` varchar(10) NOT NULL,
  `valor_comanda` decimal(10,2) NOT NULL,
  PRIMARY KEY (`codigo_comanda`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comandas
-- ----------------------------
INSERT INTO `comandas` VALUES ('1', '1', 'Prato executivo', 'Juliano', '06/12/2017', '34.90');
INSERT INTO `comandas` VALUES ('2', '3', 'Suco de uva 1L', 'Fernanda', '06/12/2017', '6.00');
INSERT INTO `comandas` VALUES ('3', '7', 'Carne na chapa', 'Fernanda', '06/12/2017', '90.90');
INSERT INTO `comandas` VALUES ('4', '6', 'Sanduíche', 'Larissa', '06/12/2017', '8.90');

-- ----------------------------
-- Table structure for enderecos_clientes
-- ----------------------------
DROP TABLE IF EXISTS `enderecos_clientes`;
CREATE TABLE `enderecos_clientes` (
  `cpf_cliente` varchar(11) NOT NULL,
  `rua_enderecocliente` varchar(255) NOT NULL,
  `numero_enderecocliente` varchar(10) NOT NULL,
  `bairro_enderecocliente` varchar(100) NOT NULL,
  `complemento_enderecocliente` varchar(500) DEFAULT NULL,
  `referencia_enderecocliente` varchar(500) DEFAULT NULL,
  `cep_enderecocliente` varchar(8) NOT NULL,
  `cidade_enderecocliente` varchar(255) NOT NULL,
  `estado_enderecocliente` varchar(50) NOT NULL,
  KEY `cpf_cliente` (`cpf_cliente`),
  CONSTRAINT `enderecos_clientes_ibfk_1` FOREIGN KEY (`cpf_cliente`) REFERENCES `clientes` (`cpf_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of enderecos_clientes
-- ----------------------------
INSERT INTO `enderecos_clientes` VALUES ('03105096108', 'Rua 4-A', '2', 'Mutirão', null, 'Ao lado do Bar do Batata', '75920000', 'Santa Helena de Goiás', 'Goiás (GO)');

-- ----------------------------
-- Table structure for enderecos_fornecedores
-- ----------------------------
DROP TABLE IF EXISTS `enderecos_fornecedores`;
CREATE TABLE `enderecos_fornecedores` (
  `cnpj_fornecedor` varchar(14) NOT NULL,
  `rua_enderecofornecedor` varchar(255) NOT NULL,
  `numero_enderecofornecedor` varchar(10) NOT NULL,
  `bairro_enderecofornecedor` varchar(100) NOT NULL,
  `complemento_enderecofornecedor` varchar(500) DEFAULT NULL,
  `referencia_enderecofornecedor` varchar(500) DEFAULT NULL,
  `cep_enderecofornecedor` varchar(8) NOT NULL,
  `cidade_enderecofornecedor` varchar(255) NOT NULL,
  `estado_enderecofornecedor` varchar(50) NOT NULL,
  KEY `cnpj_fornecedor` (`cnpj_fornecedor`),
  CONSTRAINT `enderecos_fornecedores_ibfk_1` FOREIGN KEY (`cnpj_fornecedor`) REFERENCES `fornecedores` (`cnpj_fornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of enderecos_fornecedores
-- ----------------------------

-- ----------------------------
-- Table structure for estoque
-- ----------------------------
DROP TABLE IF EXISTS `estoque`;
CREATE TABLE `estoque` (
  `codigo_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(100) NOT NULL,
  `fabricante_produto` varchar(100) NOT NULL,
  `descricao_produto` varchar(500) NOT NULL,
  `quantidade_estoque` int(11) NOT NULL,
  `data_estoque` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of estoque
-- ----------------------------
INSERT INTO `estoque` VALUES ('1', 'Arroz', 'Cristal', 'Pacote 5kg', '25', '07/12/2017');
INSERT INTO `estoque` VALUES ('2', 'Feijão', 'Cristal', 'Pacote 2kg', '30', '07/12/2017');

-- ----------------------------
-- Table structure for fornecedores
-- ----------------------------
DROP TABLE IF EXISTS `fornecedores`;
CREATE TABLE `fornecedores` (
  `cnpj_fornecedor` varchar(14) NOT NULL,
  `nome_fornecedor` varchar(255) NOT NULL,
  `telefone_fornecedor` varchar(11) NOT NULL,
  `email_fornecedor` varchar(255) NOT NULL,
  PRIMARY KEY (`cnpj_fornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of fornecedores
-- ----------------------------
INSERT INTO `fornecedores` VALUES ('24312665000132', 'Supermercado Arantes', '6436412244', 'supermercadoarantes@gmail.com');
INSERT INTO `fornecedores` VALUES ('44355126000132', 'Gás Real', '6436412000', 'pedidos@gasreal.com.br');
INSERT INTO `fornecedores` VALUES ('87432421000132', 'Açougue Carne Cheia', '6436419090', 'acougue@carnecheia.net');
INSERT INTO `fornecedores` VALUES ('90923763000155', 'Verdurão Sempre Verde', '6436417833', 'pedidos@sempreverdeverdurao.com.br');

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(255) NOT NULL,
  `telefone_usuario` varchar(11) NOT NULL,
  `email_usuario` varchar(255) NOT NULL,
  `login_usuario` varchar(50) NOT NULL,
  `senha_usuario` varchar(50) NOT NULL,
  `perfil_usuario` varchar(20) NOT NULL,
  `status_usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('1', 'Adminstrador', '64992351572', 'admin@admin', 'admin', 'admin', 'Administrador', 'Sim');
INSERT INTO `usuarios` VALUES ('2', 'Brunno', '64992351572', 'brunnorodrigues@hotmail.com', 'brunno', 'dienne', 'Administrador', 'Sim');
INSERT INTO `usuarios` VALUES ('3', 'Dienne', '64993121873', 'dienneapereira11@gmail.com', 'dienne', 'brunno', 'Funcionário', 'Não');
