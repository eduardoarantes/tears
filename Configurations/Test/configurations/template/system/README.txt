ATENÇÃO !!!

Os arquivos nessa pasta são utilizados pelo mecanismo de processamento de templates para a geração de
pdf's.
Qualquer alteração nesses arquivos afetarão todos os templates gerados.
Esse arquivos são utilizados como parte da abstração da geração de templates.
O processamento dos arquivos header.snippet e table.snippet irão produzir uma variável com o nome $fullData
que poderá ser utilizada como fonte completa de dados para o template.
Além do template completo, o processamento desse arquivos produzirão variáveis contendo os dados específicos de 
cada recordset no relatórios. 
Por exemplo:
Para o cabeçalho do relatório será gerado: header_XXXXX
Para os dados será gerado: XXXXX
Sendo XXXXX o ID do recordset.
O mesmo resultado pode ser obtido inserindo o código do arquivo complete.snippet.
O arquivo complete.snippet não é utilizado internamente pelo sistema. É somente uma referência para
usuários mais avançados.
Os templates são baseados no framework Velocity (http://velocity.apache.org/)
