package golearn

import (
	"fmt"
)

func main() {

	/**
	for i := 1; i <= 10; i++ {
		if i == 5 {
			break
		}
		fmt.Printf("%d ", i)
	}
	fmt.Printf("\nline after for loop\n")

	for i := 1; i <= 10; i++ {
		if i == 5 {
			continue
		}
		fmt.Printf("%d ", i)
	}
	fmt.Printf("\nline after for loop\n")


	for i := 1; i <= 10; i++ {
		if i%2 == 0 {
			continue
			fmt.Printf("miss....")
		}
		fmt.Printf("%d ", i)
	}
	i := 0
	for i <= 10 { //semicolons are ommitted and only condition is present
		fmt.Printf("%d ", i)
		i += 2
	}


	num := 15
	switch { // 表达式被省略了
	case num >= 0 && num <= 50:
		fmt.Println("num is greater than 0 and less than 50")
		fallthrough
	case num >= 51 && num <= 100:
		fmt.Println("num is greater than 51 and less than 100")
		fallthrough
	case num >= 101:
		fmt.Println("num is greater than 100")
	}


	a := [3]int{5, 78, 8}
	var b [3]int
	b = a
	fmt.Println(b)

	a := [...]string{"USA", "China", "India", "Germany", "France"}
	b := a // a copy of a is assigned to b
	b[0] = "Singapore"
	fmt.Println("a is ", a)
	fmt.Println("b is ", b)

	a := [...]float64{67.7, 89.8, 21, 78}
	sum := float64(0)
	for i, v := range a {//range returns both the index and value
		fmt.Printf("%d the element of a is %.2f\n", i, v)
		sum += v
	}
	fmt.Println("\nsum of all elements of a",sum)


	a := [3][2]string{
		{"lion", "tiger"},
		{"cat", "dog"},
		{"pigeon", "peacock"}, // this comma is necessary. The compiler will complain if you omit this comma
	}
	printarray(a)
	var b [3][2]string
	b[0][0] = "apple"
	b[0][1] = "samsung"
	b[1][0] = "microsoft"
	b[1][1] = "google"
	b[2][0] = "AT&T"
	b[2][1] = "T-Mobile"
	fmt.Printf("\n")
	printarray(b)


	darr := [...]int{57, 89, 90, 82, 100, 78, 67, 69, 59}
	dslice := darr[2:5]
	fmt.Println("array before", darr)
	for i := range dslice {
		dslice[i]++
	}
	fmt.Println("array after", darr)


	fruitarray := [...]string{"apple", "orange", "grape", "mango", "water melon", "pine apple", "chikoo"}
	fruitslice := fruitarray[1:3]
	fmt.Printf("length of slice %d capacity %d,but the length of fruitarray %d capacity %d",
		len(fruitslice), cap(fruitslice),len(fruitarray),cap(fruitarray))
		// length of slice 2 capacity 6,but the length of fruitarray 7 capacity 7


	//重置切片长度
	fruitarray := [...]string{"apple", "orange", "grape", "mango", "water melon", "pine apple", "chikoo"}
	fruitslice := fruitarray[1:3]
	fmt.Printf("length of slice %d capacity %d\n", len(fruitslice), cap(fruitslice)) // length of is 2 and capacity is 6
	fruitslice = fruitslice[:cap(fruitslice)] // re-slicing furitslice till its capacity
	fmt.Println("After re-slicing length is",len(fruitslice), "and capacity is",cap(fruitslice))


	var names []string
	if names == nil {
		fmt.Println("slice is nil going to append")
		names = append(names, "John", "Sebastian", "Vinay")
		fmt.Println("names contents:", names)
	}

	veggies := []string{"potatoes", "tomatoes", "brinjal"}
	fruits := []string{"oranges", "apples"}
	food := append(veggies, fruits...)
	fmt.Println("food:",food)

	nos := []int{8, 7, 6}
	fmt.Println("slice before function call", nos)
	subtactOne(nos)                               // function modifies the slice
	fmt.Println("slice after function call", nos) // modifications are visible outside


	countriesNeeded := countries()
	fmt.Println(countriesNeeded)


	find(89, 89, 90, 95)
	find(45, 56, 67, 45, 90, 109)
	find(78, 38, 56, 98)
	find(87)



	byteSlice := []byte{0x43, 0x61, 0x66, 0xC3, 0xA9}
	str := string(byteSlice)
	fmt.Println(str)



	a := "aaaaa"
	fmt.Println(utf8.RuneCountInString(a))


	b := 255
	var a *int = &b
	fmt.Printf("Type of a is %T\n", a)
	fmt.Println("address of b is", a)


	b := 255
	a := &b
	fmt.Println("address of b is", a)
	fmt.Println("value of b is", *a)
	*a++
	fmt.Println("new value of b is", b)
	fmt.Println("address of b still is", a)


	type Employee struct {
		firstName, lastName string
		age, salary         int
	}

	emp1 := Employee{"Sam", "Anderson", 55, 6000}
	fmt.Println("First Name:", emp1.firstName)
	fmt.Println("Age:", emp1.age)
	fmt.Println(emp1)

	emp2 := &Employee{"Sam", "Anderson", 55, 6000}
	fmt.Println("First Name:", (*emp2).firstName)
	fmt.Println("Age:", (*emp2).age)


	r := rectangle{
		length: 10,
		width:  5,
	}
	area(r)
	r.area()

	p := &r
	   //compilation error, cannot use p (type *rectangle) as type rectangle
	   //in argument to area
	//area(p)

	p.area()//通过指针调用值接收器

	pemp1 := Permanent{1, 5000, 20}
	pemp2 := Permanent{2, 6000, 30}
	cemp1 := Contract{3, 3000}
	employees := []SalaryCalculator{pemp1, pemp2, cemp1}
	totalExpense(employees)

	 */


	e := Employee {
		firstName: "Naveen",
		lastName: "Ramanathan",
		basicPay: 5000,
		pf: 200,
		totalLeaves: 30,
		leavesTaken: 5,
	}
	var s SalaryCalculator = e
	s.DisplaySalary()
	var l LeaveCalculator = e
	fmt.Println("\nLeaves left =", l.CalculateLeavesLeft())


}
type SalaryCalculator interface {
	DisplaySalary()
}

type LeaveCalculator interface {
	CalculateLeavesLeft() int
}

type Employee struct {
	firstName string
	lastName string
	basicPay int
	pf int
	totalLeaves int
	leavesTaken int
}

func (e Employee) DisplaySalary() {
	fmt.Printf("%s %s has salary $%d", e.firstName, e.lastName, (e.basicPay + e.pf))
}

func (e Employee) CalculateLeavesLeft() int {
	return e.totalLeaves - e.leavesTaken
}


type Describer interface {
	Describe()
}

type Address struct {
	state   string
	country string
}
func (a *Address) Describe() { // 使用指针接受者实现
	fmt.Printf("State %s Country %s", a.state, a.country)
}


type Permanent struct {
	empId    int
	basicpay int
	pf       int
}

type Contract struct {
	empId  int
	basicpay int
}

//salary of permanent employee is sum of basic pay and pf
func (p Permanent) CalculateSalary() int {
	return p.basicpay + p.pf
}

//salary of contract employee is the basic pay alone
func (c Contract) CalculateSalary() int {
	return c.basicpay
}

/*
total expense is calculated by iterating though the SalaryCalculator slice and summing
the salaries of the individual employees
*/
func totalExpense(s []SalaryCalculator) {
	expense := 0
	for _, v := range s {
		expense = expense + v.CalculateSalary()
	}
	fmt.Printf("Total Expense Per Month $%d", expense)
}


type rectangle struct {
	length int
	width  int
}

func area(r rectangle) {
	fmt.Printf("Area Function result: %d\n", (r.length * r.width))
}

func (r rectangle) area() {
	fmt.Printf("Area Method result: %d\n", (r.length * r.width))
}



func subtactOne(numbers []int) {
	for i := range numbers {
		numbers[i] -= 2
	}
}

func printarray(a [3][2]string) {
	for _, v1 := range a {
		for _, v2 := range v1 {
			fmt.Printf("%s ", v2)
		}
		fmt.Printf("\n")
	}
}

func countries() []string {
	countries := []string{"USA", "Singapore", "Germany", "India", "Australia"}
	neededCountries := countries[:len(countries)-2]
	countriesCpy := make([]string, len(neededCountries))
	copy(countriesCpy, neededCountries) //copies neededCountries to countriesCpy
	return countriesCpy
}

func find(num int, nums ...int) {
	fmt.Printf("type of nums is %T\n", nums)
	found := false
	for i, v := range nums {
		if v == num {
			fmt.Println(num, "found at index", i, "in", nums)
			found = true
		}
	}
	if !found {
		fmt.Println(num, "not found in ", nums)
	}
	fmt.Printf("\n")
}
