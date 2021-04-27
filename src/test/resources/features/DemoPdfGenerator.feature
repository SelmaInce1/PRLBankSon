Feature: Pdf generator

  @pdf
  Scenario Outline: read some customers data and create pdf
    Given User creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
    And  User provides the query "<query>" "20"

    Examples: demo read the data
      |query|
      |Select * from tp_customer|