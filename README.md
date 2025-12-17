\# 🏟️ Placar em Tempo Real



Sistema web para gerenciamento e exibição de partidas esportivas com \*\*atualização em tempo real\*\*, utilizando \*\*Jakarta EE\*\*, \*\*JAX-RS\*\*, \*\*JPA\*\*, \*\*Wicket\*\*, \*\*RabbitMQ\*\* e \*\*Redis\*\*.



---



\## 🚀 Tecnologias Utilizadas



\### Backend

\- Java 17

\- Jakarta EE 10

\- JAX-RS (Jersey)

\- JPA (Hibernate)

\- EJB / CDI

\- GlassFish 7.1

\- Maven (WAR)



\### Mensageria / Tempo Real

\- RabbitMQ (eventos de domínio)

\- Redis (Pub/Sub)

\- SSE (Server-Sent Events)



\### Frontend

\- Apache Wicket 10

\- HTML + CSS + JavaScript

\- Atualização em tempo real via SSE



---



\## ⚙️ Pré-requisitos



\- Java 17+

\- Maven 3.8+

\- GlassFish 7.1

\- RabbitMQ

\- Redis

\- Banco de dados configurado no GlassFish



---



\## 🗄️ Configuração do Banco de Dados



No \*\*GlassFish Admin Console\*\*:



1\. Crie o JDBC Connection Pool

2\. Crie o JDBC Resource:



-----



No `persistence.xml`:



```xml

<persistence-unit name="placarPU" transaction-type="JTA">

&nbsp;   <jta-data-source>jdbc/placarDS</jta-data-source>

</persistence-unit>



------



Build e Deploy

mvn clean package





O WAR será gerado em:



target/placar-backend.war





Deploy no GlassFish:



asadmin deploy target/placar-backend.war





Acessos da Aplicação

API REST

http://localhost:8080/placar-backend/api/jogos



Interface Web (Wicket)

http://localhost:8080/placar-backend/wicket/



SWAGGER



http://localhost:8080/placar-backend/swagger-ui



