package golearn

import (
	"fmt"
	"time"
)

func process(ch chan string) {
	time.Sleep(3010 * time.Millisecond)
	ch <- "process successful"
}

func main() {
	ch := make(chan string)
	go process(ch)
	for {
		time.Sleep(1000 * time.Millisecond)
		select {
		case v := <-ch:
			fmt.Println("received value: ", v)
		default:
			fmt.Println("no value received")
		}
	}

}
