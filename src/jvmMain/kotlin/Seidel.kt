import kotlin.math.roundToInt

class Seidel(private val coefficients: Array<Array<Double>>, private val freeNumbers: Array<Double>) {
    fun solve(): MutableList<CardItem> {
        val n = coefficients.size
        var x = DoubleArray(n)
        var prevX = DoubleArray(n)
        var iterations = 0
        var maxError: Double

        val result = mutableListOf<CardItem>()

        do {
            maxError = 0.0

            for (i in 0 until n) {
                var sum = 0.0

                for (j in 0 until n) {
                    if (j != i) {
                        sum += coefficients[i][j] * x[j]
                    }
                }

                prevX[i] = x[i]
                x[i] = (freeNumbers[i] - sum) / coefficients[i][i]

                val error = Math.abs(x[i] - prevX[i])
                if (error > maxError) {
                    maxError = error
                }
            }
            val error = calculateError(prevX, x)
            iterations++
            result.add(CardItem("Итерация $iterations", "Ответ: ${(x[0] * 100.0).roundToInt() / 100.0}, ${(x[1] * 100.0).roundToInt() / 100.0}, ${(x[2] * 100.0).roundToInt() / 100.0}, Ошибка: $error"))

        } while (maxError > EPSILON && iterations < MAX_ITERATIONS)

        if (iterations >= MAX_ITERATIONS) {
            result.add(CardItem("Ошибка", "Метод не сошелся за $MAX_ITERATIONS итераций"))
        } else {
            result.add(CardItem("Решение", "Ответ: ${x.contentToString()}"))
        }

        return result
    }
    private fun calculateError(previousX: DoubleArray, currentX: DoubleArray): Double {
        var maxError = 0.0
        for (i in previousX.indices) {
            val error = Math.abs(previousX[i] - currentX[i])
            if (error > maxError) {
                maxError = error
            }
        }
        return maxError
    }
    companion object {
        private const val EPSILON = 0.001
        private const val MAX_ITERATIONS = 1000
    }
}
