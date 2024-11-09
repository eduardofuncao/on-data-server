# On-Data Backend Server
API REST desenvolvida com Java Springboot para o aplicativo On-Data, desenvolvido como solução de gerenciamento de sinistros para a Odontoprev.
link Github: https://github.com/eduardofuncao/on-data-server

## Equipe
> Artur Lopes Fiorindo » 53481
>
> responsável pela implementação do endpoint para ocorrências

> Eduardo Felipe Nunes Função » 553362
>
> respnsável pela implementação do endpoint para pacientes

> Jhoe Yoshio Kochi Hashimoto 553831
>
> responsável pela implementação do README no GitHub


## Descrição do projeto
![OnData](https://github.com/user-attachments/assets/87ad94eb-a00e-43b5-84c4-fbf7f7b9fd7d)

On Data é um ecossistema criado para auxiliar para o gerenciamento de pedidos de reembolso para sinistros em planos médicos (especialmente para planos dentários). Para isso, o sistema será responsável por classificar pacientes por classe de risco associado (baseado em histórico hospitalar, status socioeconômico) e analisar reivindicações de sinistros, facilitando o processo de aprovação por parte dos funcionários de seguradoras médicas.
Na primeira etapa do projeto, foi desenvolvido um sistema modelo com Pacientes, Ocorrências e Doenças. As ocorrências carregam as informações da reivindicação de sinistros para os pacientes (como valor, data, doença associada, e se foi aprovada ou não), sendo os principais dados utilizados para a categorização dos pacientes e ranqueamento dos sinistros por risco associado.

## Funcionalidades
- API com toods os verbos para implementação de um crud
- Conexão com banco de dados Oracle através de JPA/Hibernate

## Como executar
1. Fazer o build do projeto através do arquivo Gradle `build.gradle`
2. Rodar a aplicação Spring em `src/main/java/br/com/fiap/on_data/OnDataApplication.java`

### Para Testar
- Para realizar os testes da aplicação, está disponibilidada uma collection Insomnia em `on-data-collection/` com requests para todos os endpoints implementados
- Como alternativa, o UI do swagger também pode ser usado em `http://localhost:$PORT/swagger-ui/index.html`, sendo $PORT a porta na qual a aplicação está rodando

## Diagrama de Entidades e Relacionamentos
![Untitled](https://github.com/user-attachments/assets/1f80d9cb-08d4-4d96-8207-a67ef1b229ce)

## Implementação hateoas
Foi implementado o paradigma hateoas no fluxo de aprov ação de ocorrências, conforme o diagrama a seguir:
![image](https://github.com/user-attachments/assets/016f526d-b829-440f-8f9e-7c85cf71c487)
Para todas as conexões deste fluxo, é possível visualizar a próxima etapa através de um link hateoas. O fluxo escolhido foi o de prospecção de ocorrências não aprovadas para posterior aprovação do funcionário da empresa de plano de saúde.

## Apresentação
https://youtu.be/eZkiuw65Szw

## Endpoints da API

### Paciente Controller

![image](https://github.com/user-attachments/assets/d3671843-a6c8-45fc-8171-e7e6f3feb772)

![image](https://github.com/user-attachments/assets/71e1a1cf-3c75-4964-9dd8-2169d8c3064b)

![image](https://github.com/user-attachments/assets/109c160f-ba61-407c-aff9-5636ad4c8a48)

![image](https://github.com/user-attachments/assets/64896e57-9eb4-4af1-b4af-832f4937f2db)

![image](https://github.com/user-attachments/assets/a44939e5-215e-41a9-a52c-ef8a77e79ef4)


## Cronograma de atividades
| Data  | Responsável    | Atividade                                                                            | Status       |
| ----- | -------------- | ------------------------------------------------------------------------------------ | ------------ |
| 01/07 | Grupo          | Ideação do projeto                                                                   | Concluído    |
| 02/07 | Jhoe           | Criação do diagrama de classes e diagramas de entidades                              | Concluído    |
| 05/07 | Eduardo        | Desenvolvimento do modelo, controller, service e repository para a classe Paciente   | Concluído    |
| 10/07 | Artur          | Desenvolvimento do modelo, controller, service e repository para a classe Ocorrência | Concluído    |
| 10/07 | Artur          | Desenvolvimento do modelo, controller, service e repository para a classe Doença     | Concluído    |
| 15/07 | Jhoe           | Adaptação do código para inclusão de DTO                                             | Concluído    |
| 20/07 | Eduardo        | Criação de ErrorHandler Global                                                       | Concluído    |
| 10/10 | Eduardo, Artur | Implementação de classes de erro personalizadas                                      | Em Progresso |
| 15/10 | Artur, Jhoe    | Implementação das classes de Clínica e Dentista                                      | A fazer      |
