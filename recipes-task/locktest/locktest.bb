SUMMARY = "Mutual exclusion lockfiles test"
LICENSE = "CLOSED"

# Force parallel scheduling to make the test meaningful
BB_NUMBER_THREADS = "4"

LOCKPATH = "${TMPDIR}/lockfiles/mutex-test.lock"

do_taskA[lockfiles] = "${LOCKPATH}"
do_taskB[lockfiles] = "${LOCKPATH}"

do_taskA() {
    bbwarn "Task A: LOCK ACQUIRED"
    sleep 6
    bbwarn "Task A: LOCK RELEASED"
}

do_taskB() {
    bbwarn "Task B: LOCK ACQUIRED"
    sleep 6
    bbwarn "Task B: LOCK RELEASED"
}

addtask do_taskA before do_build
addtask do_taskB before do_build
