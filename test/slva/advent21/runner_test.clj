(ns slva.advent21.runner-test
  (:require [slva.advent21.runner :as target]
            [clojure.test :refer [deftest is testing]]))

(deftest validates-input
  (testing "invalid day"
    (is (thrown-with-msg? RuntimeException #"(?i)day"
                          (target/validate-args "-2" "1"))))
  (testing "invalid part"
    (is (thrown-with-msg? RuntimeException #"(?i)part"
                          (target/validate-args "1" "-1"))))
  (testing "missing day"
    (is (thrown-with-msg? RuntimeException #"(?i)day"
                          (target/validate-args nil "1"))))
  (testing "missing part"
    (is (thrown-with-msg? RuntimeException #"(?i)part"
                          (target/validate-args "1" nil)))))
