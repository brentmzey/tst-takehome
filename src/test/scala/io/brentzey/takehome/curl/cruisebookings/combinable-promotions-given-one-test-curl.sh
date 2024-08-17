#! /bin/bash

curl -X POST http://localhost:8080/api/combinable-promotions \
-H "Content-Type: application/json" \
-d '{
  "promotionCode": "P1",
  "allPromotions": [
    { "code": "P1", "notCombinableWith": ["P3"] },
    { "code": "P2", "notCombinableWith": ["P4", "P5"] },
    { "code": "P3", "notCombinableWith": ["P1"] },
    { "code": "P4", "notCombinableWith": ["P2"] },
    { "code": "P5", "notCombinableWith": ["P2"] }
  ]
}'

curl -X POST http://localhost:8080/api/combinable-promotions \
-H "Content-Type: application/json" \
-d '{
  "promotionCode": "P2",
  "allPromotions": [
    { "code": "P1", "notCombinableWith": ["P3"] },
    { "code": "P2", "notCombinableWith": ["P4", "P5"] },
    { "code": "P3", "notCombinableWith": ["P1"] },
    { "code": "P4", "notCombinableWith": ["P2"] },
    { "code": "P5", "notCombinableWith": ["P2"] }
  ]
}'