# ppj_cv6

Profily a defaultní konfigurace logování

1.	Vytvořte konfigurační třídu WriterConfiguration v namespace ppj.assignments.configs, která definuje bean implementující rozhraní ppj.assignments.writer.Writer  pomocí implementace DevelWriter pro profil devel a ProdWriter pro ostatní profily
2.	Nakofigurujte aktivní profil pomocí konfigurační proměnné spring.profiles.active v application.properties. Budeme používat dva profily: devel a prod.
3.	Vytvořte profilově závislé properties soubory (application-$(profile).properties) a v nich nadefinujte proměnnou app.desc (pro každý profil bude mít jinou hodnotu). Proč není v profilu debug provedeno zalogování příslušné hlášky?
4.	Zkuste i jiné způsoby nastavení aktivního profilu (argumenty při spuštění, systémové proměnné, programově – setAdditionalProfiles)
      Logback - detailní konfigurace

1.	Nakonfigurujte Logback pomoci logback-spring.xml
      a.	Nastavte logování (appender) do konzole s následujícím enkodérem
      <encoder>    <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern></encoder>
      b.	Kořenový logger na úroveň DEBUG – sledujte výstup Springu, poté jej nastavte na INFO
      c.	Pro namespace Springu nastavte úroveň na WARN
2.	Nastavte Logback tak, aby pro profil devel logoval namespace ppj od úrovně DEBUG a pro ostatní profily od úrovně INFO
3.	Nakonfigurujte Logback tak, aby zapisoval výstup kořenového loggeru i do souboru log.txt



odpoved pro otazku c3: 
## Proč není v profilu debug provedeno zalogování příslušné hlášky?

Debug logování se neprovede, pokud není v konfiguračním souboru (např. v application-debug.properties) nastavena úroveň logování na DEBUG pro příslušnou třídu nebo balíček. Pokud je úroveň logování nastavena na INFO či vyšší, volání `log.debug(...)` se nezobrazí. Taktéž se ujistěte, že je aktivní správný profil, například `spring.profiles.active=debug` nebo `devel` v závislosti na vaší implementaci.

## Jiné způsoby nastavení aktivního profilu

Kromě nastavení aktivního profilu v souboru `application.properties` existuje několik dalších způsobů, jak definovat aktivní profil:

1. **Argumenty při spuštění:**  
   Při spouštění aplikace můžete zadat profil přímo z příkazové řádky, například:
   ```bash
   java -jar app.jar --spring.profiles.active=prod
    ```
2.   **System Properties:**
```
export SPRING_PROFILES_ACTIVE=prod
```

3. **Programově:**
   Profily lze nastavit programově pomocí metody `setAdditionalProfiles` na třídě `SpringApplication`:
   ```java
         public static void main(String[] args) {
          SpringApplication app = new SpringApplication(Main.class);
          app.setAdditionalProfiles("prod"); // Přidá profil "prod"
          app.run(args);
      }
   ```
