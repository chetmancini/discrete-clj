(ns discrete.relation
  (:require [discrete.utils :refer :all]))

(defn is-related-to? 
  "Is this pair contained in this relation?"
  [a b relation]
  (in? relation [a b]))

(defn transitive-test-one-pair [[a b] relation]
  (if (empty? relation)
    true
    (let [[c d] (first relation)]
      (and (or (not= b c) (is-related-to? a d relation)) 
           (recur [a b] (rest relation))))))

(defn is-transitive? 
  "Is this relation transitive?"
  [relation]
  (if (empty? relation)
    true
    (and (transitive-test-one-pair (first relation) relation) (recur (rest relation)))))
 
(defn image 
  "takes an element and a relation and returns the image of the element over the relation"
  [element relation]
  (map (fn [[a b]] b) (filter (fn [[a b]] (= a element)) relation)))

(defn add-image 
  "takes an element (x) and a set and returns a relation R with 
  the property that the image of x under R is the set"
  [element relation-set]
  (add-to-all element (listify relation-set)))

(defn compose
  "Componse two relations."
  [relation-ab relation-bc]
  (mapcat (fn [[a b]] (add-image a (image b relation-bc))) relation-ab))

(defn counter-transitive [relation]
  nil)

(defn transitive-closure [relation]
  (if (is-transitive? relation)
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

