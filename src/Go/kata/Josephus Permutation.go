package kata

//5 https://www.codewars.com/kata/josephus-permutation/train/go
func Josephus(items []interface{}, k int) []interface{} {
	//按题意需要处理空切片且返回的切片长度和容量需要都为空
	res := []interface{}{}
	ch := make(chan interface{}, len(items))
	for _, v := range items {
		ch <- v
	}
	for i := 1; len(ch) > 0; i++ {
		if i % k == 0 {
			res = append(res, <- ch)
		} else {
			ch <- <- ch
		}
	}
	return res
}