(ns discrete.peano-test
  (:require [clojure.test :refer :all]
            [discrete.peano :refer :all]))

(deftest succ-test
  (testing "succ returns the successor to a peano number"
    (let [peano (one-plus zero)]
    	(is (= (succ peano) [:one-plus :one-plus :zero])))))

(deftest pred-test
  (testing "pred returns the predecessor to a peano number"
    (let [peano (one-plus zero)]
    	(is (= (pred peano) [:zero])))))

(deftest as-peano-number-test
  (testing "converts an integer to a peano number"
    (is (= (as-peano-number 2) [:one-plus :one-plus :zero]))))

(deftest as-integer-test
  (testing "converts a peano number to an integer"
    	(is (= (as-integer [:one-plus :one-plus :zero]) 2))))

