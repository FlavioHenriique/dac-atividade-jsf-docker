FROM payara/server-full

COPY target/dac-atividade-jsf-docker.war $DEPLOY_DIR
