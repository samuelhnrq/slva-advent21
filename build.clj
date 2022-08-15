(ns build
  (:refer-clojure :exclude [test])
  (:require [org.corfield.build :as bb]))

(def lib 'slva/advent21)
(def version "0.1.0-SNAPSHOT")
(def main 'slva.advent21.runner)

(defn ci "Run the CI pipeline of tests (and build the uberjar)." [opts]
      (-> opts
          (assoc :lib lib :main main :version version)
          ; Current github actions runs tests separetly for coverage
          ; (bb/run-tests)
          (bb/clean)
          (bb/uber)))
