(ns slva.advent21.day1.part1)

(defn calculate
  [input]
  (->>
   (cons (or (first input) 1) input)
   (map vector input)
   (map (fn [[fst snd]] (if (> fst snd) 1 0)))
   (reduce +)))
