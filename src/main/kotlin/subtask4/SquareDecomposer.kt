package subtask4

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        return decompose(number.toLong()*number.toLong(), number)?.toTypedArray()
    }

    private fun decompose(sum: Long, number: Int): ArrayList<Int>? {
        if (sum<0L) return null
        else if (sum==0L) return ArrayList()
        else {
            var n=number-1
            var arl: ArrayList<Int>? =null
            while (n>0 && arl == null){
                arl=decompose(sum-n.toLong()*n.toLong(), n)
                n--
            }
            if (arl == null) return null
            else{
                arl.add(n+1)
                return arl
            }
        }
    }
}
