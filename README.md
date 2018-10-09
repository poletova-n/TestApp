How to test:
Authorization:
curl -v https://api.testpay.com/oauth2/token \
-H "Accept: application/json" \
-H "Accept-Language: en_US" \
-u "<client_id>:<secret>" \
-d "grant_type=client_credentials"
  
Payment:
curl -v https://api.testpay.com/payments/payment \
-H "Content-Type: application/json" \
-H "Authorization: Bearer <Access-Token>" \
-d '{
"intent": "order",
"notification_url": "https://example.com/your_notification_url",
"payer": {
"email": "test@example.com"
},
"transaction": {
"external_id": “123456789”
"amount": {
"value": "7.47",
"currency": "USD"
},
"description": “The payment transaction description”
}
}'
