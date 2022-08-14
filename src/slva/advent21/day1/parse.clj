(ns slva.advent21.day1.parse
  (:require [clojure.string :as str]))

(defn parse-input
  [input]
  (->>
    (str/split input #"\n")
    (filter (complement str/blank?))
    (map #(Integer/parseInt %))))
