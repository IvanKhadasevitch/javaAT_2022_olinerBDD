Feature: As a user I want to get ability to use Автобарахолка menu sections

  @smoke
  Scenario Outline: Автобарахолка menu item should contains appropriate sections
    Given the user opens Onliner website
    When the user hover over the <item> menu item
    Then menu item has "ab" submenu with <section> section
    And menu item has "ab" submenu with <section1> section
    And menu item has "ab" submenu with <section2> section
    And menu item has "ab" submenu with <section3> section
    And menu item has "ab" submenu with <section4> section
    And menu item has "ab" submenu with <section5> section
    And menu item has "ab" submenu with <section6> section
    And menu item has "ab" submenu with <section7> section
    And menu item has "ab" submenu with <section8> section
    And menu item has "ab" submenu with <section9> section
    And menu item has "ab" submenu with <section10> section
    And menu item has "ab" submenu with <section11> section
    And menu item has "ab" submenu with <section12> section
    And menu item has "ab" submenu with <section13> section
    Examples:
      | item            | section | section1 | section2 | section3 | section4  | section5 | section6 | section7        | section8 | section9 | section10 | section11 | section12 | section13    |
      | "Автобарахолка" | "price" | "city"   | "audi"   | "bmw"    | "citroen" | "ford"   | "mazda"  | "mercedes-benz" | "nissan" | "opel"   | "peugeot" | "renault" | "toyota"  | "volkswagen" |