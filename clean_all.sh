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

## Building the .Net system
cd dotNet
./compile.sh
cd ..
