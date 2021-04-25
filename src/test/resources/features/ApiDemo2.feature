@demo2
Feature: ApiDemo2 Reading, Creating, Updating and Deleting Applicants
  Scenario: Reading Applicants
    Given Authorized user on the api endpoint “applicants_api” and read the applicants
    And Validate applicants read
  Scenario: Creating Applicants
    And create a applicant using to api end point “applicants_api”
    And Validate applicant create
  Scenario: Updating  Applicants
    And user updates a applicant using api end point “applicants_api”  “firstName” and its extension “id”
    And Validate applicant update
  Scenario: Deleting Applicants
    And user deletes a applicant using endpoint “applicants_api” and its extension “id”
    And Validate applicant delete

#  @demoJDBC
#  Scenario Outline: All users info should be retrieved by database and validated
#    Given User creates a connection with db using “gmibank_jdbc” , “techpro_username” and “techpro_pw”
#    And User retrieves the info of user from database using “<query>” and “<columnName>”
#    Then User validates users info “jdbc_email”
#    Examples:
#      |query|columnName|
#      |Select * From jhi_user|email|
#  @DemoPdf
#  Scenario Outline: Generate Datas to Pdf
#    Given User creates a connection with db using “gmibank_jdbc” , “techpro_username” and “techpro_pw”
#    And User provides the query “<query>” and generate it to PDF
#    Examples: Queries
#      |query|
#      |Select * from tp_customer|