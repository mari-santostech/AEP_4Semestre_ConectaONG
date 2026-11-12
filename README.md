# AEP_4Semestre_ConectaONG

## Sobre o Projeto
O **ConectaONG** é uma solução tecnológica voltada para o gerenciamento e a intermediação do fluxo de doação de excedentes alimentícios entre estabelecimentos comerciais (restaurantes, lanchonetes e mercados) e instituições beneficentes (ONGs e abrigos comunitários).

---

## Alinhamento com os Objetivos de Desenvolvimento Sustentável (ODS)
* **ODS 2 — Fome Zero e Agricultura Sustentável:** Contribuindo com o direcionamento de refeições nutritivas e insumos alimentícios para entidades que atendem populações em situação de vulnerabilidade social.
* **ODS 12 — Consumo e Produção Responsáveis:** Promovendo a redução do desperdício de alimentos por meio da tecnologia.

---

## Lista de Requisitos

* **RF01:** O sistema deve permitir o cadastro de doadores (restaurantes e comércios), contendo Nome Fantasia, CNPJ, nome do responsável, telefone, e-mail e endereço completo.
* **RF02:** O sistema deve permitir o cadastro de entidades beneficentes (ONGs e abrigos), contendo Nome Fantasia, CNPJ, responsável técnico, telefone, e-mail e endereço completo.
* **RF03:** O sistema deve permitir o registro de doações de alimentos, relacionando o restaurante doador, a ONG recebedora, a data da doação e o status inicial do pedido.
* **RF04:** O sistema deve permitir a inclusão de itens na doação, informando a descrição do alimento, a categoria (ex.: refeição pronta, hortifrúti, grãos/secos), a quantidade em quilogramas ou unidades e a data de validade.
* **RF05:** O sistema deve permitir a atualização e o gerenciamento do status da doação, alternando entre as etapas de *Aguardando Aceite*, *Preparando Doação*, *Aguardando Retirada* ou *Em Transporte*, *Concluída* ou *Cancelada*.
* **RF06:** O sistema deve permitir a consulta e listagem do histórico de doações efetuadas por um doador específico ou recebidas por uma determinada ONG.

---

## Cronograma de Execução

| DATAS | ATIVIDADE | RESPONSÁVEL |
| :---: | :---: | :---: |
| 01/09/2026 | Escopo e Alinhamento ODS | Mariana/Juliana |
| 01/09/2026 | Levantamento de Requisitos | Juliana |
| 06/09/2026 | Justificativa Técnica e Arquitetural | Tiago |
| 06/09/2026 | Modelagem de Dados | Tiago |
| 04/09/2026 | Modelagem de Classes | Mariana |
| 09/09/2026 | Estruturação Repositório GitHub | Mariana |
| 11/09/2026 | 1ª Entrega (Escopo e GitHub) | Todos |
| 17/10/2026 - 25/10/2026 | Desenvolvimento e integração com o banco de dados | Todos |
| 26/10/2026 - 31/10/2026 | Testes e validações | Todos |
| 01/11/2026 | 2ª Entrega (Código-fonte) | Todos |

---

## Tecnologias e Arquitetura
* **Linguagem Backend:** Java (Orientação a Objetos com Herança, Polimorfismo e Composição)
* **Banco de Dados:** Banco de Dados Relacional (MySQL)
* **Modelagem Técnica:** UML (Diagrama de Classes Astah) e Diagrama Entidade-Relacionamento (DER)

## Pré-Requisitos e Execução

* **JDK 21** instalado e configurado nas variáveis de ambiente (`JAVA_HOME`).
* **MySQL Server** (versão 8.0 ou superior) ativo na porta padrão `3306`.
* **Maven** (ou utilização do Maven Wrapper `./mvnw` incluso no projeto).
* IDE Java de preferência (IntelliJ IDEA).

### Configuração do DB
1. Execute o script SQL localizado na pasta `/database` no seu servidor MySQL para criar o banco de dados e as tabelas.
2. Abra o arquivo `src/main/resources/application.properties` e ajuste o usuário e a senha conforme a configuração do seu MySQL local:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/conectaong
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
