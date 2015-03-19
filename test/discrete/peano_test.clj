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

(deftest minus-test
  (testing "subtraction"
    (is (= (as-peano-number 1) (minus (as-peano-number 3) (as-peano-number 2))))))

(deftest plus-test
  (testing "addition"
    (is (= (as-peano-number 5) (plus (as-peano-number 2) (as-peano-number 3))))))

(deftest multiply-test
  (testing "multiplication"
    (is (= (as-peano-number 6) (multiply (as-peano-number 2) (as-peano-number 3))))))

(deftest divide-test
  (testing "division"
    (is (= (as-peano-number 2) (divide (as-peano-number 6) (as-peano-number 3))))))\

(deftest modulo-test
  (testing "modulus"
    (is (= (as-peano-number 2) (modulo (as-peano-number 17) (as-peano-number 5))))))

(deftest is-even-test
  (testing "is even"
    (is (is-even? (as-peano-number 0)))
    (is (is-even? (as-peano-number 6)))
    (is (not (is-even? (as-peano-number 5))))))

