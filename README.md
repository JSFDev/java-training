# Training Java practices

- [Install JDK 8u91 (packages and resources) including JRE (virtual machine, sandbox to compile code)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- Update user or system environment variables
```bash
# /etc/environment
# ~/.bashrc
JAVA_8=/usr/jdk/jdk1.8.0_91
export JAVA_HOME=$JAVA_8
export PATH="$PATH:$JAVA_HOME/bin"
# $source /etc/environment
```