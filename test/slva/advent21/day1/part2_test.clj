(ns slva.advent21.day1.part2-test
  (:require [clojure.test :refer [deftest is testing]]
            [slva.advent21.day1.part2 :refer [calculate]]))

(deftest no-input
  (testing "No input"
    (is (= 0 (calculate [])))))

(deftest valid-inputs
  (testing "not increasing"
    (is (= 0 (calculate [1 1 1]))))
  (testing "decreasing"
    (is (= 0 (calculate [99 22 11]))))
  (testing "increasing"
    (is (= 1 (calculate [1 1 2 4]))))
  (testing "increasing and not"
    (is (= 5 (calculate [1 1 2 2 2 66 50 30 55])))))
