(ns discrete.relation
  (:require [discrete.utils :refer :all]))

(defn test-one-pair [[a b] relations]
  (if (empty? relations)
    true
    :else true))
    ;testOnePair((a, b), (c, d)::rest) =
	;((not (b = c)) orelse isRelatedTo(a, d, relation)) andalso testOnePair((a,b), rest)))

(defn test-all []) 
 
(defn is-related-to [a b relations])

(defn image [element relation]
  [])

(defn add-image [element relation-set]
  (add-to-all element relation-set))

(defn compose [relation-a relation-b]
  [])

(defn is-transitive [relation]
  true)

(defn counter-transitive [relation]
  [])

(defn transitive-closure [relation]
  (if (is-transitive relation)
    relation
    (recur (into (distinct (counter-transitive relation)) relation))))