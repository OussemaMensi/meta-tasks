SUMMARY = "Task Demo"
DESCRIPTION = "Recipes for tasks manipulation in yocto"
LICENSE = "CLOSED"

# Uncomment the line below to observe the effect of [depends].
# do_taskExample[depends] = "task-example-deps:do_taskExampleDeps"


# Uncomment the 2 lines below to observe the effect of [deptask].
# DEPENDS = "task-example-deps"
# do_taskExample[deptask] = "do_compile"

# Uncomment the lines below to observe the effect of [dirs].
# add this "bbwarn "Current Directory is : $(pwd)"" to do_taskExample body
# do_taskExample[dirs] = "${WORKDIR}/ ${WORKDIR}/task-example-dir"

# Uncomment the lines below to observe the effect of [postfuncs] and [prefuncs].
# do_taskExample[prefuncs] = "prefunc"
# do_taskExample[postfuncs] = "postfunc"

# Uncomment the lines below to observe the effect of [lockfiles] 
# do_taskA[lockfiles] = "${TMPDIR}/shared.lock"
# do_taskB[lockfiles] = "${TMPDIR}/shared.lock"


do_taskA() {
 bbwarn "Task A: LOCK AQUIRED"
 sleep 5
 bbwarn "Task A: LOCK RELEASED"
}

addtask taskA before do_build

do_taskB() {
 bbwarn "Task B: LOCK AQUIRED"
 sleep 5
 bbwarn "Task B: LOCK RELEASED"
}

addtask taskB before do_build

prefunc(){
    bbwarn "do_taskExample prefuncs"
}

postfunc(){
    bbwarn "do_taskExample postfuncs"
}


do_taskExample() {
    bbwarn "Hello from do_taskExample"
}

addtask do_taskExample before do_build
