(ns slva.advent21.day3.part1-test
  (:require [clojure.test :refer :all]
            [slva.advent21.day3.part1 :refer [calculate input-size]]))

(deftest calculate-simple
  (testing "simple functionality"
    (is (= 234
           (with-redefs [input-size 5]
             (calculate [1 0 0 1 0
                         1 0 0 0 0
                         0 1 1 1 1
                         1 0 0 1 0])))))
  (testing "odd number of inputs"
    (is (= 234
           (with-redefs [input-size 5]
             (calculate [1 0 0 1 0
                         1 0 0 0 0
                         0 1 1 1 1]))))))

(deftest edge-cases
  (testing "no input"
    (is (= 0 (calculate [])))))
