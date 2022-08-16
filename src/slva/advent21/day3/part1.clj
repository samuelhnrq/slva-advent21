(ns slva.advent21.day3.part1)

(def input-size 12)

(defn- reduce-bit [state index next]
  (let [elem (mod index input-size)
        index (+ elem (if (= 0 next) 0 input-size))]
    (update state index inc)))

;; (defn- inspect [msg val]
;;   (println msg val)
;;   val)

(defn- bit-array [bits]
  (->>
   bits
   (reverse)
   (map-indexed #(* %2 (Math/pow 2 %1)))
   (reduce +)))

(defn xfs-or [f fColl sColl]
  (fn [i]
    (let [one (nth fColl i)
          two (nth sColl i)]
      (if (f one two) 1 0))))

(defn- masks-to-bits [[zeros ones]]
  [(map (xfs-or > zeros ones) (range input-size))
   (map (xfs-or > ones zeros) (range input-size))])

(defn calculate [input]
  (->>
   (reduce-kv reduce-bit (vec (repeat (* 2 input-size) 0)) input)
   (partition input-size)
   masks-to-bits
   (map bit-array)
   (reduce *)
   int))
