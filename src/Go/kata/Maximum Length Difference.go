package kata

import "math"

//7
func MxDifLg(a1 []string, a2 []string) int {
	var temp int = -1
	if len(a1) > 0 && len(a2) > 0 {
		for _, a := range a1 {
			for _, b := range a2 {
				temp = int(math.Max(math.Abs(float64(len(a)-len(b))), float64(temp)))
			}
		}
	}
	return temp
}
