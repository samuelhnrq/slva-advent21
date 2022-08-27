(ns slva.advent21.runner-test
  (:require [clojure.test :refer [deftest is testing]]
            [slva.advent21.runner :as target])
  (:import (clojure.lang ExceptionInfo)))

(deftest parses-input
  (testing "Validates invalid input"
    (is (thrown? ExceptionInfo (target/parse-args ["-1" "2"]))))
  (testing "into a map"
    (is (= {:day "1" :part "2"}
           (target/parse-args ["1" "2"])))))

(deftest validates-input
  (testing "missing day"
    (is (thrown-with-msg? ExceptionInfo #"(?i)day"
                          (target/validate-args nil "1"))))
  (testing "invalid day"
    (is (thrown-with-msg? ExceptionInfo #"(?i)day"
                          (target/validate-args "-2" "1"))))
  (testing "invalid part"
    (is (thrown-with-msg? ExceptionInfo #"(?i)part"
                          (target/validate-args "1" "42")))
    (is (thrown-with-msg? ExceptionInfo #"(?i)part"
                          (target/validate-args "1" "-1"))))
  (testing "missing day"
    (is (thrown-with-msg? ExceptionInfo #"(?i)day"
                          (target/validate-args nil "1"))))
  (testing "missing part"
    (is (thrown-with-msg? ExceptionInfo #"(?i)part"
                          (target/validate-args "1" nil)))))

(deftest imports-correct-day
  (testing "day dynamic require"
    (is (with-redefs [requiring-resolve (constantly (constantly "day1"))
                      printf (constantly nil)
                      println (constantly nil)]
          (= "day1" (target/run-day {:day 1 :part 1}))))))
