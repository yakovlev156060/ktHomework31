fun main() {
    val seconds =60*21
    println(agoToText(seconds))

}

fun isJustNow(secondCount: Int):Boolean {
    return (secondCount<60)&&(secondCount>=0)
}

fun isMinuts(secondCount: Int):Boolean {
    return (secondCount<60 * 60)&&(secondCount>=60)
}

fun isHours(secondCount: Int):Boolean {
    return (secondCount<24 * 60 * 60)&&(secondCount>=60 * 60 + 1)
}

fun isToday(secondCount: Int):Boolean {
    return (secondCount<24 * 60 * 60 * 2)&&(secondCount>=24 * 60 * 60+1)
}

fun isYesterday(secondCount: Int):Boolean {
    return (secondCount<24 * 60 * 60 * 3)&&(secondCount>=24 * 60 * 60 * 2+1)
}

fun isLongTimeAgo(secondCount: Int):Boolean {
    return secondCount>=24 * 60 * 60 * 3
}

fun textMinuts(secondCount: Int):String{
    if(((secondCount/60)<15)&&((secondCount/60)>10)){
        return ("" + secondCount/60 + " минут назад")
    }

    else{
        return when ((secondCount/60) % 10) {
            1 -> ("" + secondCount/60 + " минуту назад")
            2,3,4 ->("" + secondCount/60 + " минуты назад")
            else -> ("" + secondCount/60 + " минут назад")
        }
    }
}


fun textHours(secondCount: Int):String{
    if((secondCount/3600==1)||(secondCount/3600==21)){
        return " 1 час назад"
    }
    if((secondCount/3600>1)&&(secondCount/3600<5)){
        return ""+secondCount/3600+" часа назад"
    }
    if((secondCount/3600>21)&&(secondCount/3600<25)){
        return ""+secondCount/3600+" часа назад"
    }
    else {
        return ""+secondCount/3600+" часов назад"
    }
}

fun agoToText (secondCount: Int):String {
    var rezult:String="был(а) "
    when{
        isJustNow(secondCount)-> rezult+="только что"
        isMinuts(secondCount)->{

            rezult+=textMinuts(secondCount)
        }
        isHours(secondCount)->{
            rezult+=textHours(secondCount)
        }
        isToday(secondCount)-> rezult+="сегодня"
        isYesterday(secondCount)-> rezult+="вчера"
        isLongTimeAgo(secondCount)-> rezult+="давно"
    }

   return rezult
}