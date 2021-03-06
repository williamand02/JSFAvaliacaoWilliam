# JSFAvaliacaoWilliam

Avaliação N2
Implemente o projeto utilizando o framework Java Server Faces - JSF, de acordo com as regras descritas a seguir.

OBJETIVO GERAL:

Imaginamos que você será responsável pelo desenvolvimento de um software de controle de processos. Onde neste sistema, terá como requisito funcional o cadastro de processos. Desta forma, siga as instruções a seguir para que se possa produzir esta tela.

COMPONENTES DA TELA:

•	Número (Caixa de Texto)
•	Interessado (Caixa de Texto)
•	Assunto (Caixa de Texto)
•	Data de autuação (Caixa de Texto)
•	Valor do processo (Caixa de Texto)
•	Botão “Salvar” (Botão)
•	Botão “Limpar” (Botão)

REGRAS GERAIS:

•	A tela de cadastro será responsável por gravar no BD todas as informações contidas no formulário principal.
•	Todos os campos são obrigatórios.
•	O campo valor deverá aceitar valores maiores que 1 e menores que 50000.
•	Os campos textos deveram obedecer o tamanho das colunas do banco de dados.
•	O campo data deverá aceitar somente valores menores que a data atual e maiores que 01/01/2000.
•	A tela ou opção de listagem de Processo deve conter as seguintes colunas: id, número, interessado, assunto, data de autuação (dd/mm/aaaa), valor, desconto (Para os processos maiores que 100 e com data de autuação maior que 01/01/2008 deve-se aplicar o desconto de 2% {valor * 0.02}) e valor total (valor - desconto).
•	O projeto deverá ter as seguintes funcionalidades: Inclusão, Alteração, Exclusão e Listagem.
•	Tela de menu com as seguintes opções: “Cadastro de Processo”. Crie tela de “Mostrar Processo” ou realize a listagem dos Processos na tela “Cadastro de Processo”.

BANCO DE DADOS:

CREATE TABLE processos
(
  id_proc serial,
  assunto_proc character(20),
  numero_proc character(18),
  interessado_proc character(30),
  data_autuacao_proc date,
  valor_proc numeric(10,2)
)