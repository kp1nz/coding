package kata

//6 https://www.codewars.com/kata/bit-counting/train/go
func CountBits(u uint) int {
	res := 0
	for ; u > 0; u /= 2 {
		if u/2*2 != u {
			res += 1
		}
	}
	return res
}
