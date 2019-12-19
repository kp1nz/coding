package golearn

import (
	"fmt"
)

func appendStr() func(string) string {
	t := "Hello"
	c := func(b string) string {
		t = t + " " + b
		return t
	}
	return c
}

func main() {
	a := appendStr()
	b := appendStr()
	fmt.Println(a("World"))
	fmt.Println(b("Everyone"))

	fmt.Println(a("Gopher"))
	fmt.Println(b("!"))
}
type student struct {
	firstName string
	lastName string
	grade string
	country string
}
func filter(s []student, f func(student) bool) []student {
	//var r []student
	//for _, v := range s {
	//	if f(v) == true {
	//		r = append(r, v)
	//	}
	//}
	var i []student
	for _,v:= range s{
		if f(v) == true{
			i = append(s, v)
		}
	}
	return i
}