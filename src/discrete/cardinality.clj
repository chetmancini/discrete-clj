(ns discrete.cardinality
  (:require [clojure.math.numeric-tower :as math]))

(defn find-room [bus-num seat-num]
  (let [next-pair (fn [[a b]]
                    (cond
                      (and (= a 1) (= 1 (mod b 2))) [1 (+ b 1)]
                      (and (= b 1) (= 0 (mod a 2))) [(+ a 1) 1]
                      (= 1 (mod (+ a b) 2)) [(+ a 1) (- b 1)]
                      :else [(- a 1) (+ b 1)]))
        find-room-helper (fn [i current-pair]
                           (if (not= current-pair [bus-num seat-num])
                             (recur (+ i 1) (next-pair current-pair))
                             i))]
    (find-room-helper 1 [1 1])))


(defn find-bus-seat [room]
  (let [next-pair (fn [[a b]]
                    (cond 
                      (and (= a 1) (= 1 (mod b 2))) [1 (+ b 1)]
                      (and (= b 1) (= 0 (mod a 2))) [(+ a 1) 1]
                      (= 1 (mod (+ a b) 2)) [(+ a 1) (- b 1)]
                      :else [(- a 1) (+ b 1)]))
        find-bus-seat-helper (fn [i current-pair]
                               (if (not= i room)
                                 (recur (+ 1 i) (next-pair current-pair))
                                 current-pair))]
    (find-bus-seat-helper 1 [1 1])))

(defn cantor-diagonal [n]
  (let [reduce-by-gcd (fn [[a b]]
                        (let [com-denom (math/gcd a b)]
                          [(quot a com-denom) (quot b com-denom)]))
        next-ratio (fn [[a b]]
                     (cond
                       (and (= a 1) (= 1 (mod b 2))) [1 (+ b 1)]
                       (and (= b 1) (= 0 (mod a 2))) [(+ a 1) 1]
                       (= 1 (mod (+ a b) 2)) [(+ a 1) (- b 1)]
                       :else [(- a 1) (+ b 1)]))
        contains-ratio? (fn [[a b] in-list]
                          (if (empty? in-list)
                            false
                            (let [[c d] (first in-list)]
                              (if (and (= a c) (= b d))
                                true
                                (recur [a b] (rest in-list))))))
        next-new-ratio (fn [old-ratio used-list]
                         (let [new-ratio (next-ratio old-ratio)]
                           (if (contains-ratio? (reduce-by-gcd new-ratio) used-list)
                             (recur new-ratio used-list)
                             new-ratio)))
        find-ratio (fn [i current-ratio used-list]
                     (if (< i n)
                       (recur (+ i 1) (next-new-ratio current-ratio used-list) (cons current-ratio used-list))
                       current-ratio))]
    (find-ratio 1 [1 1] [])))

