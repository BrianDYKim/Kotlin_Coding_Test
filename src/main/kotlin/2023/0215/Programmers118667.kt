package `2023`.`0215`

import java.util.*

/**
 * @author Brian
 * @since 2023/02/15
 */
class Programmers118667 {
    // intArray를 queue로 만들어서 반환하는 메소드
    fun arrayToQueue(intArray: IntArray): LinkedList<Int> {
        return LinkedList(intArray.asList())
    }

    // 작업의 최대 개수를 반환하는 메소드
    fun getMaxJobCount(queue: LinkedList<Int>): Int {
        return queue.size * 4
    }

    // 작업을 수행하며 결과값을 리턴해주는 메소드
    fun executeJob(queue1: LinkedList<Int>, queue2: LinkedList<Int>): Int {
        var answer = 0
        var target = 0

        val maxCount = getMaxJobCount(queue1)

        var sum1 = queue1.sum().toLong()
        var sum2 = queue2.sum().toLong()

        while (answer <= maxCount) {
            if (sum1 > sum2) {
                target = queue1.poll()
                queue2.add(target)

                sum1 -= target
                sum2 += target
                answer += 1
            } else if (sum1 < sum2) {
                target = queue2.poll()
                queue1.add(target)

                sum1 += target
                sum2 -= target

                answer += 1
            } else {
                return answer;
            }
        }

        return -1
    }

    fun solution(array1: IntArray, array2: IntArray): Int {
        val queue1 = arrayToQueue(array1)
        val queue2 = arrayToQueue(array2)

        return executeJob(queue1, queue2)
    }
}