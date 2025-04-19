#!/bin/bash

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${YELLOW}#############################################${NC}"
echo -e "${YELLOW}# Validating project integrity with Maven #${NC}"
echo -e "${YELLOW}#############################################${NC}"
echo

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

# # 9. Run OWASP dependency check (optional)
# echo -e "${YELLOW}[9/9] Checking for vulnerabilities (OWASP)...${NC}"
# mvn org.owasp:dependency-check-maven:check
echo

echo -e "${GREEN}#############################################${NC}"
echo -e "${GREEN}# Project validation completed successfully #${NC}"
echo -e "${GREEN}#############################################${NC}"