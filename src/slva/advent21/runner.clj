(ns slva.advent21.runner
  (:require [clojure.java.io :refer [resource]])
  (:import (java.io FileNotFoundException)))

;; TODO: Dynamically source from advent of code
(defn- read-input [day]
  (slurp (resource (str "inputs/day" day ".txt"))))

(defn- day-require [day part target]
  (->
   (str "slva.advent21.day" day ".part" part)
   (symbol target)
   requiring-resolve))

(defn- wrap-func [name func]
  (fn [& args]
    (let [start (System/nanoTime)]
      (println "Starting to " name)
      (let [res (apply func args)]
        (println "It took " (/ 1000000.0 (- (System/nanoTime) start)) "ms")
        res))))

(defn- get-day-refs [day part]
  [(wrap-func "parsing" (day-require day part "parse-input"))
   (wrap-func "calculating" (day-require day part "calculate"))])

(defn- run-day [{:keys [day part]}]
  (let [[parse calculate] (get-day-refs day part)
        input (read-input day)]
    (->> (parse input)
         (calculate))))

(defn validate-args [dayStr partStr]
  (when (= nil dayStr)
    (throw (RuntimeException. "Missing day")))
  (when (= nil partStr)
    (throw (RuntimeException. "Missing part")))
  (let [day (Integer/parseInt dayStr)
        part (Integer/parseInt partStr)]
    (when (<= day 0)
      (throw (RuntimeException. "Day less than or 0")))
    (when (<= part 0)
      (throw (RuntimeException. "Part less than or 0")))
    (when (> part 2)
      (throw (RuntimeException. "Part more then 2")))))

(defn parse-args [[day part]]
  (validate-args day part)
  {:day day :part part})

(defn -main [& args]
  (try
    (->>
     (run-day (parse-args args))
     println)
    (catch RuntimeException e
      (println (.getMessage e))
      (println "Usage: ./executable [day] [part]"))
    (catch FileNotFoundException _ex
      (println (str "Did not found input for day")))))
