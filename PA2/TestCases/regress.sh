#!/bin/sh

# usage: 
#   ./regress.sh

for filename in `ls *.in`
do
    echo "Regression testing MJPA2.jar $filename"

    # run the input file with the MJPA2 compiler
    java -jar ../MJPA2.jar $filename >  t.txt 2>&1 

    diff t.txt $filename.OK
    echo "DONE with MJPA2.jar $filename"
    echo "============================="

done


