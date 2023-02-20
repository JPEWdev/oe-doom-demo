# OpenEmbedded Doom Demo Repository

This repository builds the OpenEmbedded Doom Demo

## Quick Start

To try out this project in QEMU, run the following commands:

```
git submodules update --init --recursive
. init-build-env
bitbake core-image-doom
runqemu sdl gl-es kvm slirp
```

## Building

This repository uses submodules and a simple wrapper script to set the default
`TEMPLATECONF` that allows users to select the device they want to build. The
first step is to clone down the submodules:

```bash
git submodules update --init --recursive
```

Next, initialize the build environment, optionally specifying the build directory:

```bash
. init-build-env [BUILDDIR]
```

Finally, the images can be built with:

```
bitbake core-image-doom
```


To build for a different device, set the `BUILD_DEVICE` environment variable,
like so:

```
export BUILD_DEVICE=qemu
bitbake core-image-doom
```

For a list of all possible devices, see `meta-doom-demo/conf/devices`

## Adding new platforms

New platforms can be added by adding a new directory under
`meta-doom-demo/conf/devices`. This directory should contain 2 files:

`layers.conf`: This is the file that will be required in `bblayers.conf` when
the product is selected

`config.conf`: This is the file that will be required in `local.conf` when the
product is selected


## Why choose build configurations this way?

`TEMPLATECONF` is a great mechanism for initially populating build
configuration, but it has a few short comings that arise because it will only
write the files if they don't already exist. Because of this, it's not suitable
to _share_ device configuration because users won't automatically get the new
configuration for a build when they change revisions in the repository. The
solution to this problem is quite simple though: Instead of including the build
configuration directly in the template files, the template files instead
`require` a file that is checked into source control. By doing this, users will
automatically get the correct build configuration when changing revisions, but
can still override anything they want in their `local.conf`
