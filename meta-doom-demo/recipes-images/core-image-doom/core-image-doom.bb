SUMMARY = "Doom On Wayland"

IMAGE_FEATURES += "splash ssh-server-dropbear hwcodecs ptest-pkgs"

LICENSE = "MIT"

inherit core-image features_check

REQUIRED_DISTRO_FEATURES = "wayland"

DOOM_GAME ?= "\
    chexquest-galactic-conflict \
    freedoom-1 \
    freedoom-2 \
    freedm \
    "

CORE_IMAGE_BASE_INSTALL += "\
    kernel-modules \
    oe-doom-launcher \
    weston \
    weston-init \
    avahi-daemon \
    ${DOOM_GAME} \
    "
