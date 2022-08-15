(ns slva.advent21.day2.part1-test
  (:require [clojure.test :refer :all]
            [slva.advent21.day2.parse :refer [->Action]]
            [slva.advent21.day2.part1 :refer [calculate]]))

(deftest calculate-simple
  (testing "simple functionality"
    (is (= 0 (calculate [(->Action :up 0)
                         (->Action :forward 0)])))
    (is (= 4 (calculate [(->Action :down 2)
                         (->Action :forward 2)])))
    (is (= 4 (calculate [(->Action :down 4)
                         (->Action :up 2)
                         (->Action :forward 2)])))
    (is (= 8 (calculate [(->Action :down 2)
                         (->Action :down 2)
                         (->Action :forward 2)])))
    (is (= 8 (calculate [(->Action :down 2)
                         (->Action :forward 2)
                         (->Action :forward 2)])))))

(deftest edge-cases
  (testing "no input"
    (is (= 0 (calculate [])))))
