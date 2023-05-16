#!/bin/sh
echo "Starting core API"
export AUTHABLE_DB_IP="127.0.0.1"
export AUTHABLE_DB_PORT="3306"
export AUTHABLE_DB_USERNAME="root"
export AUTHABLE_DB_PASSWORD="admin_password"
export AUTHABLE_JWT_SECRET="ThisIsSecretForJWTHS512SignatureAlgorithmThatMUSTHave64ByteLength"
export AUTHABLE_SYSTEM_SECRET="SYSTEM_SECRET"
export AUTHABLE_USERNAME_SECRET="USERNAME_SECRET"
export AUTHABLE_TOTP_SECRET="1234567890123456"

java -jar orchestration/target/authable-0.0.1-SNAPSHOT-fat.jar
