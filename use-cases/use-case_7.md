# Use Case 7 - product a report of the total population, population living in cities and population not living in cities in an area

## Goal in Context
I want to product a report of the total population, population living in cities and population not living in cities 
in an area.

## Scope
Organisation

## Level
Primary Task

## Preconditions
We know the area required for the report i.e. the world/a continent/a region. <br>
The database contains the current country and city data i.e. code, name, continent, region, population, capital.

## Success End Condition
A report is available for the organisation.

## Failed End Condition
No report produced.

## Primary Actor
Organisation employee

## Trigger
A request from the organisation for the above report.

## Main Success Scenario
1. Organisation requests a report of the total population, population living in cities and population not living in cities
   in an area. <br>
2. Employee captures the area the report is required for i.e. the world/a certain continent/a certain region. <br>
3. Employee extracts the current country and city information as required for the given area, arranged as requested <br>
4. Employee provides report to the organisation.

## Extensions
2. Area provided not appropriate for a population report i.e. in a district.<br>
    * Employee informs organisation that the area used for the report must be either the world/a continent/a region.

## Sub-variations
None

## Schedule
Due Date : 11/04/2023