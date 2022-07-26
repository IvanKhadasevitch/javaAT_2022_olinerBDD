Feature: As a user I want to get ability to use Дома и квартиры menu sections

  @smoke
  Scenario: Дома и квартиры menu item should contains appropriate sections
    Given the user opens Onliner website
    When the user hover over the "Дома и квартиры" menu item
    Then menu item has "r" submenu with "bounds" section
    And menu item has "r" submenu with "number_of_rooms" section
    And menu item has "r" submenu with "price" section