diskutil eraseDisk FAT32 HYPRIOTOS MBRFormat /dev/disk2

sudo balena local flash /Users/bastienbosser/Downloads/hypriotos-rpi-v1.12.0.img --drive /dev/disk2 --yes

sudo touch /Volumes/boot/ssh

diskutil unmountDisk /dev/disk2
