#!/bin/sh

if [ $# -ne 1 ]; then
	echo "You must supply a filename."
	exit 1;
fi

if [ ! -e "$1" ]; then
	echo "The specified file does not exist."
	exit 2;
fi

sed -e 's/\s\+/\n/g' "$1" | sort | uniq -c