#! /bin/bash

curl -X POST http://localhost:8080/api/rate-calculator \
-H "Content-Type: application/json" \
-d '{
  "rates": [
    { "rateCode": "M1", "rateGroup": "Military" },
    { "rateCode": "M2", "rateGroup": "Military" },
    { "rateCode": "S1", "rateGroup": "Senior" },
    { "rateCode": "S2", "rateGroup": "Senior" }
  ],
  "cabinPrices": [
    { "cabinCode": "CA", "rateCode": "M1", "price": 200.00 },
    { "cabinCode": "CA", "rateCode": "M2", "price": 250.00 },
    { "cabinCode": "CA", "rateCode": "S1", "price": 225.00 },
    { "cabinCode": "CA", "rateCode": "S2", "price": 260.00 },
    { "cabinCode": "CB", "rateCode": "M1", "price": 230.00 },
    { "cabinCode": "CB", "rateCode": "M2", "price": 260.00 },
    { "cabinCode": "CB", "rateCode": "S1", "price": 245.00 },
    { "cabinCode": "CB", "rateCode": "S2", "price": 270.00 }
  ]
}'