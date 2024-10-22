### Para Habilitar Modulo de administração.
* Incluir dependência no pom.xml
```xml
<dependency>
    <groupId>br.ueg.progweb2</groupId>
    <artifactId>arquitetura-prog-web-ii-adminmodule</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```
* remover o arquivo br/ueg/progweb2/arqexemplo/service/impl/UserProviderService.java
* incluir a propriedade abaixo no application.properties
```
app.api.security.auth.url-reset-password=http://localhost:4200/acesso/alterar-senha/
```
* `Opcional`: Incluir o serviço de incialização (br/ueg/progweb2/arqexemplo/service/AppStartupRunner.java) a chamada ao serviço  
this.securityInitializeService.initialize()
* **configurar messagem**: alterar a propriedade `spring.message.basename` para incluir `messages-moduleadmin` no application.properties  
```spring.messages.basename=messages,messages-arquitetura,messages-moduleadmin```

### Configuração de Segurança nos Controller
* Classes de controller devem criar uma constante do tipo ISecurityRole para cada role que for suportar. A constante deve ser um enum que implemente a interface ISecurityRole conforme exemplo da própria arquitetura `ModuleAdminSecurityRole`  
```public static ISecurityRole ROLE_SEARCH = ModuleAdminSecurityRole.SEARCH;```
* Cada método que for ser segurado por uma role deve ser anotada conforme exemplo: `@PreAuthorize("hasRole(#root.this.getRoleName(#root.this.ROLE_SEARCH))")`