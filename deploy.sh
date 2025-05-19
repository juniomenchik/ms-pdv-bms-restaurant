#!/bin/bash

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

run_command() {
    echo -e "${YELLOW}[$1/8] $2...${NC}"
    if mvn $3; then
        echo -e "${GREEN}Success${NC}"
    else
        echo -e "${RED}FAILED! Stopping validation.${NC}"
        exit 1
    fi
    echo
}

echo "Digite 'up' para fazer deploy completo, 'down' para deletar os recursos, 'update' para aplicar apenas os recursos Kubernetes, ou 'restart' para reiniciar o deploy (down + up):"
read -r acao

case "$acao" in
  up)
    echo -e "${YELLOW}#############################################${NC}"
    echo -e "${YELLOW}# Validating project integrity with Maven #${NC}"
    echo -e "${YELLOW}#############################################${NC}"
    echo

    # 1. Clean project
    run_command 1 "Cleaning project" "clean"

    # 2. Resolve dependencies
    run_command 2 "Resolving dependencies" "dependency:resolve"

    # 3. Validate POM
    run_command 3 "Validating POM" "validate"

    # 4. Compile source code
    run_command 4 "Compiling source code" "compile"

    # 5. Run unit tests
    run_command 5 "Running unit tests" "test"

    # 6. Package project
    run_command 6 "Packaging project" "package"

    # 7. Analyze dependencies
    run_command 7 "Analyzing dependencies" "dependency:analyze"

    # 8. Check for dependency updates
    run_command 8 "Checking for dependency updates" "versions:display-dependency-updates"

    echo

    # Docker commands
    echo -e "${YELLOW}Running Docker commands...${NC}"

    echo -e "${YELLOW}Removing existing MS-PDV-BMS-RESTAURANT container...${NC}"
    docker container rm ms-pdv-bms-restaurant || true

    echo -e "${YELLOW}Building project without tests...${NC}"
    mvn clean package -DskipTests

    echo -e "${YELLOW}Building Docker image...${NC}"
    docker build -t ms-pdv-bms-restaurant:0.0.1 .

    #echo -e "${YELLOW}Tagging Docker image...${NC}"
    docker tag ms-pdv-bms-restaurant:0.0.1 juniomenchik/ms-pdv-bms-restaurant:0.0.1

    #echo -e "${YELLOW}Pushing Docker image...${NC}"
    docker push juniomenchik/ms-pdv-bms-restaurant:0.0.1 # if you want to push the image to a registry

    echo -e "${GREEN}#############################################${NC}"
    echo -e "${GREEN}# Project Validated and Deployed successfully #${NC}"
    echo -e "${GREEN}#############################################${NC}"

    echo "Aplicando recursos Kubernetes..."
    kubectl apply -f k8s/mysql-secret.yaml
    kubectl apply -f k8s/mysql-pv-pvc.yaml
    kubectl apply -f k8s/mysql-deployment.yaml
    kubectl apply -f k8s/mysql-service.yaml
    kubectl apply -f k8s/restaurant-pvc.yaml
    kubectl apply -f k8s/restaurant-deployment.yaml
    kubectl apply -f k8s/restaurant-service.yaml
    kubectl apply -f k8s/global-ingress.yaml
    echo "✔ Deploy concluído com sucesso."
    ;;
  update)
    echo -e "${YELLOW}Aplicando apenas recursos Kubernetes...${NC}"
    kubectl apply -f k8s/mysql-secret.yaml
    kubectl apply -f k8s/mysql-pv-pvc.yaml
    kubectl apply -f k8s/mysql-deployment.yaml
    kubectl apply -f k8s/mysql-service.yaml
    kubectl apply -f k8s/restaurant-pvc.yaml
    kubectl apply -f k8s/restaurant-deployment.yaml
    kubectl apply -f k8s/restaurant-service.yaml
    kubectl apply -f k8s/global-ingress.yaml
    echo -e "${GREEN}✔ Recursos Kubernetes aplicados com sucesso.${NC}"
    ;;
  down)
    echo "Deletando recursos Kubernetes..."
    kubectl delete -f k8s/global-ingress.yaml
    kubectl delete -f k8s/restaurant-pvc.yaml
    kubectl delete -f k8s/restaurant-service.yaml
    kubectl delete -f k8s/restaurant-deployment.yaml
    kubectl delete -f k8s/mysql-service.yaml
    kubectl delete -f k8s/mysql-deployment.yaml
    kubectl delete -f k8s/mysql-pv-pvc.yaml
    kubectl delete -f k8s/mysql-secret.yaml
    echo "✔ Recursos deletados com sucesso."
    ;;
  restart)
    echo -e "${YELLOW}Executando 'down' para deletar recursos...${NC}"
    kubectl delete -f k8s/global-ingress.yaml
    kubectl delete -f k8s/restaurant-pvc.yaml
    kubectl delete -f k8s/restaurant-service.yaml
    kubectl delete -f k8s/restaurant-deployment.yaml
    kubectl delete -f k8s/mysql-service.yaml
    kubectl delete -f k8s/mysql-deployment.yaml
    kubectl delete -f k8s/mysql-pv-pvc.yaml
    kubectl delete -f k8s/mysql-secret.yaml
    echo -e "${GREEN}✔ Recursos deletados com sucesso.${NC}"

    echo -e "${YELLOW}Executando 'up' para deploy completo...${NC}"

    # Chamar o bloco do 'up' via função para evitar duplicação? Para simplicidade, podemos chamar o próprio script:
    # Você pode fazer um "source" do script ou replicar o código aqui; aqui vou replicar chamando o script com "up" diretamente.

    # Para evitar recursão, melhor replicar o código do 'up' aqui.

    # 1. Clean project
    run_command 1 "Cleaning project" "clean"

    # 2. Resolve dependencies
    run_command 2 "Resolving dependencies" "dependency:resolve"

    # 3. Validate POM
    run_command 3 "Validating POM" "validate"

    # 4. Compile source code
    run_command 4 "Compiling source code" "compile"

    # 5. Run unit tests
    run_command 5 "Running unit tests" "test"

    # 6. Package project
    run_command 6 "Packaging project" "package"

    # 7. Analyze dependencies
    run_command 7 "Analyzing dependencies" "dependency:analyze"

    # 8. Check for dependency updates
    run_command 8 "Checking for dependency updates" "versions:display-dependency-updates"

    echo

    echo -e "${YELLOW}Running Docker commands...${NC}"

    echo -e "${YELLOW}Removing existing MS-PDV-BMS-RESTAURANT container...${NC}"
    docker container rm ms-pdv-bms-restaurant || true

    echo -e "${YELLOW}Building project without tests...${NC}"
    mvn clean package -DskipTests

    echo -e "${YELLOW}Building Docker image...${NC}"
    docker build -t ms-pdv-bms-restaurant:0.0.1 .

    #echo -e "${YELLOW}Tagging Docker image...${NC}"
    docker tag ms-pdv-bms-restaurant:0.0.1 juniomenchik/ms-pdv-bms-restaurant:0.0.1

    #echo -e "${YELLOW}Pushing Docker image...${NC}"
    docker push juniomenchik/ms-pdv-bms-restaurant:0.0.1

    echo -e "${GREEN}#############################################${NC}"
    echo -e "${GREEN}# Project Validated and Deployed successfully #${NC}"
    echo -e "${GREEN}#############################################${NC}"

    echo "Aplicando recursos Kubernetes..."
    kubectl apply -f k8s/mysql-secret.yaml
    kubectl apply -f k8s/mysql-pv-pvc.yaml
    kubectl apply -f k8s/mysql-deployment.yaml
    kubectl apply -f k8s/mysql-service.yaml
    kubectl apply -f k8s/restaurant-pvc.yaml
    kubectl apply -f k8s/restaurant-deployment.yaml
    kubectl apply -f k8s/restaurant-service.yaml
    kubectl apply -f k8s/global-ingress.yaml
    echo "✔ Deploy concluído com sucesso."
    ;;
  *)
    echo "⚠ Comando inválido. Use 'up', 'down', 'update' ou 'restart'."
    ;;
esac
