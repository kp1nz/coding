package kata

//8

func SquareSum(numbers []int) int {

	var sum int
	for _, a := range numbers {
		sum+=a*a
	}
	return sum
}
