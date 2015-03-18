(ns discrete.function-test
  (:require [clojure.test :refer :all]
            [discrete.function :refer :all]))

(deftest list-to-fn-test
  (testing "convert a list to a function"
    (is (= "b" ((list-to-fn ["a" "b" "c" "d"]) 1)))))