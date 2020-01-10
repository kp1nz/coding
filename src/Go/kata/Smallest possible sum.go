package kata

import (
	"fmt"
	"math"
	"sort"
)

/**
4 https://www.codewars.com/kata/52f677797c461daaf7000740/train/go
实质是一个找最小公因数的过程
*/
func Solutions(ar []int) int {
	if len(ar) == 1 {
		return ar[0]
	}
	fmt.Println(ar)
	sort.Ints(ar)
	var res int
	for i := len(ar) - 1; i >= 0; i-- {
		if res == 0 {
			res = ar[i]
		}
		res = getFactor(ar[i], res)
	}
	return res* len(ar)
}

//超時
func Solution2(ar []int) int {
	sort.Ints(ar)
	return getResult(ar) * len(ar)
}

func getResult(ar []int) int {
	var res []int
	if len(ar) == 1 {
		return ar[0]
	} else {
		for i := 0; i < len(ar)-1; i++ {
			res = append(res, getFactor(ar[i+1], ar[i]))
		}
		return getResult(res)
	}
}

func getFactor(a, b int) int {
	temp := a % b
	fmt.Println("temp:", temp)
	if temp > 0 {
		return getFactor(b, temp)
	} else {
		return b
	}
}

//超時
func Solutions1(ar []int) int {
	// return smallest possible sum of all numbers in array
	temp := 0
	if len(ar) == 1 {
		return ar[0]
	}

	for i := 0; i < len(ar); i++ {
		for j := i + 1; j < len(ar); j++ {
			if temp == 0 {
				temp = int(math.Abs(float64(ar[j] - ar[i])))
			}
			if int(math.Abs(float64(ar[j]-ar[i]))) < temp && int(math.Abs(float64(ar[j]-ar[i]))) > 0 {
				temp = int(math.Abs(float64(ar[j] - ar[i])))
			}
			if ar[j] == 1 || ar[i] == 1 {
				return len(ar)
			}
		}
	}
	return temp * len(ar)
}
