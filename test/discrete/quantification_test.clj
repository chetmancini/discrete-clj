(ns discrete.quantification-test
    (:require [clojure.test :refer :all]
            [discrete.quantification :refer :all]))

(deftest all-have-divisor-test
  (testing "all have divisor"
    (is (all-have-divisor? [5 10 15] [5]))
    (is (not (all-have-divisor? [4 10 14] [5])))))