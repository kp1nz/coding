package kata

import "fmt"

//5 https://www.codewars.com/kata/perimeter-of-squares-in-a-rectangle/train/go

func Perimeter(n int) int {
	// your code
	return 4*getFibonacci_sum(n+1)
}
func getFibonacci_sum(n int) int {
	if n <= 1 {
		return n
	}
	fibonacciI0 := 0
	fibonacciI1 := 1
	fibonacciI2 := 1
	sum :=1
	for i := 2; i <= n; i++ {
		fibonacciI2 = fibonacciI0 + fibonacciI1
		fibonacciI0 = fibonacciI1
		fibonacciI1 = fibonacciI2
		fmt.Println(fibonacciI2)
		sum+=fibonacciI2
	}
	return sum
}
func getFibonacci_low(n int) int {
	if n <= 1 {
		return n
	}
	return getFibonacci_low(n-2) + getFibonacci_low(n-1)
}
/**
	高手的解法
func Perimeter(n int) int {
  a, b, t := 1, 1, 1
  for i := 0; i < n + 2; i++ {
    t = a + b
    a = b
    b = t
  }
  return 4 * (a - 1)
}
 */

