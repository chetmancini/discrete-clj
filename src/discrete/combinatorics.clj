(ns discrete.combinatorics
  (:require [clojure.math.combinatorics :as combo]))

; (defn combos [values r]
;   (cond
;     (empty? values) []
;     (= 0 r) []
;     (= 1 r) (listify values)
;     :else (into (add-to-all (first values) (recur (rest values) (- r 1))) 
;                 (recur (rest values r)))))
