# TABLE_PER_CLASS
##Nós usamos herança em java para adicionar extensibilidade e reusibilidade para usar e criar novas classes de nossas classes domínios como simples objetos Java antigos que podem usar herança quando aplicadas ou aplicáveis e possíveis.

## Por exemplo temos:

### 1. caso de uso Pagamento.
### 2. Duas formas de pagamento: cartão de crédito ou um cheque.
### 3. Quando aplicamos herança para todos estes campos em comum como ID e Montante, vamos a uma classe pai chamada Pagamento. E esses dois modos de pagamento tem seus próprios filhos.
### 4. E eles terão campos específicos e outros que não são em comum.
### 5. Cartão de Crédito: cardnumber
### 6. Cheque: chequenumber
### 7. Mas basicamente, os databases não suportam mapeamento de herança através das tabelas do database. ( isso é um problema em ORM ).
### 8. E para resolver este problema, o JPA provê mapeamento de herança através de três tipos de simples tabelas "Strategies":
#### a. SINGLE_TABLE
##### 1. Essa " Strategie "" traz todas as informações de Cartão de crédito ou cheque, numa simples tabela:
|  PMODE     | 
| :---:         |
|   cc   |
|   cq   |
##### 1.1  cc - Cartão de crédito - Quando o Hibernate verifica " cc ", ele sabe que essa linha tem que ser convertida num cartão de crédito.
##### 1.2 cq - Cheque - Quando o Hibernate verifica " cq ", ele sabe que essa linha tem que ser convertida num cheque.
##### 2. Para isso ocorrer, utilizamos duas anotações: @Inheritance e @DiscriminatorColumn em Pagamento ( classe Pai ).
##### 3. E utilizamos @DiscriminatorValue nas classes-filhas.

#### b. TABLE_PER_CLASS
##### 1. Essa "Strategie" traz todas as informações de Cartão de crédito ou cheque, serem armazenadas nos campos apropriados das tabelas:
###### cc
|   id   |  amount  |    cardnumber    |
| :---         |     :---:      |          ---: |
| alinhado a esquerda   | alinhado ao centro     | alinhado a direita    |
###### cq
|   id   |  amount  |    checknumber    |
| :---         |     :---:      |          ---: |
| alinhado a esquerda   | alinhado ao centro     | alinhado a direita    |

##### 1.1 Tabelas recuperam informações através dos ID's.
##### 1.2 Apesar de ser mais rápida, não é muito recomendada como ela faz a duplicação das colunas através das tabelas. É possível que gere alguma falha de normalização da regra.
#### c. JOINED
##### 1. É um dos mais populares e mais usados mapeamento de heranças " Strategies ".
##### 2. Toda classe na hierarquia de herança terá sua própria tabela no database:
###### Pagamento : classe pai que carregará os campos comuns através das classes-filhas e cada filha.
|   id ( primary key )  |  amount  |
| :---:        |     :---:      |
| :---:   |   :---:    |
| :---:   |   :---:    |
###### cartao : e cada classe carregará o campo específico a esse filho, por ex., card tem: cardnumber.
|   id ( foreign key )  |  cardnumber  |
| :---:        |     :---:      |
| :---:   |   :---:    |
| :---:   |   :---:    |
###### cheque : e cada classe carregará o campo específico a esse filho, por ex., cheque tem: chequenumber.
|   id ( foreign key )   |  checknumber  |
| :---:        |     :---:      |
| :---:   |   :---:    |
| :---:   |   :---:    |
##### 3. E todas estas tabelas estão conectadas à tabela Pai que está conectada a cada uma das filhas pelas chaves de relacionamento: " Primary Key " e " Foreign Key ".
##### 4. Nós não precisamos de uma "discriminator column".
##### 5. A vantagem de ser uma das melhores heranças de mapeamentos " Strategies ":
###### a. Cada tabela armazena dados limitados e segue a normalização ( cada tabela carrega um mínimo de dados ).
##### 5. A desvantagem é que o hibernate terá que juntar ( fazer o " join ")  essas tabelas para recuperar esses dados, e os ler novamente.
##### 6. Mas isso é esperado pelas aplicações criadas por empresas.
