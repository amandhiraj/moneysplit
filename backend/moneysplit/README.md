# Setup

1) Download docker
2) open project and build
3) open docker-compose.yaml and run the file or alternatively use this command in the root folder of backend/moneysplit
```cmd
docker compose -f docker-compose.yaml -p moneysplit up -d
```
4) Use `localhost:8080` for responses
5) `Optionals` : Uncomment the function in MoneysplitApplication to populate the database
# MongoDB

Use `localhost:8081` to open up mongodb UI interface


# API
`note this info will only show if there is data in the DB (see line 5)`

All traffic is routed to `api/v1`

`/users` - gets users list
`/expenses` - gets expenses


