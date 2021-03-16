object Solution {
  // you need treat n as an unsigned value
  def hammingWeight(n: Int): Int = {
    if (n == 0) {return 0}

    var nn = n
    var result = 0
    while (nn != 0) {
      // println(nn, (nn & 1))
      if ((nn & 1) == 1) {result += 1}

      // Fact 1: >>> (Shift right zero fill): 1000... => 0100... => 0010...
      // Fact 2: >>: 1000... => 1100... => 1110...

      // Need to use >>> here for n > 2147483648 (2^31 - 1)
      // since Scala/Java does not have unsigned int

      // Otherwise, Example 3 won't work (4294967293 <==> -3)

      /* Sample code to demonstrate Fact 2
        var n = -2147483648
        for (i <- 1 to 31) {
          n = n >> 1
          println(n,(n & 1))
        }
      */
      nn = nn >>> 1
    }

    return result
  }
}