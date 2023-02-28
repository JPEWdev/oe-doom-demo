FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Ensure USB Joystick drivers are installed
SRC_URI:append:doom-demo = " file://gamepad-input.cfg"
