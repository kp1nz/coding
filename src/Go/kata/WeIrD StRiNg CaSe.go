package kata

import "fmt"

func ToWeirdCase(str string) string {
	// Your code here and happy coding!
	var res []byte
	count := 0
	for _, value := range str {
		fmt.Println(count, value, string(value))
		if count%2 == 0 && value >= 97 && value <= 122 {
			res = append(res, byte(value-32))
			count++
		} else if count%2 == 1 && value >= 65 && value <= 90 {
			res = append(res, byte(value+32))
			count++
		}else if value==32{
			res = append(res, byte(value))
			count = 0
		} else {
			res = append(res, byte(value))
			count++
		}
	}
	return string(res)
}
