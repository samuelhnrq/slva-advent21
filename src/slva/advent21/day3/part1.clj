(ns slva.advent21.day3.part1)

(def input-size 12)

(defn- reduce-bit [state index next]
  (let [elem (mod index input-size)]
    (if (= next 1)
      (update state elem inc)
      state)))

(defn- inspect [msg val]
  (println msg val)
  val)

(defn- bits-to-int [bits]
  (->>
   bits
   reverse
   (map-indexed #(* %2 (Math/pow 2 %1)))
   (reduce +)
   int))

(defn- masks-to-bits [ttl-inputs ones]
  (let [half (Math/ceil (/ ttl-inputs 2.0))]
    [(map #(if (> % half) 1 0) ones)
     (map #(if (> % half) 0 1) ones)]))

(defn calculate [input]
  (let [ttl-inputs (/ (count input) input-size)]
    (->>
     (reduce-kv reduce-bit (vec (repeat input-size 0)) input)
     (masks-to-bits ttl-inputs)
     (map bits-to-int)
     (reduce *))))
