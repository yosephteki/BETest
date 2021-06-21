#! /bin/bash

# Decalre 2 var to contain requested menu and name of the inventory list
REQUEST=$2
# concat second and third input parameter on command line
REQUEST+=" "$3
FILETOOPEN=$1

# Declare 4 variables
# 1. CAPPLE : to contain count value of apple
# 2. CPINE : to contain count value of pineapple
# 3. APPLETEXT : contain value for matching with apple, word
# 4. PINETEXT : contain value for matching with pineapple, word
CAPPLE=0
CPINE=0
LINE=1
APPLETEXT="apple,"
PINETEXT="pineapple,"

# scanning all line inside the file using while statement
# and store current value as CURRENT_LINE
while read -r CURRENT_LINE
do
# set system to ignore uppercase or lowecase
shopt -s nocasematch
# match current scanned value from line with each case
# then add +1 each value on matched case
case "$CURRENT_LINE" in
 "$APPLETEXT" ) ((CAPPLE++));;
 "$PINETEXT" ) ((CPINE++));;
*) ;;
esac

# reset system to not ignore upper or lower case
shopt -u nocasematch
# increment scanning line to jump to next line
((LINE++))
# set to open file to scan
done < "./$FILETOOPEN"

# set system to ignore upper or lower case 
shopt -s nocasematch
# matching each requested menu by user using case statement
case $REQUEST in
"APPLE PIE" ) 
# set condition if value of apple count is equal or greater than 3
if [ $CAPPLE -ge 3  ]
then
echo "You shall have an APPLE PIE"
else
echo "You shall NOT have an APPLE PIE "
fi
;;
"PINEAPPLE PIE")
# set condition if value of pineapple count is equal or greater than 3
if [ $CPINE -ge 3 ]
then
echo "You shall have a PINEAPPLE PIE"
else
echo "You shall not have a PINEAPPLE PIE"
fi
;;
"FRUIT PARFAIT")
# set condition if value of pineapple count is equal or greater than 2
# and apple count is equal or greater than 2
if [$CPINE -ge 2 -a $CAPPLE -ge 2]
then
echo "You shall have a FRUIT PARFAIT"
else
echo "You shall not have a FRUIT PARFAIT"
fi
;;
#case if no match case for user requested menu
*) echo "We do not have that on the menu";;
esac
# reset system to not ignore lower or uppercase
shopt -u nocasematch
