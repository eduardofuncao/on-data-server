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

## Diagrama de Classes
A respeito do Diagram Físico não estar 100% idêntico com as Classes temos que lembrar que a aplicação ainda se trata de um MVP.

## Apresentação
A FAZER LINK PARA VIDEO APRESENTAÇÃO

## Endpoints da API

## Paciente Controller

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

## Ocorrencia Controller

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

## Doença Controller

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
