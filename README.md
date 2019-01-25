# Test-task
Test task

# API
## Create a voting with options
POST /voting/create

Body
{
  "name" : `<voting name>`,
  "optionNames" : `<array of option names>`
}

## Update voting status to "opened" and get the voting link
POST /voting/`<voting id>`/status/opened

## Update voting status to "completed"
POST /voting/`<voting id>`/status/completed

## Vote 
PUT /option/`<option id>`/vote

## Get information about voting: id, name, status, options, the number of votes
GET /voting/`<voting id>`

## Get information about a specific option: name, the number of votes
GET /option/`<option id>`/stats

# Mysql
Before running application you should create a database. 
This properties you can find in application.properties file.

1. spring.datasource.url - url to db with timezone. The default is `jdbc:mysql://localhost/appVoting_db?serverTimezone=UTC`
2. spring.datasource.username - db username. The default value `root`
3. spring.datasource.password - db username password. The default value `password` 
