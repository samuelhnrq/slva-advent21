(ns slva.advent21.day3.parse-test
  (:require [clojure.test :refer [deftest testing is]]
            [slva.advent21.day3.parse :refer [parse-input]]))

(deftest parses-correctly
  (testing "sample input"
    (is (= [0 0 0 0 0 1 1 1 1 1 1 0 1 0 1]
           (parse-input "00000\n11111\n10101")))))
