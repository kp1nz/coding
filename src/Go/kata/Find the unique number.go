package kata

import (
	"sort"
)

//6
func FindUniq(arr []float32)  float32{
	sort.Slice(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})
	if arr[0] == arr[1] {
		return arr[len(arr)-1]
	} else {
		return arr[0]
	}
}
