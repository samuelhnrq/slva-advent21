(ns slva.advent21.day2.part1
  (:require [slva.advent21.day2.parse :refer [->Action]]))

(defn- get-direction [action]
  (case (:direction action)
    :down :vertical
    :up :vertical
    :forward :horizontal))

(defn- calculate-verticals [actionList]
  (->> actionList
       (map #(if (= :down (:direction %))
               (:amount %)
               (- (:amount %))))
       (reduce +)))

(defn- calculate-horizontals [actionList]
  (->> actionList
       (map :amount)
       (reduce +)))

(defn- actions-to-coordinates [[kind actionList]]
  (case kind
    :vertical (calculate-verticals actionList)
    :horizontal (calculate-horizontals actionList)))

(def ^:private zero-values [(->Action :up 0)
                            (->Action :forward 0)])

(defn calculate [input]
  (->> (if (empty? input) zero-values input)
       (group-by get-direction)
       (map actions-to-coordinates)
       (reduce * 1)))
