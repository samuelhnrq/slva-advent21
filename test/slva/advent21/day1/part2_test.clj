(ns slva.advent21.day1.part2-test
  (:require [clojure.test :refer [deftest is testing]]
            [slva.advent21.day1.part2 :refer [calculate parse-input]]))

(deftest no-input
  (testing "No input"
    (is (= 0 (calculate [])))))

(deftest valid-inputs
  (testing "not increasing"
    (is (= 0 (calculate [1 1 1]))))
  (testing "decreasing"
    (is (= 0 (calculate [99 22 11]))))
  (testing "increasing"
    (is (= 1 (calculate [1 1 2]))))
  (testing "increasing and not"
    (is (= 3 (calculate [1 1 2 2 2 66 50 30 55])))))

(deftest parses-inputs
  (testing "single line"
    (is (= [1] (parse-input "1"))))
  (testing "empty input"
    (is (= [] (parse-input ""))))
  (testing "multiple lines"
    (is (= [1 2] (parse-input "1\n2")))))
