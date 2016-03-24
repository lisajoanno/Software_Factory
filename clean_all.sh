#!/bin/bash

MVN_OPT='-q'

cd interceptors
mvn $MVN_OPT clean
cd ..

cd webservice
mvn $MVN_OPT clean
cd ..

cd client
mvn $MVN_OPT clean
cd ..

cd entities
mvn $MVN_OPT clean
cd ..

cd j2e
mvn $MVN_OPT clean
cd ..

cd utils
mvn $MVN_OPT clean
cd ..

cd exceptions
mvn $MVN_OPT clean
cd ..


#~ RED='\033[0;31m'
#~ NC='\033[0m' # No Color
#~ printf "I ${RED}love${NC} Stack Overflow\n"
