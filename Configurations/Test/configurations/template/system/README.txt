ATEN��O !!!

Os arquivos nessa pasta s�o utilizados pelo mecanismo de processamento de templates para a gera��o de
pdf's.
Qualquer altera��o nesses arquivos afetar�o todos os templates gerados.
Esse arquivos s�o utilizados como parte da abstra��o da gera��o de templates.
O processamento dos arquivos header.snippet e table.snippet ir�o produzir uma vari�vel com o nome $fullData
que poder� ser utilizada como fonte completa de dados para o template.
Al�m do template completo, o processamento desse arquivos produzir�o vari�veis contendo os dados espec�ficos de 
cada recordset no relat�rios. 
Por exemplo:
Para o cabe�alho do relat�rio ser� gerado: header_XXXXX
Para os dados ser� gerado: XXXXX
Sendo XXXXX o ID do recordset.
O mesmo resultado pode ser obtido inserindo o c�digo do arquivo complete.snippet.
O arquivo complete.snippet n�o � utilizado internamente pelo sistema. � somente uma refer�ncia para
usu�rios mais avan�ados.
Os templates s�o baseados no framework Velocity (http://velocity.apache.org/)
