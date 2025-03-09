Úvod do Springu, konfigurace pomocí anotací a Java konfigurace

1.	Modifikujte projekt z minulého cvičení tak, že zcela odstraňte XML konfiguraci a nahraďte ji jednou konfigurační třídou. Konfigurační třída přitom může být přímo třída Main. Context vytvořte ze třídy Main pomocí

ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

2.	Odstraňte všechny anotace @Component a nahraďte je definicemi beanů pomocí anotace @Bean v dalších nově přidaných konfiguračních třídách. Dependency Injection ve třídě replyMessage proveďte pomocí anotace @Autowire nad příslušným atributem.

3.	Vyzkoušejte dále anotaci @PostConstruct a zkuste také vybrané Beany definovat s různým rozsahem platnosti (Scope).

4.	JUnit


