import java.io.File

fun main() {
    val adressRead = "C:\\LegionRosters.txt"
    val adressWright="C:\\noText.txt"
    changeText(adressRead,adressWright)
}

/**
 * Functions for 1A part
 */
fun upCase(s:String):String{// = s.uppercase()
    val chArr = s.toCharArray()
    val chRes = ArrayList<Char>()
    for (i in chArr){
        chRes.add(i.uppercaseChar())
    }
    return chRes.toCharArray().concatToString()
}

fun lowCase(s:String):String{// = s.lowercase()
    val chArr = s.toCharArray()
    val chRes = ArrayList<Char>()
    for (i in chArr){
        chRes.add(i.lowercaseChar())
    }
    return chRes.toCharArray().concatToString()
}

fun capitalize(s:String):String{//=s.capitalize()
    var res =""
    val strArr = s.split(" ")
    for (i in strArr){
        val chArr:CharArray = i.toCharArray()
        chArr[0]=chArr[0].uppercaseChar()
        val iChanged=chArr.concatToString()
        res="${res}${iChanged} "
    }
    return res
}

fun compareNoRegister(s1:String, s2:String):String {
    if (s1.uppercase()==s2.uppercase())
    {
        return "They are equal"
    }
    val chArr1:CharArray = s1.uppercase().toCharArray()
    val chArr2:CharArray = s2.uppercase().toCharArray()

    var val1 =0
    var val2 =0

    for (i in chArr1){
        val1+=i.code
    }
    for (i in chArr2){
        val2+=i.code
    }
    return if (val1>val2){
        "$s1 is bigger then $s2"
    } else {
        "$s2 is bigger then $s1"
    }
}

fun compareWithRegister(s1:String, s2:String):String{
    if (s1==s2)
    {
        return "They are equal"
    }
    val chArr1:CharArray = s1.toCharArray()
    val chArr2:CharArray = s2.toCharArray()

    var val1 =0
    var val2 =0

    for (i in chArr1){
        val1+=i.code
    }
    for (i in chArr2){
        val2+=i.code
    }
    println("$val1 $val2")
    return if (val1>val2){
        "$s1 is bigger then $s2"
    } else {
        "$s2 is bigger then $s1"
    }
}

fun subStringSearchFromPosition(s:String,subString:String, n:Int):Boolean{
    if ((n<1||n>s.length)){
        throw(CustomException())
    }
    if ((s==subString)&&(n==0)){
        return true
    } else if (s==subString){
        return false
    }
    val sToCharArr=s.toCharArray(n-1)
    for (i in 0..sToCharArr.size-1-(subString.length-1)){
        var counter =0
        for (j in 0 until subString.length){
            if (sToCharArr[i+j]==subString[j]){
                counter++
            }
        }
        if (counter==subString.length){
            return true
        }
    }
    return false
}

fun registerCheck(s:String){
    if (s==s.uppercase()){
        println("String $s in UPPERCASE")
    } else if (s==s.lowercase()){
        println("String $s in lowercase")
    } else if (s==s.replaceFirstChar { it.uppercase() }){
        println("String $s is capitalized")
    } else {
        println("String $s is something else")
    }
}
/**
 * Functions, used for 1B part
 * main of them - changeText, others used inside
 */
fun writeIt(path:String, strList:List<String>){
    File(path).printWriter().use { out -> strList.forEach { out.println(it) } }
}

fun readIt(pathToRead:String):List<String>{
    val lineList = mutableListOf<String>()
    File(pathToRead).useLines { lines -> lines.forEach { lineList.add(it) }}
    return lineList.toList()
}

fun multiSplit(s:String):List<String>{
    val reg = Regex("(?<=[!? .,:;-])|(?=[!? .,:;-])")
    return s.split(reg)
}

fun changeText(pathToRead:String, pathToWrite:String){
    val list = readIt(pathToRead)
    val resStrListFin = mutableListOf<String>()
    for (i in list) {
        var resStrList =""
        val stringListToWorkWith = multiSplit(i)
        var flag =true
        for (j in stringListToWorkWith) {
            if ((j == "!") || (j == "?") || (j == ".")) {
                flag = true
            }
            if ((j==".")||(j==",")||(j=="?")||(j=="!")||(j==" ")||(j==":")||(j==";")||(j=="-")){
                resStrList="$resStrList$j"
                continue
            }
            if (j==j.uppercase()){
                resStrList="$resStrList$j"
                flag=false
                continue
            }
            if (j==j.lowercase().replaceFirstChar { it.uppercase() }){
                resStrList="$resStrList$j"
                flag=false
                continue
            }
            if (flag){
                resStrList="$resStrList${j.lowercase().replaceFirstChar { it.uppercase() }}"
                flag=false
                continue
            } else {
                // resStrList.add(j.lowercase())
                resStrList="$resStrList${j.lowercase()}"
                flag=false
                continue
            }
        }
        resStrListFin.add(resStrList)
    }
    writeIt(pathToWrite,resStrListFin)
}

class CustomException :Exception()

