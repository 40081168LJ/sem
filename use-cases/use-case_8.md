# Use Case 8 - Produce a report with the total population of an area

## Goal in Context
I want to produce a report with the total population of an area.

## Scope
Organisation

## Level
Primary Task

## Preconditions
We know the area required for the report i.e. the world/a continent/a region/a country/a district/a city. <br>
The database contains the current country and city data i.e. name, population.

## Success End Condition
A report is available for the organisation.

## Failed End Condition
No report produced.

## Primary Actor
Organisation employee

## Trigger
A request from the organisation for the above report.

## Main Success Scenario
1. Organisation requests a report with the total population of an area. <br>
2. Employee captures the area the report is required for i.e. the world/a certain continent/a certain region/a
   certain country/a certain district/a certain city. <br>
3. Employee extracts the current country/city information as required for the given area, arranged as requested <br>
4. Employee provides report to the organisation.

## Extensions
2. Area provided not appropriate for a population report <br>
    * Employee informs organisation that the area used for the report must be either the world/a continent/a region/a
      country/a district/a city.

## Sub-variations
None

## Schedule
Due Date : 11/04/2023