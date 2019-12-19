package kata

import (
	"strconv"
)

//6 https://www.codewars.com/kata/playing-with-digits/train/go
func DigPow(n, p int) int {
	// your code

	itoa := strconv.Itoa(n)
	var tmp int
	var res int
	for _, value := range itoa {
		//fmt.Printf("%s ", string(value))
		//fmt.Println(p)
		i, _ := strconv.Atoi(string(value))
		tmp+=int(calPow(float64(i),p))
		//fmt.Println(tmp)
		p++
	}
	for{
		if tmp==n*res {
			return res
		}else if tmp<n*res {
			return -1
		}else{
			res++
		}
	}
}

func calPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return x
	}

	result := calPow(x, n>>1)
	result *= result

	// if n = odd
	if n&1 == 1 {
		result *= x
	}
	return result
}



/**
	other version

func DigPow(n, p int) int {
	N := n
	var digits []int

	for n > 0 {
		digits = append(digits, n % 10)
		n = n / 10
	}

	sum := 0
	for i := len(digits) - 1; i >= 0; i-- {
		sum = sum + int(math.Pow(float64(digits[i]), float64(p)))
		p = p + 1
	}

	if sum % N == 0 {
		return sum / N
	} else {
		return -1
	}
}
 */
