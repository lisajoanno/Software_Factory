#!/bin/bash

MVN_OPT='-q'

cd interceptors
mvn $MVN_OPT package
cd ..

echo -e '\n\n'

cd webservice
mvn $MVN_OPT package
cd ..

echo -e '\n\n'

cd client
mvn $MVN_OPT package
cd ..

echo -e '\n\n'

cd entities
mvn $MVN_OPT package
cd ..

echo -e '\n\n'

cd j2e
mvn $MVN_OPT package
cd ..

echo -e '\n\n'

cd utils
mvn $MVN_OPT package
cd ..

echo -e '\n\n'

cd exceptions
mvn $MVN_OPT package
cd ..

echo -e '\n\n'

## Building the .Net system
cd dotNet
./compile.sh
cd ..
