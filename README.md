#fileio 
By Wongsathorn Panichkurkul

Task | Time
----------------------------------------|----------:
Copy a file one byte at a time | 10.982847 sec
Copy the file using a byte array of size 1 KB | 0.013280 sec
Copy a file using a byte array of size 4 KB | 0.005472 sec
Copy a file using a byte array of size 64KB | 0.002045 sec
Copy a file by using BufferedReader and PrintWriter to copy lines of text | 0.106274 sec
Copy a file by using BufferedReader and BufferedWriter with one char at a time | 0.131525 sec

__Why Copy a file by using a byte array take more time than using BufferedReader ?__</br>
Because BufferedReader reads characters and buffers its input.

__Why Copy a file by using BufferedReader and BufferedWriter more efficient than using BufferedReader and PrintWriter to copy lines of text?__</br>
Because a BufferedWriter is an efficient way to write to a file, it will buffer the characters in memory before writing to the file.

__Why time of copy by using 1 byte > 1KB > 4KB > 64KB ?__ </br>
Because it can read more data in each time.
