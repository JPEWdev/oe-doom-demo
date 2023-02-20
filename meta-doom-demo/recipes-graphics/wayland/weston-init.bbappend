FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:doom-demo = " file://10-start-on-demand.conf"

do_install:append:doom-demo() {
    install -Dm 644 ${WORKDIR}/10-start-on-demand.conf \
        ${D}${systemd_unitdir}/system/weston.service.d/10-start-on-demand.conf
}

FILES:${PN}:append:doom-demo = " ${systemd_unitdir}/system/weston.service.d/10-start-on-demand.conf"
