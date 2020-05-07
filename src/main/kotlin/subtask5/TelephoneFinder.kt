package subtask5

import java.lang.StringBuilder

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number[0]=='-') return null
        val list: ArrayList<String> = ArrayList()
        for(position in number.indices) list.addAll(changeNumber(position, number))
        return list.toTypedArray()
    }

    private fun changeNumber(position: Int, number: String): ArrayList<String>{
        return when (number[position]){
            '0' ->{newNumbers(position, arrayOf('8'), number)}
            '1' ->{newNumbers(position, arrayOf('2', '4'), number)}
            '2' ->{newNumbers(position, arrayOf('1', '3', '5'), number)}
            '3' ->{newNumbers(position, arrayOf('2', '6'), number)}
            '4' ->{newNumbers(position, arrayOf('1', '5', '7'), number) }
            '5' ->{newNumbers(position, arrayOf('2', '4', '6', '8'), number)}
            '6' ->{newNumbers(position, arrayOf('3', '5', '9'), number)}
            '7' ->{newNumbers(position, arrayOf('4', '8'), number)}
            '8' ->{newNumbers(position, arrayOf('5', '7', '9', '0'), number)}
            else ->{newNumbers(position, arrayOf('6', '8'), number) }
        }
    }

    private fun newNumbers(position: Int, digits: Array<Char>, number: String): ArrayList<String>{
        val strbuf = StringBuilder(number)
        val numbers: ArrayList<String> = ArrayList()
        for (i in digits.indices){
            strbuf[position]=digits[i]
            numbers.add(strbuf.toString())}
        return numbers
    }
}
