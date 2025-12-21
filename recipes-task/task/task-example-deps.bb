SUMMARY = "Task Example Deps"
DESCRIPTION = "Recipes to implement task-example Depes"
LICENSE = "CLOSED"


SRC_URI = "file://main.c"

S = "${WORKDIR}"

python do_taskExampleDeps() {
    bb.warn("do_taskExample dependencies: Hello from do_taskExampleDeps");
}
addtask do_taskExampleDeps before do_build


do_compile(){
    bbwarn "do_taskExample dependencies: Hello from do_compile"
    ${CC} ${LDFLAGS} -o main main.c
}
