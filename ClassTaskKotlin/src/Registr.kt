import java.lang.Exception

class Register (
    var regValue: Int = 0,
    private var flagN:Boolean,
    private var flagZ:Boolean) {
    init {
        flagN=(regValue<0)
        flagZ=(regValue==0)
    }
    fun changeValue(newValue:Int){
        this.regValue=newValue
    }
    fun getValFromOtherReg(reg:Register){
        this.regValue=reg.regValue
    }
    fun setValToOtherReg(reg: Register){
        reg.regValue=this.regValue
    }
    fun giveToOtherSource(){
        println(this.regValue)
    }
    fun getFromConsole(){
        this.regValue= readLine()?.toInt() ?: throw CustomException()
    }
    fun changeNFlag(){
        this.flagN = this.regValue<0
    }
    fun changeYFlag(){
        this.flagZ=(this.regValue==0)
    }
    fun getNFlag():Boolean=this.flagN

    fun getFlagY():Boolean=this.flagZ

}

class CustomException: Exception() {

}