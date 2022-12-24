# e-coreTest
This is a project to present the e-core test in assembling a service to handle role management in teams
# Approach
The main concern was to guarantee that the project would not break so the first step was to analyze how the /users and /teams services where related. <br>
<br>
After that there was done an H2 in memory implementation for DB, that was to be scraped with a docker container later on, but due to time constrains it was not possible.<br>
<br>
Once the Spring Boot Project was set up as well as the DB, I created a defaulter for all get request that came with out role or that were not already present in the db. After all the methods were implemented setting testing and validations that worked properly was the next goal.  
<br>
The solution properly reflects what it was requested. 

# Improvements

The biggest issue that can see with the current services is how is expected the new Roles service is going to interact with those, the info updated or created by the Roles services should be available in the lookup of /teams/{team-id} and not necessarily trough another consul 