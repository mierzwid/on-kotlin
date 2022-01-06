package search

class MinimumTime {
    fun minTime(machines: Array<Long>, goal: Long): Long {
        var overallSpeedPerDay = 0.0
        var slowestMachine = 0L
        for (machine in machines) {
            overallSpeedPerDay += 1.0/machine.toDouble()
            slowestMachine = Math.max(slowestMachine, machine)
        }
        var lowerBound = Math.floor(goal.toDouble() / overallSpeedPerDay).toLong()
        var upperBound = lowerBound + slowestMachine

        while (lowerBound < upperBound) {
            val middle = (upperBound + lowerBound) / 2
            var items = 0L
            for(machine in machines) {
                items += middle / machine
            }
            if(items >= goal) {
                upperBound = middle
            } else {
                lowerBound = middle + 1
            }
        }
        return lowerBound
    }
}