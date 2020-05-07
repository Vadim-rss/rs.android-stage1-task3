package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val xarr = arrayListOf<Int>()

        for (k in 1..array[1]){
            val f = factorial(array[1])/(factorial(k)*factorial(array[1]-k))
            if ( f == array[0].toDouble()) {
                xarr.add(k)
            }
        }
        if (xarr.isNotEmpty()) {
            val x = xarr.min()
            return x
        } else {
            return null
        }
    }
}

    fun factorial(n: Int): Double {
        var result = 1.0
        for (i in 1..n) {
            result = result * i
        }
        return result
    }

