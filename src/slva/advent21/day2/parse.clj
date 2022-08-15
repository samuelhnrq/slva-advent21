(ns slva.advent21.day2.parse
  (:require [clojure.edn :as edn]
            [clojure.string :as string]))


(defn- surround-with-brackets
  [x]
  (str "[" x "]"))

(defrecord Action [direction amount])

(defn parse-input
  "Parses day 2 input"
  [inputStr]
  (->>
    (string/replace inputStr
                    #"(?m)^(\w+) (\w+)$"
                    "{:direction :$1 :amount $2}")
    surround-with-brackets
    edn/read-string
    (map map->Action)))
