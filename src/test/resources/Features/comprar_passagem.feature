# language: pt


Funcionalidade: Busca de Passagens e reservar
  
Contexto: Busca

Dado que esteja na tela inicial do site

Esquema do Cenário: Busca Sucesso e reservar
Quando determino tipo de passagem
E informar uma <origem> válida
E inserir um <destino> válido
E uma data de ida válida
E clicar em Buscar passagens
Então a tela com as opções de passagens será exibida e prosseguirá
E informe os dados do passageiro e prosseguir
E escolher assento e servicos
Então finalizar o cadastro e validar a página de pagamento

Exemplos:

|origem     |destino   |
|"São Paulo - Todos os Aeroportos (SAO)"|"Rio de Janeiro - Todos os Aeroportos (RIO)"|