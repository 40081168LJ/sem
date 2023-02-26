# Use Case 2 - produce a report of the top (N) populated countries in an area - (N) provided by user

## Goal in Context
I want to produce a report of the top (N) populated countries in an area - (N) provided by user.

## Scope
Organisation

## Level
Primary Task

## Preconditions
We know the area required for the report i.e. the world/a continent/a region. <br>
We know the number of countries required for the report. <br>
The database contains the current country data i.e. code, name, continent, region, population, capital.

## Success End Condition
A report is available for the organisation.

## Failed End Condition
No report produced.

## Primary Actor
Organisation employee

## Trigger
A request from the organisation for the above report.

## Main Success Scenario
1. Organisation requests a report of the top (N) countries in an area. <br>
2. Employee captures the number of countries required for the report.
3. Employee captures the area the report is required for i.e. the world/a certain continent/a certain region. <br>
3. Employee extracts the current country information as required for the given area, arranged as requested <br>
4. Employee provides report to the organisation.

## Extensions
2. Number of countries not provided.
    * Employee informs organisation that they need to provide the number of countries they would like the 
   report to provide information on.
3. Area provided not appropriate for a country report i.e. in a district.<br>
    * Employee informs organisation that the area used for the report must be either the world/a continent/a region.

## Sub-variations
None

## Schedule
Due Date : 11/04/2023