@allTramites
Feature: AutoWeb

  @Automated @Happy_path @functional_testing @PrimerEjercicio
  Scenario Outline: [HAPPY PATH] Flujo E2E Prueba Baufest
    Given que el usuario accede a la aplicacion DemoBlaze
    When se registra con usuario <user> y contrasena <password>
    And realiza la actividad login y logut con el nuevo usuario
    And inicia sesion con usuario <user> y contrasena <password>
    And agrega el articulo <articulo>
    Then valida que se haya agregado al carrito
    Examples:
      | user         | password | articulo |
      | RDDDASWs12dsa | hola123  | LAPTOP   |
#      | DASDSACc2312ds    | hola1234 | PHONES   |
#      | feasdsadds       | hola1234 | MONITORS |