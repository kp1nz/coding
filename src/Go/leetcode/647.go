package main

import "fmt"

var res int

func CountSubstrings(s string) int {
	res = 0
	for i := 0; i < len(s); i++ {
		//回文串长度为偶数
		countSubstrings(s, i, i)
		//回文串长度为偶数
		countSubstrings(s, i, i+1)
	}
	return res
}
func countSubstrings(s string, left int, right int) {
	for left >= 0 && right < len(s) && s[left] == s[right] {
		left--
		right++
		res++
	}

}
func main() {
	fmt.Println(CountSubstrings("sss"))
}
