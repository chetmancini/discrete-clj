(ns discrete.cardinality
  (:require [clojure.math.numeric-tower :as math]
            [discrete.utils :refer :all]))

(defn- next-pair [[a b]] 
  (cond
    (and (= a 1) (= 1 (mod b 2))) [1 (+ b 1)]
    (and (= b 1) (= 0 (mod a 2))) [(+ a 1) 1]
    (= 1 (mod (+ a b) 2)) [(+ a 1) (- b 1)]
    :else [(- a 1) (+ b 1)]))

(defn find-room 
  "For a given bus number and seat number, which room in the hotel should they be assigned?"
  [bus-num seat-num]
  (let [find-room-helper (fn [i current-pair]
                           (if (not= current-pair [bus-num seat-num])
                             (recur (+ i 1) (next-pair current-pair))
                             i))]
    (find-room-helper 1 [1 1])))


(defn find-bus-seat
  "Given a room, which bus and which seat should they get?"
  [room]
  (let [find-bus-seat-helper (fn [i current-pair]
                               (if (not= i room)
                                 (recur (+ 1 i) (next-pair current-pair))
                                 current-pair))]
    (find-bus-seat-helper 1 [1 1])))

(defn cantor-diagonal [n]
  (let [reduce-by-gcd (fn [[a b]]
                        (let [com-denom (math/gcd a b)]
                          [(quot a com-denom) (quot b com-denom)]))
        next-new-ratio (fn [old-ratio used-list]
                         (let [new-ratio (next-pair old-ratio)]
                           (if (in? used-list (reduce-by-gcd new-ratio))
                             (recur new-ratio used-list)
                             new-ratio)))
        find-ratio (fn [i current-ratio used-list]
                     (if (< i n)
                       (recur (+ i 1) (next-new-ratio current-ratio used-list) (cons current-ratio used-list))
                       current-ratio))]
    (find-ratio 1 [1 1] [])))

