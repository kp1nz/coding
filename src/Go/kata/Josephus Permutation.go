package kata

//5 https://www.codewars.com/kata/josephus-permutation/train/go
func Josephus(items []interface{}, k int) []interface{} {

	// Your code:
	var res []interface{}
	for i := 0; i*k < len(items); i++ {
		res := append(res, items[i*k])
		return res
	}
	return nil
}
