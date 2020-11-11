# API de sistema de cartões - Proposta


[Proposta original neste link](https://github.com/claudiooliveirazup/documentacao-cartao-branco)

## Desafio

Nesse treinamento você será responsável por criar um sistema de cartões, porém no escopo de provisionamento do cartão, fatura e extrato, não seremos responsáveis por gerenciar as transações, pois, as mesmas são gerenciadas através de um sistema de rede de captura e o nosso sistema somente será notificado via Apache Kafka!

Para que seja possível desenvolver as funcionalidades citadas acima, precisaremos criar três microsserviços, sim a gente irá trabalhar com arquitetura distribuída (Microsserviços), que irão em algum momento se integrar com o sistema legado (sistema de rede de captura).

O sistema legado é composto por três sistemas:

- Analise: Sistema responsável por efetuar as análises financeiras.
- Contas: Sistema responsável por efetuar operações no cartão como: bloquear, aviso viagem, parcelamento, etc.
- Transações: Sistema responsável por efetuar e propagar as transações do cartão.

O desenvolvimento das funcionalidades devem seguir uma ordem, que deve ser:

1º Desenvolvimento das funcionalidades da Proposta

2º Desenvolvimento das funcionalidades da Transação

3ª Desenvolvimento das funcionalidades da Fatura

## Requisitos - Proposta

##### [Todos os requisitos](https://github.com/claudiooliveirazup/documentacao-cartao-branco/tree/master/proposta)

### Estado atual do projeto
 - &#9745; [Setup do projeto](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/000.setup_projeto.md)
 - &#9745; [Setup do docker compose](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/001.setup_docker_compose.md)
 - &#9745; [Criação da proposta](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/005.criacao_proposta.md)
  - &#9745; [Não pode proposta duplicada](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/010.nao_pode_haver_proposta.md)
  - &#9745; [Consultando dados do solicitante](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/015.consultando_dados_solicitante.md)  
  - &#9745; [Melhorando a visibilidade para a equipe de operação](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/020.melhorando_visibilidade_healthcheck.md) 
  - &#9745; [Criação do cartão](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/025.criacao_cartao.md)  
  - &#9745; [Associar cartão a proposta](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/030.associar_cartao_proposta.md)
  - &#9744; [Acompanhamento da proposta](https://github.com/claudiooliveirazup/documentacao-cartao-branco/blob/master/proposta/035.acompanhamento_proposta.md)