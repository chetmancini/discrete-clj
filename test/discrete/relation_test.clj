(ns discrete.relation-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as jio]
            [discrete.relation :refer :all]))

(def water-west-of
  (->> (jio/resource "water_west_of.edn") slurp read-string))

(deftest is-related-to-test
  (testing "relations work"
    (is (is-related-to? :two :bar #{[:one :foo] [:two :bar]}))))

(deftest transitive-test-one-pair-test
  (testing "one-pair works"
    (is (transitive-test-one-pair [:mediterranean :jordan] water-west-of))))

(deftest is-transitive-test
  (testing "transitivity calc works"
    (is (is-transitive? water-west-of))))

(deftest add-image-test
  (testing "add image"
    (is (= [[5] [5 4] [5 2 3]] (add-image 5 [[] [4] [2 3]])))))

(deftest compose-test
  (testing "compose two relations"))

(deftest counter-transitive-test
  (testing "counter transitive"))

(deftest transitive-closure-test
  (testing "returns the transitive closure"))

(deftest is-symmetric-test
  (testing "return if relation is symmetric"))

(deftest is-anti-symmetric-test
  (testing "return if relation is antisymmetric"))

(deftest is-reflexive-test
  (testing "return if a relation is reflexive"))

(deftest counter-symmetric-test
  (testing "counter symmetric"))

(deftest counter-anti-symmetric-test
  (testing "counter antisymmetric"))