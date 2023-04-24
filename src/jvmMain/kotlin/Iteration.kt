data class CardItem(val title: String, val description: String)

class Iteration(private val coefficients: Array<Array<Double>>, private val freeNumbers: Array<Double>) {

    fun solve(): List<CardItem> {
        val result = mutableListOf<CardItem>()
        var x = arrayOf(0.0, 0.0, 0.0)
        val epsilon = 0.001 // convergence threshold
        var iteration = 1

        do {
            val previousX = x.copyOf()

            for (i in coefficients.indices) {
                var sum = freeNumbers[i]

                for (j in coefficients.indices) {
                    if (j != i) {
                        sum -= coefficients[i][j] * x[j]
                    }
                }

                x[i] = sum / coefficients[i][i]
            }

            val error = calculateError(previousX, x)
            result.add(CardItem("Итерация $iteration", "Ошибка: $error"))
            iteration++
        } while (error > epsilon)

        return result
    }

    private fun calculateError(previousX: Array<Double>, currentX: Array<Double>): Double {
        var maxError = 0.0
        for (i in previousX.indices) {
            val error = Math.abs(previousX[i] - currentX[i])
            if (error > maxError) {
                maxError = error
            }
        }
        return maxError
    }
}
