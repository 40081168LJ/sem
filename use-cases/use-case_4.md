# Use Case 4 - Produce a report of the top (N) populated cities in an area - (N) provided by user

## Goal in Context
I want to produce a report of the top (N) populated cities in an area - (N) provided by user.

## Scope
Organisation

## Level
Primary Task

## Preconditions
We know the area required for the report i.e. the world/a continent/a region/a country/a district. <br>
We know the number of cities required for the report. <br>
The database contains the current city data i.e. name, country, district, population.

## Success End Condition
A report is available for the organisation.

## Failed End Condition
No report produced.

## Primary Actor
Organisation employee

## Trigger
A request from the organisation for the above report.

## Main Success Scenario
1. Organisation requests a report of the top (N) cities in an area. <br>
2. Employee captures the number of cities required for the report.
3. Employee captures the area the report is required for i.e. the world/a certain continent/a certain region/
certain country/a certain district. <br>
4. Employee extracts the current city information as required for the given area, arranged as requested <br>
5. Employee provides report to the organisation.

## Extensions
2. Number of cities not provided.
    * Employee informs organisation that they need to provide the number of cities they would like the
      report to provide information on.
3. Area provided not appropriate for a city report.<br>
    * Employee informs organisation that the area used for the report must be either the world/a continent/a region/a 
   country/a district.

## Sub-variations
None

## Schedule
Due Date : 11/04/2023