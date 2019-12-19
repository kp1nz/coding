package golearn

import (
	"fmt"
	"time"
)

func hello(done chan bool) {
	fmt.Println("hello go routine is going to sleep")
	time.Sleep(4 * time.Second)
	fmt.Println("hello go routine awake and going to write to done")
	done <- true
}
func main() {
	/*
		done := make(chan bool)
		fmt.Println("Main going to call hello go goroutine")
		go hello(done)
		<-done
		fmt.Println("Main received data")


		ch := make(chan string, 2)
		ch <- "naveen"
		ch <- "paul"
		fmt.Println(<- ch)
		fmt.Println(<- ch)


		ch := make(chan int, 2)
		go write(ch)
		time.Sleep(2 * time.Second)
		for v := range ch {
			fmt.Println("read value", v, "from ch")
			time.Sleep(2 * time.Second)

		}
	*/

	ch := make(chan string, 3)
	ch <- "naveen"
	ch <- "paul"
	fmt.Println("capacity is", cap(ch))
	fmt.Println("length is", len(ch))
	ch <- "aaaa"
	fmt.Println("length is", len(ch))
	fmt.Println("capacity is", cap(ch))

}
func write(ch chan int) {
	for i := 0; i < 5; i++ {
		ch <- i
		fmt.Println("successfully wrote", i, "to ch")
	}
	close(ch)
}
