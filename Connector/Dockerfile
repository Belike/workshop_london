docker run --rm --name=CustomConnectorInSaaS \
    -v $PWD/target/connector-happyrest-0.1.0-SNAPSHOT-with-dependencies.jar:/opt/app/connector.jar \
    -e ZEEBE_CLIENT_SECURITY_PLAINTEXT=false \
    -e ZEEBE_CLIENT_CLOUD_CLUSTER-ID='0f2dbc0e-3292-4dde-a7ab-43a4ac8f57b7' \
    -e ZEEBE_CLIENT_CLOUD_CLIENT-ID='CSgIPOxzd-VBixogFGL7Z-lOOTXWTl74' \
    -e ZEEBE_CLIENT_CLOUD_CLIENT-SECRET='~KrBUyZb9pobtOgVGPZLeY0tRdRgGv1n352.._8OAVJH_5~9RZJn.sZvVVwPwUCK' \
    -e ZEEBE_CLIENT_CLOUD_REGION='bru-2' \
    -e CAMUNDA_OPERATE_CLIENT_URL='https://bru-2.operate.camunda.io/0f2dbc0e-3292-4dde-a7ab-43a4ac8f57b7' \
        camunda/connectors-bundle:8.3.0