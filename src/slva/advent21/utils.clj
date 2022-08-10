(ns slva.advent21.utils
  (:require [clojure.string :as str]))

(defn parse-number-lines
  [input]
  (->>
   (str/split input #"\n")
   (filter (complement str/blank?))
   (map #(Integer/parseInt %))))
