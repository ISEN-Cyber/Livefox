#!/bin/bash

ffmpeg -i $1 -s 640x360 -b:v 750k -c:v libx264 -g 90 -an "$2_640x360_750k.mp4"
        
ffmpeg -i $1 -s 640x360 -b:v 1000k -c:v libx264 -g 90 -an "$2_640x360_1000k.mp4"

/bin/bash /encoding3.sh $1 $2 $3 