# playground

My implementations in clojure for the problems in the advent of code 2021 alongside some basic CLI infrastructure 

## Installation

Just clone the repo and run directly with the instructions provided on the options section, otherwise you can
download the jar from the pipeline artifacts, but that's not as useful because the current algorhitm for fetching
inputs reads them from the classpath, you can alter the jar's content but that's far less useful than simply
chaning the .txt file on your local clone.

## Options

When reading args normally trough -M or jar file (most common) the first argument is the number of the 
day and the second is puzzle the part, 1 or 2 only those two arguments, both required, in summary:

``` sh
$ clj -M:run-m <day> <part>
```

## Examples

``` sh
$ clj -M:run-m 3 1
Reading input for day 3 (from classpath)
Starting to parse input
It took 0.03 ms
Starting to calculate
It took 0.12 ms
Result is:
 - 1540241

```


## License

Copyright © 2022 Samosaara
Distribuited under GPLv3+

