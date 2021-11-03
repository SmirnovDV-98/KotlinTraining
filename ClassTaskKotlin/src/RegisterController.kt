object RegisterController{
    private lateinit var currentRegister:Register

    fun sumRegValue(reg1:Register, reg2:Register, reg3:Register){
        var resVal= reg1.regValue+reg2.regValue
        reg3.regValue=resVal
        reg3.changeNFlag()
        reg3.changeYFlag()
    }
    fun decRegValue(reg1: Register,reg2: Register, reg3:Register){
        var resVal= reg1.regValue-reg2.regValue
        reg3.regValue=resVal
        reg3.changeNFlag()
        reg3.changeYFlag()
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
        if (this.currentRegister.getFlagY()){
            this.currentRegister=reg
        }
    }
    fun setControllingRegister(reg:Register){
        this.currentRegister=reg
    }
    fun EmptyOperationOnRegister(){

    }
}