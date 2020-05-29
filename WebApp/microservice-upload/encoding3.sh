#!/bin/bash
   

ffmpeg -i $1 -s 1280x720 -b:v 1500k -c:v libx264 -g 90 -an "$2_1280x720_1500k.mp4"

MP4Box -dash 5000 -rap -profile dashavc264:onDemand -mpd-title BBB -out $2.mpd -frag 2000 $2_128k.mp4 $2_160x90_250k.mp4 $2_320x180_500k.mp4 $2_640x360_750k.mp4 $2_640x360_1000k.mp4 $2_1280x720_1500k.mp4