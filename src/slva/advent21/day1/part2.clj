(ns slva.advent21.day1.part2
  (:require [slva.advent21.utils :refer [parse-number-lines]]
            [slva.advent21.day1.part1 :as day1]))

(defn- sum [coll]
  (reduce + coll))

(defn- cut-window [size]
  (fn [nth coll]
    (let [len (count coll)]
      (subvec coll (min nth len) (min (+ nth size) len)))))

(defn- build-heads [coll nth]
  (->> (repeat (- (count coll) (dec nth)) coll)
       (map-indexed (cut-window nth))))

(defn calculate
  [input]
  (->> (build-heads (vec input) 3)
       (map sum)
       (day1/calculate)))

(def parse-input parse-number-lines)
