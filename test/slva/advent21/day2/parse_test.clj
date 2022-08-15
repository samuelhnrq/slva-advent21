(ns slva.advent21.day2.parse-test
  (:require [clojure.test :refer :all]
            [slva.advent21.day2.parse :refer [->Action parse-input]]))

(deftest parses-correctly
  (testing "sample input"
    (is (= [(->Action :forward 1)
            (->Action :down 32)
            (->Action :down 4)]
           (parse-input "forward 1\ndown 32\ndown 4")))))
