(ns slva.advent21.day1.part2
  (:require [slva.advent21.utils :refer [parse-number-lines]]
            [slva.advent21.day1.part1 :as day1]))

(defn- sum [coll]
  (reduce + coll))

(defn- build-heads [coll nth]
  (->> (repeat nth coll)
       (map-indexed drop)
       (mapcat #(partition nth %))
       (map sum)))

(defn calculate
  [input]
  (->> (build-heads input 3)
       (day1/calculate)))

(def parse-input parse-number-lines)
