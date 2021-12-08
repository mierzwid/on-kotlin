/*
 * Complete the 'activityNotifications' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY expenditure
 *  2. INTEGER d
 */
fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var notifications = 0
    val buckets = Array(201) { 0 }
    for (day in expenditure.indices) {
        if (day + 1 <= d) {
            buckets[expenditure[day]]++
            continue
        }
        val median = calculateMedian(buckets, d)
        if (expenditure[day] >= 2 * median) {
            notifications++
        }
        buckets[expenditure[day - d]]--
        buckets[expenditure[day]]++
    }
    return notifications
}
//size = 4
//middle = 2
//[0, 1, 1, 2]
//[1, 2, 3, 3]


fun calculateMedian(buckets: Array<Int>, size: Int): Float {
    var middle = size / 2
    when {
        size % 2 == 0 -> {
            for (bucket in buckets.indices) {
                if (middle - buckets[bucket] < 0) {
                    return bucket.toFloat()
                }
                if (middle - buckets[bucket] == 0) {
                    var next = bucket + 1
                    while (buckets[next] == 0) next++
                    return (bucket + next) / 2F
                }
                middle -= buckets[bucket]
            }
        }
        else -> {
            for (bucket in buckets.indices) {
                middle -= buckets[bucket]
                if (middle < 0) {
                    return bucket.toFloat()
                }
            }
        }
    }
    throw IllegalStateException("Should never happen!")
}