(ns slva.advent21.day3.parse
  (:require [clojure.edn :as edn]
            [clojure.string :as string]))

(defn- surround-with-brackets
  [x]
  (str "[" x "]"))

(defn parse-input
  "Parses day 2 input"
  [inputStr]
  (->>
   (string/replace inputStr #"(\d)" "$1 ")
   surround-with-brackets
   edn/read-string))
