# ArenaBook API

A **ArenaBook API** é uma solução moderna para gestão de quadras esportivas, desenvolvida em **Java 21 com Spring Boot**.  
Pensada para **administradores de estabelecimentos esportivos** e **jogadores**, a plataforma oferece uma experiência ágil e intuitiva para reservas, controle de disponibilidade e gerenciamento de estabelecimentos.

## **Características Principais**
- **Multi-estabelecimento**: um usuário pode administrar vários locais esportivos em uma única conta
- **Controle inteligente de quadras**: gerencie preços, horários e disponibilidade de forma simples
- **Reservas online**: facilite a vida dos jogadores com agendamento rápido e confirmação em tempo real
- **Relatórios estratégicos**: visualize estatísticas de ocupação e faturamento para melhor tomada de decisão
- **Notificações automatizadas**: mantenha clientes e administradores informados sobre confirmações, lembretes e cancelamentos

## **Para quem é indicado?**
- Donos e gestores de **quadras esportivas** (futebol, tênis, vôlei, entre outros)
- **Clubes e centros esportivos** que desejam centralizar o controle de reservas
- Desenvolvedores e equipes que buscam uma **API robusta e escalável** para integrar com aplicativos móveis ou sistemas web

## **Tecnologias Utilizadas**
- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.3** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **PostgreSQL** - Banco de dados
- **Maven** - Gerenciamento de dependências
- **Hibernate** - ORM

## **Arquitetura do Projeto**

O projeto segue uma arquitetura em camadas bem definida:

```
src/main/java/br/com/arenabook/arenabook/
├── core/                    # Camada de domínio
│   ├── config/             # Configurações
│   ├── enums/              # Enumerações
│   ├── exceptions/         # Exceções customizadas
│   ├── mappers/            # Mapeadores de dados
│   ├── models/             # Entidades do domínio
│   ├── repositories/       # Repositórios JPA
│   └── services/           # Serviços de negócio
└── web/                    # Camada de apresentação
    ├── business/           # Endpoints de estabelecimentos
    ├── court/              # Endpoints de quadras
    ├── reservation/        # Endpoints de reservas
    ├── tenant/             # Endpoints de inquilinos
    ├── user/               # Endpoints de usuários
    └── exceptions/         # Tratamento de exceções web
```

## **Entidades Principais**
- **User** - Usuários do sistema
- **Tenant** - Inquilinos/Organizações
- **Business** - Estabelecimentos esportivos
- **Court** - Quadras esportivas
- **Reservation** - Reservas
- **BusinessOperatingHours** - Horários de funcionamento

## **Endpoints da API**

A API oferece endpoints RESTful para:
- 👤 **Usuários** (`/users`) - Gerenciamento de usuários
- 🏢 **Estabelecimentos** (`/businesses`) - CRUD de estabelecimentos
- 🏟️ **Quadras** (`/courts`) - Gerenciamento de quadras
- 📅 **Reservas** (`/reservations`) - Sistema de reservas
- 🏛️ **Inquilinos** (`/tenants`) - Gerenciamento de organizações

## **Pré-requisitos**

- **Java 21** ou superior
- **Maven 3.6+**
- **PostgreSQL 12+**
- **Git**

## **Instalação e Configuração**

### 1. Clone o repositório
```bash
git clone <repository-url>
cd arenabook
```

### 2. Configure o banco de dados

Crie um banco PostgreSQL:
```sql
CREATE DATABASE arenabook;
CREATE USER arenabook WITH PASSWORD 'arenabook';
GRANT ALL PRIVILEGES ON DATABASE arenabook TO arenabook;
```

### 3. Configure as propriedades da aplicação

Edite o arquivo `src/main/resources/application.properties`:
```properties
# Datasource
spring.datasource.url=jdbc:postgresql://localhost:5432/arenabook
spring.datasource.username=arenabook
spring.datasource.password=arenabook

# Server
server.port=8080
```

### 4. Execute a aplicação

#### Usando Maven:
```bash
./mvnw spring-boot:run
```

#### Ou compile e execute:
```bash
./mvnw clean package
java -jar target/arenabook-0.0.1-SNAPSHOT.jar
```

A API estará disponível em: `http://localhost:8080`

## **Estrutura do Banco de Dados**

O projeto utiliza **Hibernate** com `ddl-auto=update` para criação automática das tabelas. As principais entidades são:

- `users` - Informações dos usuários
- `tenants` - Organizações/inquilinos
- `businesses` - Estabelecimentos esportivos
- `courts` - Quadras disponíveis
- `reservations` - Reservas realizadas
- `business_operating_hours` - Horários de funcionamento

## **Exemplos de Uso**

### Criar um usuário
```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@example.com",
    "password": "123456"
  }'
```

### Listar estabelecimentos
```bash
curl -X GET http://localhost:8080/businesses
```

### Criar uma reserva
```bash
curl -X POST http://localhost:8080/reservations \
  -H "Content-Type: application/json" \
  -d '{
    "courtId": 1,
    "userId": 1,
    "startTime": "2024-01-15T10:00:00",
    "endTime": "2024-01-15T11:00:00"
  }'
```

## **Desenvolvimento**

### Executar em modo de desenvolvimento
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

### Executar testes
```bash
./mvnw test
```

### Logs e Debug
O projeto está configurado para mostrar logs SQL em desenvolvimento:
```properties
spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
```

## **Contribuição**

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## **Licença**

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## **Suporte**

Para dúvidas, sugestões ou problemas:
- Abra uma [issue](../../issues)
- Entre em contato com a equipe de desenvolvimento

---
