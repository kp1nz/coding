package golearn

import (
	"fmt"
	"golearn/caculate"
	"golearn/foo"
)

func init() {
	fmt.Printf("main init...\n")
}

func main() {
	//a, b := 1, 2
	//fmt.Printf("%v\n",caculate.Cclt(a,b))
	var _ = caculate.Cclt(1, 1, )
	foo.Abc()

	i := 10
	fmt.Printf("%d %T \n", i, i)


}
