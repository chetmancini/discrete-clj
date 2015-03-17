(ns discrete.cardinality-test
  (:require [clojure.test :refer :all]
            [discrete.cardinality :refer :all]))

(deftest find-room-test
  (testing "find room returns the correct room number"
    (is (= 1 (find-room 1 1)))
    (is (= 8 (find-room 2 3)))
    (is (= 15 (find-room 1 5)))))


(deftest find-bus-seat-test
  (testing "find bus seat calculates the inverse"
    (is (= [1 1] (find-bus-seat 1)))
    (is (= [2 3] (find-bus-seat 8)))
    (is (= [1 5] (find-bus-seat 15)))))