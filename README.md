# On-Data Backend Server
API REST desenvolvida com Java Springboot para o aplicativo On-Data, desenvolvido como solução de gerenciamento de sinistros para a Odontoprev.

## Equipe
> Artur Lopes Fiorindo » 53481
> 
> responsável pela implementação do endpoint para ocorrências

> Eduardo Felipe Nunes Função » 553362 
> 
> responsável pela implementação do endpoint para pacientes

> Jhoe
> 
> responsável pela implementação do README no GitHub
 
## Funcionalidades
- API com toods os verbos para implementação de um crud
- Conexão com banco de dados Oracle através de JPA/Hibernate

## Como executar
1. Fazer o build do projeto através do arquivo Gradle `build.gradle`
2. Rodar a aplicação Spring em `src/main/java/br/com/fiap/on_data/OnDataApplication.java` 

### Para Testar
- Para realizar os testes da aplicação, está disponibilidada uma collection Bruno em `on-data-collection/` com requests para todos os endpoints implementados
- Como alternativa, o UI do swagger também pode ser usado em `http://localhost:$PORT/swagger-ui/index.html`, sendo $PORT a porta na qual a aplicação está rodando

## Diagrama de Entidades e Relacionamentos
![Untitled](https://github.com/user-attachments/assets/a65fefc6-89d1-40ab-9486-03b65be135db)
**obs.:** As classes Clínica e Dentista ainda não foram implementadas. Por se tratar de um MVP, foram implementados a menor quantidade de classes necessárias para a demonstração da funcionalidade da aplicação, a fim de evitar retrabalhos em caso de mudanças no escopo do projeto.

## Apresentação
A FAZER LINK PARA VIDEO APRESENTAÇÃO

## Endpoints da API

### Paciente Controller

- *GET* /api/v1/pacientes/{id}  
  Obter um paciente por ID

- *PUT* /api/v1/pacientes/{id}  
  Atualizar informações de um paciente

- *DELETE* /api/v1/pacientes/{id}  
  Excluir um paciente por ID

- *GET* /api/v1/pacientes  
  Listar todos os pacientes

- *POST* /api/v1/pacientes  
  Criar um novo paciente

### Ocorrencia Controller

- *GET* /api/v1/ocorrencias/{id}  
  Obter uma ocorrência por ID

- *PUT* /api/v1/ocorrencias/{id}  
  Atualizar informações de uma ocorrência

- *DELETE* /api/v1/ocorrencias/{id}  
  Excluir uma ocorrência por ID

- *GET* /api/v1/ocorrencias  
  Listar todas as ocorrências

- *POST* /api/v1/ocorrencias  
  Criar uma nova ocorrência

### Doença Controller

- *GET* /api/v1/doencas/{id}  
  Obter uma doença por ID

- *PUT* /api/v1/doencas/{id}  
  Atualizar informações de uma doença

- *DELETE* /api/v1/doencas/{id}  
  Excluir uma doença por ID

- *GET* /api/v1/doencas  
  Listar todas as doenças

- *POST* /api/v1/doencas  
  Criar uma nova doença

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
