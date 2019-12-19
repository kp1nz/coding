package caculate

import "fmt"

func init() {
	fmt.Printf("invoke_caculate init...\n")
}
func Cclt(num1, num2 int) int {
	return num1*num2
}

func rectProps(length, width float64) (float64, float64) {
	var area = length * width
	var perimeter = (length + width) * 2
	return area, perimeter
}


//func main() {
//	//println(caculate(3,2))
//	a, _ := rectProps(2, 3)
//	fmt.Printf("%v",a)