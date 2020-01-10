package kata

import (
	"fmt"
	"math"
)
func NbMonths(startPriceOld, startPriceNew, savingperMonth int, percentLossByMonth float64) [2]int {
	if startPriceOld >= startPriceNew {
		return [2]int{0, startPriceOld - startPriceNew}
	}
	cost := 1
	return calculation(cost, float64(startPriceOld), float64(startPriceNew), float64(savingperMonth), percentLossByMonth)
}
func calculation(cost int, startPriceOld, startPriceNew, savingperMonth, percentLossByMonth float64) [2]int {
	if cost%2 == 0 {
		percentLossByMonth += 0.5
	}
	floor := int(math.Floor(savingperMonth*float64(cost)-(startPriceNew-startPriceOld)*(1-percentLossByMonth*0.01)+0.5))
	fmt.Println(savingperMonth*float64(cost)-(startPriceNew-startPriceOld)*(1-percentLossByMonth*0.01))
	if (startPriceNew-startPriceOld)*(1-percentLossByMonth*0.01)-savingperMonth*float64(cost) <= 0 {
		return [2]int{cost, floor}
	}
	cost++
	return calculation(cost, startPriceOld*(1-percentLossByMonth*0.01), startPriceNew*(1-percentLossByMonth*0.01), savingperMonth, percentLossByMonth)
}

func NbMonthss(startPriceOld, startPriceNew, savingperMonth int, percentLossByMonth float64) [2]int {
	if startPriceOld >= startPriceNew {
		return [2]int{0, startPriceOld - startPriceNew}
	}
	cost := 1
	if cost%2 == 0 {
		percentLossByMonth += 0.5
	}
	rest := float64(savingperMonth*cost) - float64(startPriceNew-startPriceOld)*(1-percentLossByMonth*0.01)
	if  rest>= 0 {
		return [2]int{cost,int(math.Floor(rest)+0.5)}
	}
	cost++
	return NbMonthss(int(math.Floor(float64(startPriceOld)*(1-percentLossByMonth*0.01)+0.5)), int(math.Floor(float64(startPriceNew)*(1-percentLossByMonth*0.01)+0.5)),
		savingperMonth,percentLossByMonth)
}
