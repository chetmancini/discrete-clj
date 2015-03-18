(ns discrete.relation
  (:require [discrete.utils :refer :all]))

(defn is-related-to? [a b relation]
  (in? relation [a b]))

(defn transitive-test-one-pair [[a b] relation]
  (if (empty? relation)
    true
    (let [[c d] (first relation)]
      (and (or (not= b c) (is-related-to? a d relation)) 
           (recur [a b] (rest relation))))))

(defn is-transitive? [relation]
  (if (empty? relation)
    true
    (and (transitive-test-one-pair (first relation) relation) (recur (rest relation)))))
 
(defn image [element relation]
  [])

(defn add-image [element relation-set]
  (add-to-all element relation-set))

(defn compose [relation-a relation-b]
  [])

(defn counter-transitive [relation]
  [])

(defn transitive-closure [relation]
  (if (is-transitive relation)
    relation
    (recur (into (distinct (counter-transitive relation)) relation))))

(defn list-to-predicate [relation]
  (fn [a b] (is-related-to? a b relation)))

(defn reflexive-closure [relation-fn]
  (fn [a b] (or (= a b) (relation-fn a b))))

(defn is-symmetric? [relation]
  true)

(defn is-anti-symmetric? [relation]
  true)

(defn is-reflexive? [relation]
  true)

(defn counter-symmetric [relation]
  [])

(defn counter-anti-symmetric [relation]
  [])

