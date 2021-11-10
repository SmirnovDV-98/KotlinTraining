object RegisterController{
    lateinit var currentRegister:Register
    val registrStack= ArrayDeque<Register>()

    fun sumRegValue(reg1:Register, reg2:Register, reg3:Register){
        var resVal= reg1.regValue+reg2.regValue
        reg3.regValue=resVal
        reg3.changeNFlag()
        reg3.changeZFlag()
    }
    fun decRegValue(reg1: Register,reg2: Register, reg3:Register){
        var resVal= reg1.regValue-reg2.regValue
        reg3.regValue=resVal
        reg3.changeNFlag()
        reg3.changeZFlag()
    }
    fun changeRegNoCondition(reg: Register){
        this.currentRegister=reg
    }
    fun changeRegWithConditionFlagN(reg:Register){
        if (this.currentRegister.getNFlag()){
            this.currentRegister=reg
        }
    }
    fun changeRegWithConditionFlagY(reg:Register){
        if (this.currentRegister.getFlagZ()){
            this.currentRegister=reg
        }
    }
    fun setControllingRegister(reg:Register){
        this.currentRegister=reg
    }
    fun emptyOperationOnRegister(){
        if (registrStack.size!=0){
            this.currentRegister=registrStack.first()
            registrStack.removeFirst()
        }
    }
    fun addToStack(r:Register){
        registrStack.add(0,r)
    }
    fun createStartingPull(){
        for(i in 0..10){
            registrStack.add(Register((-1000..1000).random()))
        }
    }
}