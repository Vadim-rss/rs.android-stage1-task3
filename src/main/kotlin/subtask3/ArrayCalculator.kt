package subtask3

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val list = itemsFromArray.filterIsInstance<Int>()

        if (list.isEmpty()) return 0

        var product = 1
        if (numberOfItems >= list.size) {
            list.forEach { product *= it}
            return product
        }

        val positive = mutableListOf<Int>()
        val negative = mutableListOf<Int>()
        list.forEach {
            if (it >= 0) positive.add(it)
            else negative.add(it)
        }
        positive.sortDescending()
        negative.sort()

        if (numberOfItems == 1) return list.max()!!

        val posEndPoint = positive.size - 1
        val negEndPoint = negative.size - 1
        var posPoint = 0
        var negPoint = 0
        var max = 0
        for (i in 0 until numberOfItems / 2) {
            when {
                negPoint + 1 > negEndPoint -> {
                    max = positive[posPoint] * positive[posPoint + 1]
                    posPoint += 2
                }
                posPoint + 1 > posEndPoint -> {
                    max = negative[negPoint] * negative[negPoint + 1]
                    negPoint += 2
                }
                positive[posPoint] * positive[posPoint + 1] > negative[negPoint] * negative[negPoint + 1] -> {
                    max = positive[posPoint] * positive[posPoint + 1]
                    posPoint += 2
                }
                else -> {
                    max = negative[negPoint] * negative[negPoint + 1]
                    negPoint += 2
                }
            }
            product *= max
        }

        if (numberOfItems % 2 != 0) {
            product *= positive[posPoint]
        }

        return product
    }
}
