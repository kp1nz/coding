package main

import (
	"fmt"
	"os"
)

func main() {
	//box := packr.NewBox("../filehandling")
	//data := box.String("test.txt")
	//fmt.Println("Contents of file:", data)

	//file, e := os.Create("test.txt")
	//if e != nil {
	//	fmt.Println(e)
	//	return
	//}
	//n, e := file.WriteString(",Hello")
	//if e!=nil {
	//	fmt.Println(e)
	//	file.Close()
	//	return
	//}
	//fmt.Println("length of write is:",n)
	//e = file.Close()
	//if e!=nil {
	//	fmt.Println(e)
	//	return
	//}

	f, err := os.Create("lines.txt")
	if err != nil {
		fmt.Println(err)
		f.Close()
		return
	}
	d := []string{"Welcome to the world of Go1.", "Go is a compiled language.",
		"It is easy to learn Go."}

	for _, v := range d {
		fmt.Fprintln(f, v)
		if err != nil {
			fmt.Println(err)
			return
		}
	}

	//err = f.Close()
	//if err != nil {
	//	fmt.Println(err)
	//	return
	//}

	fmt.Println("file written successfully")
	f1, err := os.OpenFile("lines.txt", os.O_APPEND|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println(err)
		return
	}
	newLine := "File handling is easy."
	_, err = fmt.Fprintln(f, newLine)
	if err != nil {
		fmt.Println(err)
		f1.Close()
		return
	}
	err = f1.Close()
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println("file appended successfully")
}
