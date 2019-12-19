package kata

/**
https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/go
6
*/

func Solution(str string) []string {

	var a []string
	var temp string
	for i, value := range str {
		temp+=string(value)
		if i%2 == 1 {
			a = append(a, temp)
			temp = ""
		}
	}
	if len(str)%2==1 {
		temp+="_"
		a = append(a, temp)
	}
	return a
}
