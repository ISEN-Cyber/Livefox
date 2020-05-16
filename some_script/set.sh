diskutil eraseDisk FAT32 HYPRIOTOS MBRFormat /dev/disk2

sudo balena local flash /Users/antoine/Downloads/2020-02-13-raspbian-buster-full.img --drive /dev/disk2 --yes

sudo touch /Volumes/boot/ssh

diskutil unmountDisk /dev/disk2




