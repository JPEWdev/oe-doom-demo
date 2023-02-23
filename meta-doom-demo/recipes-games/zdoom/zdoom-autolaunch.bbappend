FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:doom-demo = " \
    file://common.ini \
    file://gamepad.ini \
    "

do_install:append:doom-demo() {
    cat ${WORKDIR}/common.ini ${WORKDIR}/gamepad.ini >> ${D}${sysconfdir}/zdoom/zdoom.ini
}
