(ns slva.advent21.runner
  (:require [clojure.java.io :refer [resource]])
  (:import (clojure.lang ExceptionInfo)
           (java.io FileNotFoundException))
  (:gen-class))

;; TODO: Dynamically source from advent of code
(defn- read-input [day]
  (println "Fetching input from classpath for day" day)
  (slurp (resource (str "inputs/day" day ".txt"))))

(defn- calculate-require [day part]
  (->
   (str "slva.advent21.day" day ".part" part)
   (symbol "calculate")
   requiring-resolve))

(defn- parse-require [day]
  (->
   (str "slva.advent21.day" day ".parse")
   (symbol "parse-input")
   requiring-resolve))

(defn- wrap-func [name func]
  (fn [& args]
    (let [start (System/nanoTime)]
      (println "Starting to" name)
      (let [res (apply func args)]
        (printf "It took %.4f ms\n" (/ 1000000.0 (- (System/nanoTime) start)))
        res))))

(defn- get-day-refs [day part]
  [(wrap-func "parse input" (parse-require day))
   (wrap-func "calculate" (calculate-require day part))])

(defn run-day [{:keys [day part]}]
  (let [[parse calculate] (get-day-refs day part)
        input (read-input day)]
    (->> (parse input)
         (calculate))))

(defn validate-args [dayStr partStr]
  (when (= nil dayStr)
    (throw (ex-info "Missing day" {})))
  (when (= nil partStr)
    (throw (ex-info "Missing part" {})))
  (let [day (Integer/parseInt dayStr)
        part (Integer/parseInt partStr)]
    (when (<= day 0)
      (throw (ex-info "Day less than or 0" {})))
    (when (<= part 0)
      (throw (ex-info "Part less than or 0" {})))
    (when (> part 2)
      (throw (ex-info "Part more then 2" {})))))

(defn parse-args [[day part]]
  (validate-args day part)
  {:day day :part part})

(defn -main [& args]
  (try
    (->>
     (run-day (parse-args args))
     println)
    (catch ExceptionInfo e
      (println (.getMessage e))
      (println "Usage: ./executable [day] [part]"))
    (catch FileNotFoundException _ex
      (println (str "Did not found input for given day")))))
