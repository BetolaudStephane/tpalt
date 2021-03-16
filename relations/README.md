# Relationnal microservice #

Port: 3000

## Make migrations ##
yarn migrate |

## Start server ##
yarn start |

## Test with curl ##
*Example*
curl -X POST -H "Content-Type: application/json" -d @users_interests.json http://localhost:3000/users-interest