SUMMARY = "OpenEmbedded Doom Launcher"
HOMEPAGE = "https://github.com/JPEWdev/oe-doom-launcher"
LICENSE = "MIT"
SECTION = "games"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ca1afe7e49b8188eae3446b0898b6834"
DEPENDS = "\
    avahi \
    glib-2.0 \
    libbsd \
    systemd \
    "

SRC_URI = "\
    git://github.com/JPEWdev/oe-doom-launcher.git;protocol=https;branch=${BRANCH} \
    file://oe-doom-launcher.service \
    file://config.ini \
    "
BRANCH = "main"
SRCREV = "699de379b65d2a076568ecc806154e7f492da2f9"

S = "${WORKDIR}/git"

inherit meson pkgconfig systemd features_check

REQUIRED_DISTRO_FEATURES = "systemd wayland"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 644 ${WORKDIR}/oe-doom-launcher.service ${D}${systemd_system_unitdir}/

    install -d ${D}${sysconfdir}/oe-doom/
    install -m 644 ${WORKDIR}/config.ini ${D}${sysconfdir}/oe-doom/
}

RDEPENDS:${PN} += "weston-init zdoom zdoom-autolaunch"
SYSTEMD_SERVICE:${PN} = "oe-doom-launcher.service"
