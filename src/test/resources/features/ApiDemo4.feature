
@CreateUpdateAndDelete
  Feature: Apidemo4
Scenario: Create a country with api and validate it from UI, Update a country with api and validate it from UI and Delete a country with api and validate it from UI
And user create a country with countries api end point "team43_country"
Then login to employee account "emplUsername" and "emplPaswd"
And employee navigate create or edit customer page
And employee can validate new country created "team43_country"
Then login out from employee account
And user update created country using api end point "team43_countryUpdated"
Then login to employee account "emplUsername" and "emplPaswd"
And employee navigate create or edit customer page
And employee can validate new country updated "team43_countryUpdated"
Then login out from employee account
And user delete created country using api end point "countriesEndPoint"
Then login to employee account "emplUsername" and "emplPaswd"
And employee navigate create or edit customer page
And employee can not select new country deleted "team43_countryUpdated"