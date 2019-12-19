package golearn

import (
	"fmt"
)

type add func(a int, b int) int

func main() {
	//var a add = func(a int, b int) int {
	//	return a + b
	//}
	//s := a(5, 6)
	//fmt.Println("Sum", s)
	// a := func(a int, b int) int{
	// 	return a*b
	// }
	// b :=a(2,3)
	// fmt.Println(b)

	//f := func(a, b int) int {
	//	return a + b
	//}
	//simple(f)

	i := func(a, b int) int{
		return a*b
	}
	simple(i)

}
func simple(a func(a, b int) int) {
	fmt.Println(a(60, 7))
}
