# ppj_cv4

Pokročilé programování na platformě        Java Cvičení 04

Úvod do Springu, XML konfigurace, Autowire a základní anotace

1.	Stáhněte si projekt z  https://github.com/ondrej-smola/ppj_cv4

2.	Neměňte žádné soubory a nakonfigurujte aplikační kontext Springu pomocí XML a bez využití funkce Autowire tak, aby se metoda Main úspěšně provedla.

3.	Modifikujte program tak, aby místo v XML definoval beany pomocí anotace @Component a využíval funkci Autowire. Jako parametr metody getBean používejte namísto názvu příslušnou třídu. Hlavičku XML rozšiřte o namespace

xmlns:context="http://www.springframework.org/schema/context"

a přidejte tag

<context:component-scan base-package="app.assignments"></context:component-scan>

TIP: Pokud v IDE zadáte <compo … nabídne Vám doplnění a přidá namespace do XML automaticky

