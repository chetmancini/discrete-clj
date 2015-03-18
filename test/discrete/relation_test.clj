(ns discrete.relation-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as jio]
            [discrete.relation :refer :all]))

(def water-west-of
  (->> (jio/resource "water_west_of.edn") slurp read-string))

(deftest is-related-to-test
  (testing "relations work"
    (is (not (is-related-to? :foo :bar #{})))
    (is (is-related-to? :two :bar #{[:one :foo] [:two :bar]}))))

(deftest transitive-test-one-pair-test
  (testing "one-pair works"
    (is (transitive-test-one-pair [:a :b] []))
    (is (transitive-test-one-pair [:mediterranean :jordan] water-west-of))))

(deftest is-transitive-test
  (testing "transitivity calc works"
    (is (is-transitive? []))
    (is (is-transitive? water-west-of))))

(deftest image-test
  (testing "image on relation"
    (is (= [1 3] (image 5 [[5 1] [2 2] [5 3]])))))

(deftest add-image-test
  (testing "add image"
    (is (= [[5 1] [5 2] [5 3]] (add-image 5 [1 2 3])))))

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