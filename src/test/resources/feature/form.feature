#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Functional
Feature: Web form  

  @Create
  Scenario: Update Form
    Given I access home page
    When I click in select and change the version
    And I click in Add Customer
    And I fill out the fields with values
    |Teste Sicredi | Teste | Ivete | 519999-9999 | Av Assis Brasil, 3970 | Torre D | Porto Alegre | RS | 91000-000 | Brasil | Fixter | 200 | 
    And I click in save
    Then I verify the message confirmation 

  @SearchDelete
  Scenario: Search and Delete
    Given I access home page
    And I click in select and change the version
    And I click in Add Customer
    And I fill out the fields with values
    |Teste Sicredi | Teste | Ivete | 519999-9999 | Av Assis Brasil, 3970 | Torre D | Porto Alegre | RS | 91000-000 | Brasil | Fixter | 200 | 
    And I click in save
    When I Click on link Go back to list
    And I click in the icon and Search the Name "Teste Sicredi"
    And I click on checkbox Actions 
    And I click on delete button
    And i click on delete popup
    Then I verify the message confirmation delete