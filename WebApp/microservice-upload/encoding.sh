#!/bin/bash

mkdir -p /livefox/enc
mkdir -p /livefox/img

ffmpeg -i $1 -vcodec mjpeg -vframes 1 -an -f rawvideo -s 1920x1080 -ss 10 $3
        
ffmpeg -i $1 -c:a aac -b:a 128k -vn "$2_128k.mp4"
        
ffmpeg -i $1 -s 160x90 -b:v 250k -c:v libx264 -g 90 -an "$2_160x90_250k.mp4"
        
ffmpeg -i $1 -s 320x180 -b:v 500k -c:v libx264 -g 90 -an "$2_320x180_500k.mp4"
        
/bin/bash /encoding2.sh $1 $2 $3 
