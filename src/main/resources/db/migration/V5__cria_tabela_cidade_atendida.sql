CREATE TABLE `cidade_atendida` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `cidade` VARCHAR(255) NOT NULL,
    `codigo_ibge` VARCHAR(255) NOT NULL,
    `estado` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `cidades_usuarios` (
    `cidade_id` BIGINT NOT NULL,
    `usuario_id` BIGINT NOT NULL,
    KEY (`usuario_id`),
    KEY (`cidade_id`),
    CONSTRAINT FOREIGN KEY (`cidade_id`) REFERENCES `cidade_atendida` (`id`),
    CONSTRAINT FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
)