package golearn

import "fmt"

func main() {
	/**

	fmt.Printf("hello")

	a, b := 1.111, 2.22
	c, d := 1, 2
	fmt.Println(a, b)
	//fmt.Printf(a,b)
	fmt.Printf("/d", a, b)
	fmt.Println(math.Max(a, b))
	fmt.Println(math.Inf(c))
	fmt.Println(math.Inf(d))
	i := 10
	var j float64 = float64(i) // 若没有显式转换，该语句会报错
	fmt.Println("j", j)

	const tttrue = true
	type myBool bool
	var aBool = tttrue
	var customBool myBool = true
	//aBool = customBool
	print(customBool)
	print(",")
	print(aBool)

	const a = 5
	var intVar int = a
	var int32Var int32 = a
	var float64Var float64 = a
	var complex64Var complex64 = a
	fmt.Println("intVar",intVar, "\nint32Var", int32Var, "\nfloat64Var", float64Var, "\ncomplex64Var",complex64Var)

	var i = 5
	var f = 5.6
	var c = 5 + 6i
	fmt.Printf("i's type %T, f's type %T, c's type %T", i, f, c)

	const a = 5
	var intVar int = a
	var int32Var int32 = a
	var float64Var float64 = a
	var complex64Var complex64 = a
	fmt.Println("intVar",intVar, "\nint32Var", int32Var, "\nfloat64Var", float64Var, "\ncomplex64Var",complex64Var)


	*/
	//var a = 0.88/8
	//fmt.Printf("a's type %T value %v",a, a)

	//const a = 0
	//var b float64 = 0
	//
	//var f1 float64 = a
	//var f2 = b
	//
	//fmt.Printf(" %s,\n %T", f1, f2)


	a, b := 1.111, 2.22
	c, d := 1, 2
	fmt.Printf("%v,%v\n",a,b)
	fmt.Println(c,d)
}
