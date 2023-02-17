package `2023`.`0217`

/**
 * @author Brian
 * @since 2023/02/18
 */
class Programmers92335Before {
    private fun transformNumber(originNumber: Int, radix: Int): String {
        var quotient: Int = originNumber
        var remainder: Int = 0
        var resultBuffer: StringBuffer = StringBuffer()

        while (quotient != 0) {
            remainder = quotient % radix
            quotient /= radix

            resultBuffer.append(remainder)
        }

        return resultBuffer.reverse().toString()
    }

    private fun isPrime(number: Long): Boolean {
        if (number.toInt() == 1) {
            return false
        } else if (number.toInt() == 2 || number.toInt() == 3) {
            return true
        }

        for (i in 2..Math.sqrt(number.toDouble()).toLong()) {
            if (number % i == 0.toLong()) {
                return false
            }
        }

        return true
    }

    private fun possible(numberSnippet: String): Boolean {
        if (numberSnippet == "") {
            return false
        }

        val numberToLong: Long = numberSnippet.toLong()
        if (isPrime(numberToLong)) {
            return true
        }

        return false
    }

    private fun execute(transformedNumber: String): Int {
        var answer: Int = 0
        var buffer: String = ""

        transformedNumber.toCharArray().forEachIndexed { idx, token ->
            if (token == '0' && buffer.length != 0) {
                if (possible(buffer)) {
                    answer += 1
                }

                buffer = ""
            }

            if (token != '0') {
                buffer += token
            }

            if (idx == transformedNumber.length - 1) {
                if (possible(buffer)) {
                    answer += 1
                }
            }
        }

        return answer
    }

    fun solution(originNumber: Int, radix: Int): Int {
        val transformedNumber: String = transformNumber(originNumber, radix)
        val answer = execute(transformedNumber)

        return answer
    }
}