(ns slva.advent21.day1.parse-test
  (:require [clojure.test :refer :all]
            [slva.advent21.day1.parse :refer [parse-input]]))

(deftest parses-inputs
  (testing "single line"
    (is (= [1] (parse-input "1"))))
  (testing "empty input"
    (is (= [] (parse-input ""))))
  (testing "multiple lines"
    (is (= [1 2] (parse-input "1\n2")))))
