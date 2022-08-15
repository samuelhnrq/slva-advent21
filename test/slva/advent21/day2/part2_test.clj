(ns slva.advent21.day2.part2-test
  (:require [clojure.test :refer :all]
            [slva.advent21.day2.parse :refer [->Action]]
            [slva.advent21.day2.part2 :refer [calculate]]))

(deftest calculate-simple
  (testing "simple functionality"
    (is (= 0 (calculate [(->Action :up 0)
                         (->Action :forward 0)]))
        "Empty inputs")
    (is (= 45 (calculate [(->Action :down 5)
                          (->Action :forward 3)]))
        "Simplest input possible")
    (is (= 18 (calculate [(->Action :down 4)
                          (->Action :up 2)
                          (->Action :forward 3)]))
        "Multiple & varied verticals")
    (is (= 64 (calculate [(->Action :down 2)
                          (->Action :down 2)
                          (->Action :forward 4)]))
        "Multiple equal verticals")
    (is (= 32 (calculate [(->Action :down 2)
                          (->Action :forward 2)
                          (->Action :forward 2)]))
        "Multiple horizontals")
    (is (= 32 (calculate [(->Action :down 4)
                          (->Action :up 2)
                          (->Action :forward 3)
                          (->Action :forward 1)]))
        "All the types")))

(deftest edge-cases
  (testing "no input"
    (is (= 0 (calculate [])))))
