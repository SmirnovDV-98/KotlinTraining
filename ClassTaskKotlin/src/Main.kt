import RegisterController as rc


fun main() {
    rc.createStartingPull()
    rc.emptyOperationOnRegister()
    println(rc.currentRegister.toString())
    rc.changeRegNoCondition(Register((-1000..1000).random()))
    println(rc.currentRegister.toString())
}