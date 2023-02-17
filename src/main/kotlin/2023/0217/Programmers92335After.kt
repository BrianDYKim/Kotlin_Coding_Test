package `2023`.`0217`

import java.math.BigInteger

/**
 * @author Brian
 * @since 2023/02/18
 */
class Programmers92335After {
    // 해당 숫자가 소수인지 판별하는 메소드
    private fun isPrime(number: BigInteger): Boolean {
        if (number == 2.toBigInteger()) {
            return true
        }

        var i: Int = 2

        while (i <= Math.sqrt(number.toDouble())) {
            if (number % i.toBigInteger() == BigInteger.ZERO) {
                return false
            }
            i++
        }

        return true
    }

    fun solution(originNumber: Int, radix: Int): Int {
        val transformedNumber: String = originNumber.toString(radix)

        val resultList = transformedNumber.split("0").filter { token ->
            token.isNotEmpty() &&
                    token != "1" &&
                    isPrime(token.toBigInteger()) &&
                    (
                            transformedNumber.contains("0${token}") ||
                                    transformedNumber.contains("${token}0") ||
                                    transformedNumber.contains("0${token}0") ||
                                    transformedNumber.contains(token)
                            )
        }

        println(resultList)

        return resultList.size
    }
}