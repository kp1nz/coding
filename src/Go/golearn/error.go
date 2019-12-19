package golearn

import (
	"errors"
	"fmt"
	"math"
)

func main() {
	//f, err := os.Open("/test.txt")
	//if err != nil {
	//	fmt.Println(err)
	//	return
	//}
	//fmt.Println(f.Name(), "opened successfully")
	radius := 20.0
	area, err := circleArea(radius)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Printf("Area of circle %0.3f", area)
}

func circleArea(radius float64) (float64, error) {
	if radius < 0 {
		return 0, errors.New("Area calculation failed, radius is less than zero")
	}
	return math.Pi * radius * radius, nil
}