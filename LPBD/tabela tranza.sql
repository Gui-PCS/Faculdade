select 
	imovel.status, categoria.tipoImovel, imovel.construcao, casa.quartos, casa.suites, casa.salaEstar, casa.salaJantar, casa.vagas, casa.area, casa.armario, casa.descricao, endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.UF, endereco.cep, fotos.nome, fotos.URL
	from fotos 
	inner join imovel on imovel.imovelID=fotos.imovelID 
	inner join casa on casa.imovelID=fotos.imovelID 
	inner join endereco on endereco.endID=imovel.endID 
	inner join categoria on categoria.IDcat=imovel.tipoImovel;

select 
	imovel.status, categoria.tipoImovel, imovel.construcao, apartamento.quartos, apartamento.suites, apartamento.salaEstar, apartamento.salaJantar, apartamento.vagas, apartamento.area, apartamento.armario, apartamento.descricao, apartamento.andar, apartamento.valorCondominio, apartamento.portaria24, endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.UF, endereco.cep, fotos.nome, fotos.URL
	from fotos 
	inner join imovel on imovel.imovelID=fotos.imovelID 
	inner join apartamento on apartamento.imovelID=fotos.imovelID 
	inner join endereco on endereco.endID=imovel.endID 
	inner join categoria on categoria.IDcat=imovel.tipoImovel;
	
select 
	imovel.status, categoria.tipoImovel, imovel.construcao, salacomercial.area, salacomercial.banheiros, salacomercial.comodos, salacomercial.descricao, endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.UF, endereco.cep, fotos.nome, fotos.URL
	from fotos 
	inner join imovel on imovel.imovelID=fotos.imovelID 
	inner join salacomercial on salacomercial.imovelID=fotos.imovelID 
	inner join endereco on endereco.endID=imovel.endID 
	inner join categoria on categoria.IDcat=imovel.tipoImovel;

select 
	imovel.status, categoria.tipoImovel, imovel.construcao, terreno.area, terreno.largura, terreno.comprimento, terreno.aclive, terreno.declive, terreno.descricao, endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.UF, endereco.cep, fotos.nome, fotos.URL
	from fotos 
	left join imovel on imovel.imovelID=fotos.imovelID 
	inner join terreno on terreno.imovelID=fotos.imovelID 
	inner join endereco on endereco.endID=imovel.endID 
	inner join categoria on categoria.IDcat=imovel.tipoImovel;

create view ImoveisDisponiveis as
	select 
		transacao.valorEst, categoria.tipoImovel, imovel.status, endereco.bairro, fotos.nome, fotos.URL
		from transacao
		inner join imovel on imovel.imovelID=transacao.idTransacao and (imovel.status = 1 or imovel.status >= 3)
		inner join endereco on endereco.endID=imovel.endID
		inner join fotos on fotos.imovelID=imovel.imovelID
		inner join categoria on categoria.IDcat=imovel.tipoImovel;

create view imoveis_indisponiveis as
	select 
		transacao.valorReal, transacao.valorRepasse, categoria.tipoImovel, imovel.status, endereco.bairro
		from transacao
		inner join imovel on imovel.imovelID=transacao.idTransacao and (imovel.status = 0 or imovel.status = 2)
		inner join endereco on endereco.endID=imovel.endID
		inner join fotos on fotos.imovelID=imovel.imovelID
		inner join categoria on categoria.IDcat=imovel.tipoImovel;

update transacao, imovel set transacao.valorReal = 250000,00 , transacao.valorRepasse = transacao.valorReal*0.1 , transacao.`data` = '2022-10-24' , imovel.status = 0;
select * from transacao;
